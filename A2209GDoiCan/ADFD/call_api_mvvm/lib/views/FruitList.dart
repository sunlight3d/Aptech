import 'package:flutter/material.dart';

class FruitList extends StatefulWidget {
  const FruitList({super.key});

  @override
  State<FruitList> createState() => _FruitListState();
}

class _FruitListState extends State<FruitList> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Text('This is a list of fruits'),
    );
  }
}
