import 'package:app03062025/screens/counter_screen.dart';
import 'package:app03062025/screens/films/films_screen.dart';
import 'package:app03062025/screens/login_screen.dart';
import 'package:app03062025/screens/product_list/product_list.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      //home: CounterScreen(title: 'Counter heeeeerree'),
      //home: LoginScreen(),
      //home: ProductListScreen()
      home: FilmsScreen()
    );
  }
}
