class CartItemCreateRequest {
  final int cartId;
  final int productVariantId;
  final int quantity;

  CartItemCreateRequest({
    required this.cartId,
    required this.productVariantId,
    required this.quantity,
  });

  Map<String, dynamic> toJson() {
    return {
      'cart_id': cartId,
      'product_variant_id': productVariantId,
      'quantity': quantity,
    };
  }
}
