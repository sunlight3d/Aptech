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

  ProductVariant copyWith({
    int? id,
    double? price,
    double? oldPrice,
    int? stock,
    String? sku,
    List<Map<String, dynamic>>? values,
  }) {
    return ProductVariant(
      id: id ?? this.id,
      price: price ?? this.price,
      oldPrice: oldPrice ?? this.oldPrice,
      stock: stock ?? this.stock,
      sku: sku ?? this.sku,
      values: values ?? this.values,
    );
  }

  @override
  List<Object?> get props => [id, price, oldPrice, stock, sku, values];
}
