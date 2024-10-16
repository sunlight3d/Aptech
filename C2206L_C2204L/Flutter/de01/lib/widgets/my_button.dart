import 'package:flutter/material.dart';

class MyButton extends StatelessWidget {
  final String title;
  GestureTapCallback? onTap;

  MyButton({
    super.key,
    required this.title,
    this.onTap
  });

  @override
  Widget build(BuildContext context) {
    final screenWidth = MediaQuery.of(context).size.width;
    final screenHeight = MediaQuery.of(context).size.height;
    return InkWell(
      onTap: onTap,
      child: Container(
        height: 70,
        width: screenWidth * 0.5,
        child: Center(
          child: Text(
            title.toUpperCase(), style: TextStyle(color: Colors.white),
          ),
        ),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(10),
          color: Colors.purple,
        ),
      ),
    );
  }
}
