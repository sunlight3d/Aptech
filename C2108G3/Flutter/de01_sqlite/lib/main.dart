import 'package:flutter/material.dart';
import 'package:productapp/screens/main_screen.dart';
import 'package:productapp/screens/product_list_screen.dart';

import 'screens/detail_product_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'exam'.toUpperCase(),
      // home: MainScreen(),
      routes: {
        '/': (context) => MainScreen(), // Home screen is the default route '/'
        '/detail_product': (context) => DetailProductScreen(),
        '/products': (context) => ProductListScreen(),
      },
    );
  }
}
