import 'package:blogapp/views/screens/login/index.dart';
import 'package:blogapp/views/screens/welcome/index.dart';
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
      title: 'This is Blog app',
      //home: Welcome(x: 3, y: 4,),
      home: Login()
    );
  }
}


