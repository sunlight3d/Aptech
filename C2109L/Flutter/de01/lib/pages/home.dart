
import 'package:de01/pages/add_product.dart';
import 'package:de01/pages/product_list.dart';
import 'package:de01/widgets/my_button.dart';
import 'package:flutter/material.dart';

class Home extends StatelessWidget {
  const Home({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          width: double.infinity,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              MyButton(title: 'Add new product'.toUpperCase(), onTap: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => AddNewProduct()),
                );
              }),
              MyButton(title: 'Show all product'.toUpperCase(), onTap: (){
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => ProductList()),
                );
              }),
            ],
          ),
        )),
    );
  }
}
