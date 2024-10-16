import 'package:de01/models/product.dart';

class ProductRepository {
  ProductRepository._internal(); // Private constructor

  static final ProductRepository _instance = ProductRepository._internal();
  List<Product> _products = [
    Product(title: 'Mouse', description: 'P001', price: 100, color: 0xFF000000),
    Product(title: 'Keyboard', description: 'P002', price: 200, color: 0xFF00FF00),
    Product(title: 'Monitor', description: 'P003', price: 500, color: 0xFF0000FF),
  ];
  insert(Product product) {
    _products.add(product);
  }
  get products => products;
  factory ProductRepository() {
    return _instance;
  }
}