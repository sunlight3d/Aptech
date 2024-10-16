import 'dart:io';

import 'product.dart';
List<Product> products = <Product>[];
void input() {
  print('Enter number of products: ');
  int numberOfProducts = int.parse(stdin.readLineSync() ?? "0");
  for(int i = 0; i < numberOfProducts; i++) {
    Product product = Product.input();
    products.add(product);
  }
}
void display() {
  products.forEach((product) {
    print(product.toString());
  });
}
void analyse() {
  Map<double, int> map = {};
  for (Product product in products) {
    double key = product.price;
    map[key] = (map[key] ?? 0) + 1;
  }
  map.forEach((key, value) {
    print('There are $value with the price: $key');
  });
}
void main() {

}