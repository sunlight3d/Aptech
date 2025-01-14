import 'package:equatable/equatable.dart';

import 'product_attribute.dart';

final class Product extends Equatable {
  final int id;
  final String name;
  final String image;
  final String description;
  final int brandId;
  final int categoryId;
  final int stock;
  final double rating;
  final int totalRatings;
  final int totalSold;
  final double price;
  final double oldPrice;
  final String createdAt;
  final String updatedAt;
  final List<ProductAttribute> attributes;

  const Product({
    required this.id,
    required this.name,
    required this.image,
    required this.description,
    required this.brandId,
    required this.categoryId,
    required this.stock,
    required this.rating,
    required this.totalRatings,
    required this.totalSold,
    required this.price,
    required this.oldPrice,
    required this.createdAt,
    required this.updatedAt,
    required this.attributes,
  });

  // Parse from JSON
  factory Product.fromJson(Map<String, dynamic> json) {
    return Product(
      id: json['id'],
      name: json['name'],
      image: json['image'],
      description: json['description'],
      brandId: json['brand_id'],
      categoryId: json['category_id'],
      stock: json['stock'],
      rating: double.parse(json['rating']),
      totalRatings: json['total_ratings'],
      totalSold: json['total_sold'],
      price: double.parse(json['price']),
      oldPrice: double.parse(json['old_price']),
      createdAt: json['created_at'],
      updatedAt: json['updated_at'],
      attributes: (json['attributes'] as List<dynamic>)
          .map((e) => ProductAttribute.fromJson(e))
          .toList(),
    );
  }

  // Convert to JSON
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'image': image,
      'description': description,
      'brand_id': brandId,
      'category_id': categoryId,
      'stock': stock,
      'rating': rating.toString(),
      'total_ratings': totalRatings,
      'total_sold': totalSold,
      'price': price.toString(),
      'old_price': oldPrice.toString(),
      'created_at': createdAt,
      'updated_at': updatedAt,
      'attributes': attributes.map((e) => e.toJson()).toList(),
    };
  }

  @override
  List<Object?> get props => [
    // id,
    name,
    // image,
    description,
    // brandId,
    // categoryId,
    // stock,
    // rating,
    // totalRatings,
    // totalSold,
    // price,
    // oldPrice,
    // createdAt,
    // updatedAt,
    // attributes,
  ];
}

