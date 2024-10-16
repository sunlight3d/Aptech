import 'package:flutter/material.dart';

class Product {
  final int id;
  final String name;
  final String url;
  final String description;
  final double price;
  final Color color; // Added field
  Product({
    required this.id,
    required this.name,
    required this.url,
    required this.price,
    required this.description,
    required this.color, // Added parameter
  });
}