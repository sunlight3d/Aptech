
import 'package:de01/screens/add_product_screen.dart';
import 'package:de01/screens/product_list.dart';
import 'package:flutter/material.dart';

class MainScreen extends StatelessWidget {
  MainScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Exam'),
        backgroundColor: Colors.purple,
      ),
      body: SafeArea(
        child: Container(
          width: double.infinity,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              GestureDetector(
                child: Container(
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5),
                    color: Colors.purple,
                  ),
                  child: Text('Add new Product', style: TextStyle(fontSize: 20, color: Colors.white),),
                  padding: EdgeInsets.symmetric(vertical: 30, horizontal: 50),
                ),
                onTap: () {
                  print('Add new product');
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => AddProductScreen(),
                    ),
                  );
                },
              ),
              GestureDetector(
                child: Container(
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5),
                    color: Colors.purple,
                  ),
                  child: Text('Show all products', style: TextStyle(fontSize: 20, color: Colors.white),),
                  padding: EdgeInsets.symmetric(vertical: 30, horizontal: 50),
                ),
                onTap: () {
                  print('Show all products');
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => ProductListScreen(),
                    ),
                  );
                },
              )

            ],
          ),
        ),
      ),
    );
  }
}
