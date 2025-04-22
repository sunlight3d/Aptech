import 'package:flutter/material.dart';
import 'package:myapp/Login.dart';
import 'package:myapp/cart_list.dart';
import 'package:myapp/sample.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      //home: Sample(),
      //home: Login()
      home:CartList()
    );
  }
}
