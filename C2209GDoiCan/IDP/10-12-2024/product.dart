import 'dart:io';

class Product {
  late String? name;
  late double price;
  late int stock;
  Product({required this.name, required this.price, required this.stock});
  void updateStock(int quantity) {
    if (quantity > stock) {
      throw 'Insufficient stock';
    }
    stock -= quantity;
    print('Stock updated. Remaining stock: ${stock}');
  }

  double calculateTotalPrice(int quantity) {
    return price * quantity;
  }

  factory Product.input() {
    print('Enter product name:');
    String name = stdin.readLineSync() ?? '';

    print('Enter price:');
    double price = double.parse(stdin.readLineSync() ?? '0');

    print('Enter stock:');
    int stock = int.parse(stdin.readLineSync() ?? '0');

    return Product(name: name, price: price, stock: stock);
  }
  //getter
  double get tax => price > 100
      ? 0.2 * price
      : (price > 50 && price <= 100 ? 0.15 * price : 0.1 * price);
  @override
  String toString() {
    // TODO: implement toString
    return '${name} - \$${price}';
  }

  Map<String, dynamic> toJson() {
    return {'name': this.name, 'price': price, 'stock': stock};
  }

  Product fromJson(Map<String, dynamic> json) {
    return Product(
        name: json['name'] ?? '',
        price: json['price'] as double,
        stock: json['stock'] as int);
  }
}
