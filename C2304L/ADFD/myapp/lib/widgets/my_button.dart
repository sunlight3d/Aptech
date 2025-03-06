import 'package:flutter/material.dart';

class MyButton extends StatelessWidget {
  VoidCallback? onPressed;
  final String title;
  MyButton({
    super.key,
    this.onPressed,
    required this.title
  });

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: this.onPressed,
      child: Container(
        height: 40,
        width: 100,
        decoration: BoxDecoration(
            color: Colors.yellow
        ),
        child: Center(
          child: Text(title),
        ),
      ),
    );

  }
}
