import '../models/product.dart';
import 'base_service.dart';

class ProductService extends BaseService {
  const ProductService({required super.baseURL, required super.httpClient});

  static const int _productLimit = 10;

  /// 🔹 Lấy danh sách sản phẩm
  Future<List<Product>> fetchProducts({
    required int startIndex,
    String search = ""
  }) async {
    final response = await request(
      endpoint: 'products',
      method: HttpMethod.GET,
      requestData: {
        'page': (startIndex ~/ _productLimit + 1),
        'limit': _productLimit,
        'search': search,
      },
    );

    final List<dynamic> data = response.data;
    return data.map((json) => Product.fromJson(json as Map<String, dynamic>)).toList();
  }

  /// 🔹 Lấy chi tiết sản phẩm
  Future<Product> fetchProductDetail(int productId) async {
    final response = await request(
      endpoint: 'products/$productId',
      method: HttpMethod.GET,
    );

    return Product.fromJson(response.data);
  }
}
