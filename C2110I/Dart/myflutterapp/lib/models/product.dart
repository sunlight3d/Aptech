import 'dart:math';

import 'package:flutter/cupertino.dart';

class Product {
  String name;
  int count;
  double price;
  Product({
    required this.name,
    this.count = 0,
    required this.price
  });
  double get totalMoney => count * price;
  //factory/static method => fake data
// Factory method để tạo danh sách sản phẩm
  static List<Product> generateFakeProducts() {
    final random = Random();
    final List<String> productNames = [
      'Sản phẩm A',
      'Sản phẩm B',
      'Sản phẩm C',
      'Sản phẩm D',
      'Sản phẩm E',
    ];

    List<Product> products = [];
    for (int i = 0; i < 20; i++) {
      final productName = productNames[random.nextInt(productNames.length)];
      final productPrice = (10 + random.nextDouble() * 100).toDouble();
      products.add(
        Product(
          name: productName,
          count: random.nextInt(10),
          price: productPrice,
        ),
      );
    }

    return products;
  }
}