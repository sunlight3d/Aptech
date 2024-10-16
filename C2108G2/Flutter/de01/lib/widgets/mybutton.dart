import 'package:flutter/material.dart';

class MyButton extends StatelessWidget {
  final String title;
  final GestureTapCallback? onTap;
  MyButton({required this.title, super.key, this.onTap});

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: onTap,
      child: Container(
        padding: EdgeInsets.symmetric(vertical: 10, horizontal: 15),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(5),
          color: Colors.purple,
        ),
        child: Text(
          this.title,
          style: TextStyle(color: Colors.white),
        ),
      ),
    );
  }
}
