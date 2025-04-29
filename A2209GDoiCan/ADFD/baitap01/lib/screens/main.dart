import 'package:flutter/material.dart';

import 'add_product.dart';

class MainScreen extends StatelessWidget {
  const MainScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Exam', style: TextStyle(color: Colors.white),),
        backgroundColor: Colors.deepPurple, // Set your desired color
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            Expanded(child: Container(),),
            SizedBox(
              width: 200, // Fixed width
              height: 50, // Fixed height
              child: TextButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => AddProductScreen()),
                  ).then((newProduct) {
                    if (newProduct != null) {
                      // Handle the saved product data
                      print('Received new product: $newProduct');
                    }
                  });
                },
                style: TextButton.styleFrom(
                  backgroundColor: Colors.deepPurple,
                  foregroundColor: Colors.white,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                  // Remove padding if you want text to fit exactly
                  padding: EdgeInsets.zero,
                ),
                child: Text(
                  'Add new product'.toUpperCase(),
                  style: TextStyle(fontSize: 14),
                ),
              ),
            ),
            Expanded(child: Container(),),
            SizedBox(
              width: 200, // Fixed width
              height: 50, // Fixed height
              child: TextButton(
                onPressed: () {},
                style: TextButton.styleFrom(
                  backgroundColor: Colors.deepPurple,
                  foregroundColor: Colors.white,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(8),
                  ),
                  // Remove padding if you want text to fit exactly
                  padding: EdgeInsets.zero,
                ),
                child: Text(
                  'Show all products'.toUpperCase(),
                  style: TextStyle(fontSize: 14),
                ),
              ),
            ),
            Expanded(child: Container(),)
          ],
        ),
      ),
    );
  }
}