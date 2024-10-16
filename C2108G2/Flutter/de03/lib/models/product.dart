import 'package:flutter/material.dart';

class Product {
  int? id;
  final String title;
  final double price;
  final Color color;
  final String imageUrl;

  Product(
      {
        this.id,
        required this.title,
        required this.price,
        required this.color,
        required this.imageUrl});
}