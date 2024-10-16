import 'dart:io';

class Product {
    final int id;
    final String name;
    final double price;
    final int quantity;
    Product({
        required this.id,
        required this.name,
        required this.price,
        required this.quantity
    });
    factory Product.input() {
        print('Enter id = ');
        int _id = int.parse(stdin.readLineSync()!);

        String _name = "";
        while(_name.length < 2 || _name.length > 200) {
            print('Enter name = ');
            _name = stdin.readLineSync() ?? "";
        }
        double _price = -1;
        while(_price < 0 || _price > 1000) {
            print('Enter price = ');
            _price = double.parse(stdin.readLineSync() ?? "0");
        }
        int _quantity = 0;
        while(_quantity <=0 ) {
            print('Enter quantity = ');
            _quantity = int.parse(stdin.readLineSync()!);
        }
        return Product(id: _id, name: _name, price: _price, quantity: _quantity);
    }
    get totalPrice => quantity * price;
    @override
    String toString() => 'id: $id, name: $name, price: $price, quantity: $quantity';
}