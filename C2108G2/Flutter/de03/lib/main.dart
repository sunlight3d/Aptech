import 'package:de03/api/product_api.dart';
import 'package:de03/pages/product.dart';
import 'package:flutter/material.dart';

import 'models/product.dart';
import 'package:get_it/get_it.dart';
final getIt = GetIt.instance;

void main() async{
  getIt.registerSingleton<ProductApi>(ProductApi());
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(),
        body: ProductsListPage(),
      ),
    );
  }
}
