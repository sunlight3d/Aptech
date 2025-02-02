part of './bloc.dart';
/// Các trạng thái của CartBloc
enum CartStatus { initial, loading, success, failure }

class CartState extends Equatable {
  final CartStatus status;
  final String message;

  const CartState({
    this.status = CartStatus.initial,
    this.message = "",
  });

  CartState copyWith({CartStatus? status, String? message}) {
    return CartState(
      status: status ?? this.status,
      message: message ?? this.message,
    );
  }

  @override
  List<Object?> get props => [status, message];
}
