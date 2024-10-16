import 'package:flutter/material.dart';

class ColorButton extends StatefulWidget {
  Function(bool) onTap;
  final Color color;
  bool isSelected = false;

  ColorButton({
    super.key,
    required this.color,
    required this.isSelected,
    required this.onTap
  });

  @override
  State<ColorButton> createState() => _ColorButtonState();
}

class _ColorButtonState extends State<ColorButton> {
  final double BORDER_SPACE = 4;
  final double WIDTH = 24;
  final double HEIGHT = 24;
  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: Container(
        decoration: BoxDecoration(
          color: Colors.white,
          borderRadius: BorderRadius.circular(WIDTH / 2),
          border: Border.all(color: Colors.grey),
        ),
        child: Container(
          decoration: BoxDecoration(
            color: widget.color,
            borderRadius: BorderRadius.circular((WIDTH - BORDER_SPACE) / 2),
          ),
          margin: EdgeInsets.all(widget.isSelected == true ? BORDER_SPACE : 0),
        ),
        width: WIDTH,
        height: HEIGHT,
      ),
      onTap: () {
        setState(() {
          widget.onTap(true);
        });
      }
    );
  }
}
