import 'package:equatable/equatable.dart';

class ProductVariant extends Equatable {
  final int id;
  final double price;
  final double oldPrice;
  final int stock;
  final String sku;
  final List<Map<String, dynamic>> values;

  const ProductVariant({
    required this.id,
    required this.price,
    required this.oldPrice,
    required this.stock,
    required this.sku,
    required this.values,
  });

  factory ProductVariant.fromJson(Map<String, dynamic> json) {
    return ProductVariant(
      id: json['id'] ?? 0,
      price: double.tryParse(json['price']?.toString() ?? "0.0") ?? 0.0,
      oldPrice: double.tryParse(json['old_price']?.toString() ?? "0.0") ?? 0.0,
      stock: json['stock'] ?? 0,
      sku: json['sku'] ?? "",
      values: List<Map<String, dynamic>>.from(json['values'] ?? []),
    );
  }

  @override
  List<Object?> get props => [id, price, oldPrice, stock, sku, values];
}
