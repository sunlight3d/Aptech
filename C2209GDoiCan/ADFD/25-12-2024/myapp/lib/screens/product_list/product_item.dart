import 'package:flutter/material.dart';

class ProductItem extends StatelessWidget {
  const ProductItem({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 150,
      color: Colors.greenAccent,
      child: Row(
        children: [
          Container(
            width: 100,
            height: 100,
            child: Image.network('https://media.gettyimages.com/id/184276818/photo/red-apple.jpg?s=1024x1024&w=gi&k=20&c=A4t3PjOv3tM41LebBXXRFIB7liIazUNO-QlAQPHaugI='),
          )
        ],
      ),
    );
  }
}
