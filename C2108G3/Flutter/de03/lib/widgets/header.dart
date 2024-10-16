import 'package:flutter/material.dart';

import 'package:flutter/material.dart';

class Header extends StatelessWidget {
  const Header({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 70,
      padding: EdgeInsets.symmetric(horizontal: 10),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          GestureDetector(
            onTap: () {
              print('Back');
              Navigator.of(context).pop();
            },
            child: Icon(Icons.arrow_back_sharp),
          ),
          Text('Product'),
          GestureDetector(
            onTap: () {
              print('Heart');
            },
            child: Icon(Icons.heart_broken),
          ),
        ],
      ),
    );
  }
}
