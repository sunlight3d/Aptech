import 'package:equatable/equatable.dart';
import 'product_attribute.dart';

class Product extends Equatable {
  final int id;
  final String name;
  final String image;
  final String description;
  final int stock;
  final double rating;
  final int totalRatings;
  final int totalSold;
  final double price;
  final double oldPrice;
  final String createdAt;
  final String updatedAt;
  final List<String> images;
  final List<ProductAttribute> attributes;
  final Map<String, dynamic> brand;
  final Map<String, dynamic> category;
  final List<Map<String, dynamic>> variants;

  const Product({
    required this.id,
    required this.name,
    required this.image,
    required this.description,
    required this.stock,
    required this.rating,
    required this.totalRatings,
    required this.totalSold,
    required this.price,
    required this.oldPrice,
    required this.createdAt,
    required this.updatedAt,
    required this.images,
    required this.attributes,
    required this.brand,
    required this.category,
    required this.variants,
  });

  // Parse từ JSON với giá trị mặc định
  factory Product.fromJson(Map<String, dynamic> json) {
    return Product(
      id: json['id'] ?? 0,
      name: json['name'] ?? "",
      image: json['image'] ?? "",
      description: json['description'] ?? "",
      stock: json['stock'] ?? 0,
      rating: double.tryParse(json['rating']?.toString() ?? "0.0") ?? 0.0,
      totalRatings: json['total_ratings'] ?? 0,
      totalSold: json['total_sold'] ?? 0,
      price: double.tryParse(json['price']?.toString() ?? "0.0") ?? 0.0,
      oldPrice: double.tryParse(json['old_price']?.toString() ?? "0.0") ?? 0.0,
      createdAt: json['created_at'] ?? "",
      updatedAt: json['updated_at'] ?? "",
      images: (json['images'] as List?)
          ?.map((e) => e['url'] as String)
          .toList() ??
          [],
      attributes: (json['attributes'] as List?)
          ?.map((e) => ProductAttribute.fromJson(e))
          .toList() ??
          [],
      brand: json['brand'] ?? {"id": 0, "name": ""},
      category: json['category'] ?? {"id": 0, "name": ""},
      variants: List<Map<String, dynamic>>.from(json['variants'] ?? []),
    );
  }

  @override
  List<Object?> get props => [id, name, description, stock, price, images, attributes, brand, category, variants];
}
