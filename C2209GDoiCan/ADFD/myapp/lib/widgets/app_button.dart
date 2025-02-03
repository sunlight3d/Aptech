import 'package:flutter/material.dart';

class AppButton extends StatelessWidget {
  final String label;
  final VoidCallback onPressed;
  final double height;
  final double fontSize;

  const AppButton({
    super.key,
    required this.label,
    required this.onPressed,
    this.height = 45,
    this.fontSize = 17,
  });

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: onPressed,
      child: Container(
        height: height,
        width: double.infinity,
        decoration: BoxDecoration(
          gradient: LinearGradient(
            colors: [
              Colors.red.shade400, // Màu tím sáng hơn
              Colors.purple
            ], // Màu tím đậm hơn], // Gradient từ tím nhạt đến tím đậm
            begin: Alignment.centerLeft,
            end: Alignment.centerRight,
          ),
          borderRadius: BorderRadius.circular(10),
        ),
        child: Center(
          child: Text(
            label,
            style: TextStyle(fontSize: fontSize, color: Colors.white),
          ),
        ),
      ),
    );
  }
}