import 'package:flutter/material.dart';

class UIButton extends StatelessWidget {
  GestureTapCallback? onTap;
  String title = '';
  UIButton({super.key, required this.onTap, required this.title});

  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: Container(
        color: Colors.purple,
        padding: EdgeInsets.symmetric(horizontal: 10, vertical: 30),
        height: 80,
        width: 200,
        child: Text(
          this.title.toUpperCase(),
          textAlign: TextAlign.center,
          style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.white),
        ),
      ),
      onTap: this?.onTap,
    );
  }
}
