import 'package:flutter/material.dart';

class MyScaffold extends StatelessWidget {
  final Widget child;
  const MyScaffold({super.key, required this.child});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Examination'),
        backgroundColor: Colors.purple,
      ),
      body: SafeArea(
        child: child,
      ),
    );
  }
}
