import 'package:flutter/material.dart';

class ProductDetail extends StatefulWidget {
  final int id;
  ProductDetail({super.key, required this.id});

  @override
  State<ProductDetail> createState() => _ProductDetailState();
}

class _ProductDetailState extends State<ProductDetail> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: TextButton(onPressed: () {
          Navigator.of(context).pop();
        }, child: Text('Back')),
      ),
    );
  }
}
