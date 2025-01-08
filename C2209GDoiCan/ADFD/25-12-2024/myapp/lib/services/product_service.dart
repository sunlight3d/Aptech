import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:myapp/models/product.dart';
import 'package:myapp/models/product_attribute.dart';

class ProductService {
  final String baseURL;
  final http.Client httpClient;

  const ProductService({required this.baseURL, required this.httpClient});

  static const int _productLimit = 10; // Số lượng sản phẩm mỗi trang

  Future<List<Product>> fetchProducts({required int startIndex}) async {
    final response = await httpClient.get(
      Uri.parse('$baseURL/products?page=${(startIndex ~/ _productLimit) + 1}&limit=$_productLimit'),
    );

    if (response.statusCode == 200) {
      final body = json.decode(response.body) as Map<String, dynamic>;
      return (body['data'] as List).map((dynamic json) {
        final map = json as Map<String, dynamic>;
        return Product(
          id: map['id'] as int,
          name: map['name'] as String,
          image: map['image'] as String,
          description: map['description'] as String,
          brandId: map['brand_id'] as int,
          categoryId: map['category_id'] as int,
          stock: map['stock'] as int,
          rating: double.parse(map['rating']),
          totalRatings: map['total_ratings'] as int,
          totalSold: map['total_sold'] as int,
          price: double.parse(map['price']),
          oldPrice: double.parse(map['old_price']),
          createdAt: map['created_at'] as String,
          updatedAt: map['updated_at'] as String,
          attributes: (map['attributes'] as List<dynamic>).map((attr) {
            final attrMap = attr as Map<String, dynamic>;
            return ProductAttribute(
              id: attrMap['id'] as int,
              name: attrMap['name'] as String,
              value: attrMap['value'] as String,
            );
          }).toList(),
        );
      }).toList();
    }

    throw Exception('Error fetching products');
  }
}
