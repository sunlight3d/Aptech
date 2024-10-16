import 'package:de01/repositories/product_repository.dart';
import 'package:de01/screens/add_product_screen.dart';
import 'package:de01/screens/main_screen.dart';
import 'package:de01/screens/product_list.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

void main() {
  GetIt.instance.registerLazySingleton<ProductRepository>(() => ProductRepository());
  runApp(const MyApp());

}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: MainScreen()
      //home: AddProductScreen()
      //home: ProductListScreen()
    );
  }
}

