import 'package:myapp/models/product_variant_value.dart';

/// DTO cho từng mục trong giỏ hàng
class CartItem {
  final int id;
  final int cartId;
  final int productVariantId;
  final int quantity;
  final DateTime createdAt;
  final DateTime updatedAt;
  final ProductVariantValue productVariantValue;

  CartItem({
    required this.id,
    required this.cartId,
    required this.productVariantId,
    required this.quantity,
    required this.createdAt,
    required this.updatedAt,
    required this.productVariantValue,
  });

  factory CartItem.fromJson(Map<String, dynamic> json) {
    return CartItem(
      id: json['id'] as int,
      cartId: json['cart_id'] as int,
      productVariantId: json['product_variant_id'] as int,
      quantity: json['quantity'] as int,
      createdAt: DateTime.parse(json['created_at'] as String),
      updatedAt: DateTime.parse(json['updated_at'] as String),
      productVariantValue:
      ProductVariantValue.fromJson(json['product_variant_value']),
    );
  }
}