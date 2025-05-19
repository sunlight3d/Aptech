import 'package:flutter/material.dart';
/*
flutter pub add provider sqflite path_provider
* */
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

      home: Text('aaa'),
    );
  }
}
