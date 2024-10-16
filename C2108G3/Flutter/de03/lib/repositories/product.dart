import 'dart:async';
import 'dart:io';

import 'package:de03/models/product.dart';
class ProductRepository {
  List<Product> products = [
    Product(
        id: 1,
        url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Left_side_of_Flying_Pigeon.jpg/1920px-Left_side_of_Flying_Pigeon.jpg',
        title: 'This is product 1',
        price: 123.4
    ),
    Product(
        id: 2,
        url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Old_CTC_sign.jpg/1280px-Old_CTC_sign.jpg',
        title: 'This is product 2',
        price: 223.6
    ),
    Product(
        id: 3,
        url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/Mature_flower_diagram.svg/1920px-Mature_flower_diagram.svg.png',
        title: 'This is product 3',
        price: 121.4
    ),
    Product(
        id: 4,
        url: 'https://upload.wikimedia.org/wikipedia/commons/2/25/Kereru_%28New_Zealand_Wood_Pigeon%29.jpg',
        title: 'This is product 4',
        price: 88.4
    ),
    Product(
        id: 5,
        url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Autumn_Red_peaches.jpg/1920px-Autumn_Red_peaches.jpg',
        title: 'This is product 5',
        price: 90.43
    ),
    Product(
        id: 6,
        url: 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Autumn_Red_peaches.jpg/1920px-Autumn_Red_peaches.jpg',
        title: 'This is product 6',
        price: 922.5
    ),
    Product(
        id: 7,
        url: 'https://upload.wikimedia.org/wikipedia/commons/8/84/Clianthus_puniceus_%28Kaka_Beak%29_flowers.jpg',
        title: 'This is product 7',
        price: 321.11
    ),
  ];
  //async function
  Future<List<Product>> getProducts() async {
    await Future.delayed(Duration(seconds: 1));
    return products;
  }
  Future<Product> findById(int productId) async {
    await Future.delayed(Duration(seconds: 1));
    return products.where((product) => product.id == productId).first;
  }
}