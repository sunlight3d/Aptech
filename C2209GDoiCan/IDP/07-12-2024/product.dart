import 'dart:io';
import 'product.dart';

class Product {
  final int id;
  final String name;
  final int price;
  final int quantity;
  Product(
      {required this.id,
      required this.name,
      required this.price,
      required this.quantity});
  get totalPrice => price * quantity;
  //factory method or static
  factory Product.input() {
    print('Enter id : ');
    int id = int.parse(stdin.readLineSync() ?? '0');
    String name = stdin.readLineSync() ?? '';
    int price = int.parse(stdin.readLineSync() ?? '0');
    int quantity = int.parse(stdin.readLineSync() ?? '0');
    return Product(id: id, name: name, price: price, quantity: quantity);
  }
}
