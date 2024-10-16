import 'package:de01/models/product.dart';

class ProductRepository {
  List<Product> products = <Product>[];

  Future<List<Product>> fetchProducts() async {
    // Simulate fetching products from an external source (e.g., API, database)
    await Future.delayed(const Duration(milliseconds: 200));
    return products;
  }

  Future<void> addProduct(Product product) async {
    if(products.where((element) =>
        element.name == product.name || element.code == product.code
    ).isNotEmpty) {
      print('Cannot insert because name|code is duplicated');
      return;
    }
    print('Adding product: $product');
    products.add(product);
  }
}