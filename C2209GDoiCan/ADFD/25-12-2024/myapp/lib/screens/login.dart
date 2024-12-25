import 'package:flutter/material.dart';

class Login extends StatefulWidget {
  final int x = 0;
  const Login({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        width: double.infinity,
        decoration: BoxDecoration(
          color: Colors.red
        ),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Text(
              'Chao ban, day la login',
              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 50, color: Colors.white)
            ),
            Text('value of x is: ${this.widget.x}')
          ],
        ),
      )
    );
  }
}
