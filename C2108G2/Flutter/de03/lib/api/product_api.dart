import 'package:de03/models/product.dart';
import 'package:flutter/material.dart';
import 'dart:async';
class ProductApi {
  final _fakedProducts = [Product(
    id: 1,
    title: "Điện thoại 3433 iPhone 15 Pro Max 256GB",
    color: Colors.black,
    price: 1200,
    imageUrl: "assets/image/ipBlack.jpg",
  ),
    Product(
      id: 2,
      title: "Điện thoại xxxiPhone 15 Pro Max 256GB",
      color: Colors.yellowAccent,
      price: 1900,
      imageUrl: "assets/image/ipGold.jpg",
    ),
    Product(
      id: 3,
      title: "eeeĐiện thoại iPhone 15 Pro Max 256GB",
      color: Colors.white60,
      price: 1700,
      imageUrl: "assets/image/ipWhite.jpg",
    ),
    Product(
      id: 4,
      title: "Điệnndushdfu thoại iPhone 15 Pro Max 256GB",
      color: Colors.blueAccent,
      price: 1600,
      imageUrl: "assets/image/ipBlue.jpg",
    )
  ];
  Future<List<Product>> getProducts() async {
    return await Future.delayed(const Duration(seconds: 3), () {
      return _fakedProducts;
    });
  }
  Future<Product?> getProductById(int id) async {
    return await Future.delayed(const Duration(seconds: 3), () {
      return _fakedProducts.where((product) => product.id == id).first;
    });
  }
}