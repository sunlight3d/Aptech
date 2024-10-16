import 'package:flutter/material.dart';
import 'package:myapp/friends.dart';
import 'package:myapp/signin.dart';
import 'package:myapp/splash.dart';
import 'package:myapp/tickets.dart';

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
      //home: Signin()
      //home: Tickets(),
      home: Friends()
    );
  }
}


