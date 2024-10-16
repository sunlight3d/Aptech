import 'package:flutter/material.dart';
class MyButton extends StatelessWidget {
  final GestureTapCallback? onTap;
  final Color textColor;
  final Color backgroundColor;
  String? title;
  MyButton({
    super.key,
    this.onTap,
    required this.textColor,
    required this.backgroundColor,
    this.title,
  });

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: onTap,
      child:  Container(
        margin: EdgeInsets.symmetric(horizontal: 15),
        height: 50,
        decoration: BoxDecoration(
          color: backgroundColor,
          borderRadius: BorderRadius.circular(10),
          border: Border.all(
            color: Colors.white,
            width: 2,
          ),
          boxShadow: [
            BoxShadow(
              color: Colors.black.withOpacity(0.5),
              offset: Offset(0, 2), // Shadow position bottom right
              blurRadius: 4,
            ),
          ],
        ),
        child: Center(
          child: Text(title ?? '',
            style: TextStyle(
                color: textColor,
                fontSize: 15, fontWeight: FontWeight.bold), ),
        ),
      ),
    );
  }
}
