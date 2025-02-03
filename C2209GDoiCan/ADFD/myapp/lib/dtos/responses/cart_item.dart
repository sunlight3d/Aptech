import 'package:myapp/models/variant.dart';

class CartItemResponse {
  final int id;
  final int productVariantId;
  final double price;
  final int stock;
  final double oldPrice;
  final int quantity;
  final String productName;
  final String productImage;
  final List<Variant> variants;

  CartItemResponse({
    required this.id,
    required this.productVariantId,
    required this.price,
    required this.stock,
    required this.oldPrice,
    required this.quantity,
    required this.productName,
    required this.productImage,
    required this.variants,
  });

  factory CartItemResponse.fromJson(Map<String, dynamic> json) {
    return CartItemResponse(
      id: json['id'] as int,
      productVariantId: json['product_variant_id'] as int,
      price: double.tryParse(json['price'] ?? "0") ?? 0,
      stock: json['stock'] as int? ?? 0,
      oldPrice: double.tryParse(json['old_price'] ?? "0") ?? 0,
      quantity: json['quantity'] as int? ?? 0,
      productName: json['product_name'] as String? ?? '',
      productImage: json['product_image'] as String? ?? '',
      variants: (json['variants'] as List<dynamic>?)
          ?.map((variant) => Variant.fromJson(variant))
          .toList() ?? [],
    );
  }
}
