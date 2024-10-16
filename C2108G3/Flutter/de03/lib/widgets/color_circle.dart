import 'package:flutter/material.dart';

class ColorCircle extends StatelessWidget {
  final Color color;
  final GestureTapCallback? onTap;
  ColorCircle({super.key, required this.color, this.onTap});

  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: Container(
        height: 30,
        width: 30,
        margin: EdgeInsets.all(5),
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: const BorderRadius.all(Radius.circular(15)),
          border: Border.all(
            color: this.color,  // Màu của viền
            width: 2.0,           // Độ dày của viền
          ),
        ),
        child: Center(
          child: Container(
            height: 22,
            width: 22,
            decoration: BoxDecoration(
                color: this.color,
                borderRadius: const BorderRadius.all(Radius.circular(11))
            ),
          ),
        ),
      ),
      onTap: this.onTap,
    );
  }
}
