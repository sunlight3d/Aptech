import 'package:de03/models/product.dart';
import 'package:de03/screens/detail.dart';
import 'package:flutter/material.dart';
class Home extends StatelessWidget {
  Home({
    super.key,    
  });
  List<Product> _fakedProducts = [
    Product(imageName: 'images/product01.jpeg',
        title: 'This is product 01',
        subTitle: 'Something',
        description: 'Now that you have some data to determine whether the green box should be visible, you need a way to update that data. In this example, if the box is visible, hide it. If the box is hidden, show it',
        price: 123.2,
        hexValue: 0xffb74093
    ),
    Product(imageName: 'images/product02.png',
        title: 'This is product 02',
        subTitle: 'ghaghs s',
        description: 'hich is useful because it transitions to the new route using a platform-specific animation',
        price: 328.1,
        hexValue: 0xff123456
    ),
    Product(imageName: 'images/product03.jpeg',
        title: 'This is product 03',
        subTitle: 'rewjiufdiufr',
        description: 'To handle this, display a button. When a user presses the button, flip the boolean from true to false, or false to true. Make this change using setState(), which is a method on the State class. This tells Flutter to rebuild the widget',
        price: 123.2,
        hexValue: 0xFFB74093
    ),
    Product(imageName: 'images/product04.png',
        title: 'This is product 04',
        subTitle: 'fndujshfud',
        description: 'UI developers often need to show and hide elements on screen. However, quickly popping elements on and off the screen can feel jarring to end users',
        price: 123.2,

        hexValue: 0xFFB7409
    ),
    Product(imageName: 'images/product05.png',
        title: 'This is product 05',
        subTitle: 'fndujshfud',
        description: 'As shown in the video, the following decision tree helps you decide what approach to use when implementing a Flutter animation',
        price: 123.2,
        hexValue: 0xFFF8485E
    ),
    Product(imageName: 'images/product06.png',
        title: 'This is product 06',
        subTitle: '..llsd',
        description: 'Well-designed animations make a UI feel more intuitive, contribute to the slick look and feel of a polished app, and improve the user experience. Flutter’s animation support makes it easy to implement a variety of animation types',
        price: 123.2,
        hexValue: 0xffb74093
    ),
    Product(imageName: 'images/product07.png',
        title: 'This is product 07',
        subTitle: 'rdkejesc',
        description: 'since Flutter allows you to mix and match Material and Cupertino widgets depending on your needs',
        price: 123.2,
        hexValue: 0xffb74093
    ),
  ];
  @override
  Widget build(BuildContext context) {
    Color mainColor = Color(0xffb74093);
    return Scaffold(
      body: SafeArea(
          child: Container(
        child: ListView.builder(
          itemBuilder: (context, index) {
            final product = _fakedProducts[index]; // Access product at index
            return InkWell(
              child: Padding(
                padding: EdgeInsets.all(10),
                child: Row(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    ClipRRect(
                      borderRadius: BorderRadius.circular(10.0),
                      child: Image(
                        image: AssetImage(product.imageName), // Assuming image path is correct
                        width: 80,
                        height: 80,
                        fit: BoxFit.cover,
                      ),
                    ),
                    SizedBox(width: 10.0),
                    Column(
                      mainAxisAlignment: MainAxisAlignment.start,
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          product.title, // Use product name from data
                          style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold),
                        ),
                        Text(
                          '\$${product.price}', // Use product description from data
                          style: TextStyle(fontSize: 14),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => DetailScreen(product: product,),
                  ),
                );
            },
            );
          },
          itemCount: _fakedProducts.length,
        ),
      )),
    );
  }
}