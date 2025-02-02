import 'package:equatable/equatable.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:myapp/dtos/requests/cart.dart';
import 'package:myapp/dtos/requests/cart_item_create.dart';
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
}
