import 'package:productapp/models/my_color.dart';

class Product {
  int? id;
  String name;
  String code;
  double price;
  int colorId;
  String? hexValue;
  Product({
    this.id,
    required this.code,
    required this.name,
    required this.price,
    required this.colorId,
    this.hexValue,
  });
  Map<String, dynamic> toMap() {
    //Map = json = Dictionary
    var map = <String, dynamic>{
      'name': name,
      'code': code,
      'price': price,
      'colorId': colorId,
    };
    if (id != null) {
      map['id'] = id;
    }
    if (hexValue != null) {
      map['hexValue'] = hexValue;
    }
    return map;
  }
  Product.fromMap(Map<String, dynamic> map)
      : id = map['id'],
        name = map['name'],
        code = map['code'],
        price = map['price'],
        colorId = map['colorId'],
        hexValue = map['hexValue'];
  @override
  String toString() =>
      'Code: ${code}, '
      'name: ${name}, '
      'price: ${price}, '
      'colorId: ${colorId}, '
      'hexValue: ${hexValue}, ';
}