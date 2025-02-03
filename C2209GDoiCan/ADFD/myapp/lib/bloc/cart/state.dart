part of './bloc.dart';
/// Các trạng thái của CartBloc
enum CartStatus { initial, loading, success, failure }

class CartState extends Equatable {
  final CartStatus status;
  final String message;
  final int cartItemCount;
  final List<CartItemResponse> cartItems; // Danh sách sản phẩm trong giỏ hàng

  const CartState({
    this.status = CartStatus.initial,
    this.message = "",
    this.cartItemCount = 0,
    this.cartItems = const [],
  });

  CartState copyWith({
    CartStatus? status,
    String? message,
    int? cartItemCount,
    List<CartItemResponse>? cartItems,
  }) {
    return CartState(
      status: status ?? this.status,
      message: message ?? this.message,
      cartItemCount: cartItemCount ?? this.cartItemCount,
      cartItems: cartItems ?? this.cartItems,
    );
  }

  @override
  List<Object?> get props => [status, message, cartItemCount, cartItems];
}

