import 'dart:async';
import 'dart:convert';
import 'dart:io';
import 'package:http/http.dart' as http;
import '../models/product.dart';
import '../models/product_attribute.dart';
import 'base_service.dart';

// product_service.dart
class ProductService extends BaseService {
  const ProductService({required super.baseURL, required super.httpClient});

  static const int _productLimit = 10;

  Future<List<Product>> fetchProducts({required int startIndex, String search = ""}) async {
    final response = await httpClient.get(
      Uri.parse('$baseURL/products?page=${(startIndex ~/ _productLimit) + 1}&limit=$_productLimit&search=$search'),
    );

    if (response.statusCode == 200) {
      final body = json.decode(response.body) as Map<String, dynamic>;
      return (body['data'] as List)
          .map((productJson) => Product.fromJson(productJson as Map<String, dynamic>))
          .toList();
    }

    throw Exception('Error fetching products');
  }
  Future<Product> fetchProductDetail(int productId) async {
    try {
      final response = await httpClient
          .get(Uri.parse('$baseURL/products/$productId'))
          .timeout(const Duration(seconds: 10)); // Giới hạn thời gian chờ 10s

      if (response.statusCode == 200) {
        final body = json.decode(response.body) as Map<String, dynamic>;
        return Product.fromJson(body['data']);
      }

      throw Exception('Lỗi khi lấy chi tiết sản phẩm: Mã lỗi ${response.statusCode}');
    } on TimeoutException {
      throw Exception('Lỗi: Quá thời gian chờ khi lấy chi tiết sản phẩm');
    } on SocketException {
      throw Exception('Lỗi: Không thể kết nối đến máy chủ, kiểm tra kết nối mạng');
    } catch (e) {
      throw Exception('Lỗi không xác định: $e');
    }
  }
}
