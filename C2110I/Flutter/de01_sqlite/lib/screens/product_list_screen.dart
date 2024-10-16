import 'package:flutter/material.dart';
import 'package:productapp/database/database_helper.dart';
import 'package:productapp/models/product.dart';
import 'package:productapp/screens/product_row.dart';

class ProductListScreen extends StatefulWidget {
  const ProductListScreen({super.key});

  @override
  State<ProductListScreen> createState() => _ProductListScreenState();
}

class _ProductListScreenState extends State<ProductListScreen> {
  DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
  List<Product> _products = [];

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _fetchProducts();
  }
  Future<void> _fetchProducts() async {
    List<Product> products = await databaseHelper.getProducts();
    setState(() {
      _products = products;
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('EXAM'),
        backgroundColor: Colors.purple,
      ),
      body: SafeArea(
        child: Container(
          child: ListView.builder(
            itemBuilder: (BuildContext context, int index){
              Product selectedProduct = _products[index];
              return ProductRow(product: selectedProduct);
            },
            itemCount: _products.length,
            ),
        ),
      ),
    );
  }
}

