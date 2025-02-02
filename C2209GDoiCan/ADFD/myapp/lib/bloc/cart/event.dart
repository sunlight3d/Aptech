part of './bloc.dart';
/// Các sự kiện của CartBloc
abstract class CartEvent extends Equatable {
  const CartEvent();
  @override
  List<Object?> get props => [];
}

class AddToCart extends CartEvent {
  final int productVariantId;
  final int quantity;
  const AddToCart({
    required this.productVariantId,
    required this.quantity,
  });

  @override
  List<Object?> get props => [productVariantId, quantity];
}
