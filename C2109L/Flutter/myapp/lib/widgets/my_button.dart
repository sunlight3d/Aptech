
import 'package:flutter/material.dart';

class MyButton extends StatelessWidget {
  final String title;
  final Color textColor;
  final Color backgroundColor;
  final GestureTapCallback? onTap;
  MyButton({
    super.key,
    required this.title,
    required this.textColor,
    required this.backgroundColor,
    this.onTap
  });

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: onTap,
      child: Container(
        width: double.infinity,
        height: 50,
        padding: EdgeInsets.symmetric(vertical: 15),
        child: Text(title,
          textAlign: TextAlign.center,
          style: TextStyle(color: textColor),
        ),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(10),
          color: backgroundColor,
        ),
      ),
    );
  }
}
