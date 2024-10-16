
import 'package:de01/screens/add_product_screen.dart';
import 'package:de01/screens/product_list.dart';
import 'package:de01/widgets/my_button.dart';
import 'package:de01/widgets/my_scaffold.dart';
import 'package:flutter/material.dart';

class MainScreen extends StatelessWidget {
  MainScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return MyScaffold(child: Container(
      width: double.infinity,
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          MyButton(
            title: 'Add new Product',
            onTap: () {
              print('Add new product');
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => AddProductScreen(),
                ),
              );
            },),
          MyButton(
            title: 'Show all products',
            onTap: () {
              print('Show all products');
              Navigator.push(
                context,
                MaterialPageRoute(
                  builder: (context) => ProductListScreen(),
                ),
              );
            },),
        ],
      ),
    ));
  }
}
