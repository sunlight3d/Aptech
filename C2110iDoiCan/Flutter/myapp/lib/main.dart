import 'package:flutter/material.dart';
import 'package:myapp/screens/register.dart';
import 'package:myapp/screens/splash.dart';

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
      //home: Splash(),
      home: Register()
    );
  }
}


