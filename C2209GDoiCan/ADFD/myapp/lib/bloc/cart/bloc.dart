import 'package:equatable/equatable.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:myapp/dtos/requests/cart.dart';
import 'package:myapp/dtos/requests/cart_item_create.dart';
import 'package:myapp/dtos/responses/cart_item.dart';
import 'package:myapp/models/cart_item.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
import 'package:myapp/services/cart_item_service.dart';
import 'package:myapp/services/cart_service.dart';

part 'event.dart';
part 'state.dart';
/// Bloc xử lý các hành động liên quan đến giỏ hàng
class CartBloc extends Bloc<CartEvent, CartState> {
  final CartService cartService;
  final CartItemService cartItemService;
  final LocalStorageRepository localStorageRepository;

  CartBloc({
    required this.cartService,
    required this.cartItemService,
    required this.localStorageRepository,
  }) : super(const CartState()) {
    on<AddToCart>(_onAddToCart);
    on<FetchCartItemsCount>(_onFetchCartItemsCount);
    on<FetchCartItems>(_onFetchCartItems);
    on<RemoveFromCart>(_onRemoveFromCart);
  }

  Future<void> _onAddToCart(AddToCart event, Emitter<CartState> emit) async {
    emit(state.copyWith(status: CartStatus.loading));
    try {
      // Lấy token từ LocalStorageRepository
      final token = await localStorageRepository.getToken();

      // Kiểm tra xem trong Local Storage đã có cart id chưa
      int? storedCartId = await localStorageRepository.getCartId();
      int actualCartId;
      if (storedCartId == null) {
        // Lấy user id từ local storage
        int? storedUserId = await localStorageRepository.getUserId();
        if (storedUserId == null) {
          // Nếu userId null, dùng session id
          String? sessionId = await localStorageRepository.getSessionId();
          if (sessionId == null) {
            sessionId = localStorageRepository.generateSessionId();
            await localStorageRepository.saveSessionId(sessionId);
          }

          // Tạo giỏ hàng mới với sessionId
          final cartRequest = CartRequest(sessionId: sessionId);
          final cartResponse = await cartService.createCart(
            request: cartRequest,
            token: token,
          );
          actualCartId = cartResponse.id;
          // Lưu cart id vào Local Storage
          await localStorageRepository.saveCartId(actualCartId);
        } else {
          // Nếu user id đã tồn tại, tạo giỏ hàng với userId
          final cartRequest = CartRequest(userId: storedUserId);
          final cartResponse = await cartService.createCart(
            request: cartRequest,
            token: token,
          );
          actualCartId = cartResponse.id;
          await localStorageRepository.saveCartId(actualCartId);
        }
      } else {
        actualCartId = storedCartId;
      }

      // Gọi API thêm mục vào giỏ hàng với CartItemService
      final cartItemRequest = CartItemCreateRequest(
        cartId: actualCartId,
        productVariantId: event.productVariantId,
        quantity: event.quantity,
      );
      await cartItemService.createCartItem(
        requestData: cartItemRequest,
        token: token,
      );

      emit(state.copyWith(
        status: CartStatus.success,
        message: "Sản phẩm đã được thêm vào giỏ hàng",
      ));
    } catch (e) {
      emit(state.copyWith(
        status: CartStatus.failure,
        message: "Lỗi khi thêm vào giỏ hàng: $e",
      ));
    }
  }
  Future<void> _onFetchCartItemsCount(FetchCartItemsCount event, Emitter<CartState> emit) async {
    try {
      final itemCount = await cartService.getCartItemCount();
      emit(state.copyWith(status: CartStatus.success, cartItemCount: itemCount));
    } catch (e) {
      emit(state.copyWith(status: CartStatus.failure, message: "Lỗi khi lấy giỏ hàng"));
    }
  }
  Future<void> _onFetchCartItems(FetchCartItems event, Emitter<CartState> emit) async {
    emit(state.copyWith(status: CartStatus.loading));
    try {
      final List<CartItemResponse> cartItems= await cartService.fetchCartDetails();
      // Tính tổng số lượng sản phẩm trong giỏ hàng
      int totalQuantity = cartItems.fold(0, (sum, item) => sum + item.quantity);

      emit(state.copyWith(
        status: CartStatus.success,
        cartItems: cartItems,
        cartItemCount: totalQuantity,
      ));
    } catch (e) {
      emit(state.copyWith(
        status: CartStatus.failure,
        message: "Lỗi khi lấy danh sách giỏ hàng: $e",
      ));
    }
  }
  Future<void> _onRemoveFromCart(
      RemoveFromCart event, Emitter<CartState> emit) async {
    try {
      emit(state.copyWith(status: CartStatus.loading));

      // Lấy token nếu có user đăng nhập
      String? token = await localStorageRepository.getToken();

      // Gọi API xóa sản phẩm khỏi giỏ hàng
      await cartItemService.deleteCartItem(id: event.cartItemId, token: token);

      // Sau khi xóa, tải lại danh sách giỏ hàng
      add(FetchCartItems());
    } catch (e) {
      emit(state.copyWith(
        status: CartStatus.failure,
        message: "Xóa sản phẩm thất bại: $e",
      ));
    }
  }
}
