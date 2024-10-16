
import 'package:myflutterapp/models/good.dart';
import 'dart:core';

class Laptop extends Good {
  late double price;
  late double vat;
  String? stock;

  Laptop({
    required int id,
    required String name,
    required this.price,
    required this.vat,
    this.stock,
  }) : super(id, name);

  double get priceCal => vat * price + price;

}
