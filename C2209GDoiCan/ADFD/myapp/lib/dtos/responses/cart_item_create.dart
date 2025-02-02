class CartItemCreateResponse {
  final int id;
  final int productVariantId;
  final int quantity;
  final int cartId;
  final DateTime updatedAt;
  final DateTime createdAt;

  CartItemCreateResponse({
    required this.id,
    required this.productVariantId,
    required this.quantity,
    required this.cartId,
    required this.updatedAt,
    required this.createdAt,
  });

  factory CartItemCreateResponse.fromJson(Map<String, dynamic> json) {
    return CartItemCreateResponse(
      id: json['id'] as int,
      productVariantId: json['product_variant_id'] as int,
      quantity: json['quantity'] as int,
      cartId: json['cart_id'] as int,
      updatedAt: DateTime.parse(json['updated_at'] as String),
      createdAt: DateTime.parse(json['created_at'] as String),
    );
  }
}
