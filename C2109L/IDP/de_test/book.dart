//cach dat ten: viet thuong, dau _
import 'dart:io';

class Book {
  String name;
  String authorName;
  double price;
  Book({
    required this.name, 
    required this.authorName, 
    required this.price
  });
  @override
  String toString() => 'name: $name, author: $authorName, price: $price';
  factory Book.input() {
    print('Enter book\'s name: ');
    String _name = stdin.readLineSync() ?? '';

    print('Enter author\'s name: ');
    String _author = stdin.readLineSync() ?? '';

    print('Enter price: ');
    double _price = double.parse(stdin.readLineSync() ?? '0');
    return Book(name: _name, authorName: _author, price: _price);    

  }
}