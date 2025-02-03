import 'package:myapp/models/product_variant_value.dart';
import 'package:myapp/models/variant.dart';

/// DTO cho từng mục trong giỏ hàng
class CartItem {
  final int id;
  final int? cartId;
  final int productVariantId;
  final int quantity;
  final DateTime? createdAt;
  final DateTime? updatedAt;
  final ProductVariantValue? productVariantValue;
  final List<Variant> variants; // Thêm danh sách biến thể

  CartItem({
    required this.id,
    this.cartId,
    required this.productVariantId,
    required this.quantity,
    this.createdAt,
    this.updatedAt,
    this.productVariantValue,
    required this.variants, // Bắt buộc có danh sách biến thể
  });

  factory CartItem.fromJson(Map<String, dynamic> json) {
    return CartItem(
      id: json['id'] as int,
      cartId: json['cart_id'] != null ? json['cart_id'] as int : null,
      productVariantId: json['product_variant_id'] as int,
      quantity: (json['quantity'] ?? 0) as int,
      createdAt: json['created_at'] != null ? DateTime.tryParse(json['created_at']) : null,
      updatedAt: json['updated_at'] != null ? DateTime.tryParse(json['updated_at']) : null,
      productVariantValue: json['product_variant_value'] != null
          ? ProductVariantValue.fromJson(json['product_variant_value'])
          : null,
      variants: (json['variants'] as List<dynamic>?)
          ?.map((variant) => Variant.fromJson(variant))
          .toList() ??
          [], // Nếu `null` thì gán danh sách rỗng
    );
  }
}
