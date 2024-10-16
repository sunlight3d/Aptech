import 'package:flutter/material.dart';

class MyButton extends StatelessWidget {
  //send a function to this widget
  final GestureTapCallback? onTap;
  final String title;
  const MyButton({super.key, this.onTap, required this.title});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      child: Container(
        decoration: BoxDecoration(
          borderRadius: BorderRadius.circular(5),
          color: Colors.purple,
        ),
        child: Text(
          this.title,
          style: TextStyle(fontSize: 20, color: Colors.white),),
        padding: EdgeInsets.symmetric(vertical: 30, horizontal: 50),
      ),
      onTap: this.onTap,
    );
  }
}
