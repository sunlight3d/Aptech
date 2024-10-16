import 'package:flutter/material.dart';

class TextIcon extends StatelessWidget {
  final VoidCallback? onPressed;
  final IconData iconData;
  final String? title;

  TextIcon({
    Key? key,
    required this.onPressed,
    required this.iconData,
    this.title,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: onPressed,
      child: Container(
        width: 40,
        height: 40,
        child: Stack(
          alignment: Alignment.center,
          children: [
            Icon(
              iconData,
              color: Colors.white,
            ),
            Positioned(
              child: Text(
                title ?? "",
                style: TextStyle(
                  color: Colors.white,
                  fontWeight: FontWeight.bold,
                  fontSize: 15,
                ),
              ),
              top: 0,
              right: 0,
            )
          ],
        ),
      ),
    );
  }
}

