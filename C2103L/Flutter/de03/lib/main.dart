import 'package:de03/models/product.dart';
import 'package:de03/repositories/cart_repository.dart';
import 'package:de03/repositories/color_repository.dart';
import 'package:de03/repositories/product_repository.dart';
import 'package:de03/screens/detail_screen.dart';
import 'package:de03/screens/home_screen.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

void main() {
  GetIt.instance.registerLazySingleton<ProductRepository>(() => ProductRepository());
  GetIt.instance.registerLazySingleton<ColorRepository>(() => ColorRepository());
  GetIt.instance.registerLazySingleton<CartRepository>(() => CartRepository());
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: HomeScreen(),
    );
  }
}
