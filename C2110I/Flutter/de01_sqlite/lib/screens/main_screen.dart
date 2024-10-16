import 'package:flutter/material.dart';
import 'package:productapp/widgets/ui_button.dart';
class MainScreen extends StatelessWidget {
  const MainScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('EXAM'),
        backgroundColor: Colors.purple,
      ),
      body: SafeArea(
        child: Container(
          width: double.infinity,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              UIButton(
                title:'Add new product',
                onTap: () {
                  //print('Add new product');
                  Navigator.pushNamed(context, '/detail_product');
              }),
              UIButton(
                title:'Show all products',
                onTap: () {
                  print('Show all products');
                  Navigator.pushNamed(context, '/products');
              },),
            ],
          ),
        ),
      ),
    );
  }
}
