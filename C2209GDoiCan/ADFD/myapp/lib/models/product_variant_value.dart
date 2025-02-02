import 'package:myapp/models/product.dart';
import 'package:myapp/models/variant.dart';

/// Lớp chứa thông tin chi tiết về giá trị của sản phẩm trong giỏ hàng
class ProductVariantValue {
  final int id;
  final double price;
  final double oldPrice;
  final int stock;
  final String sku;
  final Product product;
  final List<Variant> variants;

  ProductVariantValue({
    required this.id,
    required this.price,
    required this.oldPrice,
    required this.stock,
    required this.sku,
    required this.product,
    required this.variants,
  });

  factory ProductVariantValue.fromJson(Map<String, dynamic> json) {
    return ProductVariantValue(
      id: json['id'] as int,
      price: double.parse(json['price']),
      oldPrice: double.parse(json['old_price']),
      stock: json['stock'] as int,
      sku: json['sku'] as String,
      product: Product.fromJson(json['product']),
      variants: (json['variants'] as List)
          .map((item) => Variant.fromJson(item))
          .toList(),
    );
  }
}