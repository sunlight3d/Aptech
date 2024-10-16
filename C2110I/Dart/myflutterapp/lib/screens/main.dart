import 'package:flutter/material.dart';
import 'package:myflutterapp/models/circle.dart';
import 'package:myflutterapp/models/product.dart';

class Main extends StatefulWidget {
  const Main({super.key});

  @override
  State<Main> createState() => _MainState();
}

class _MainState extends State<Main> {
  Circle circle = Circle(radius: 12);
  List<Product> products = Product.generateFakeProducts();
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    print("haha");
  }
  List<Widget> _buildTexts() {
    final List<Text> texts = this.products
        .map((product) => Text('${product.name}, ${product.price}'))
        .toList(growable: true);
    texts.insert(0, Text(
      'perimeter = ${circle.perimeter}, area = ${circle.area}',
      style: TextStyle(fontSize: 20),));
    return texts;
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          padding: EdgeInsets.all(10),
          child: Column(
            children: _buildTexts(),
          )
        ),
      ),
    );
  }
}
