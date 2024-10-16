import 'package:flutter/material.dart';

class CircleContainer extends StatelessWidget {
  final bool isSelected;
  final Color color;
  final GestureTapCallback? onTap;

  CircleContainer({
    super.key,
    required this.isSelected,
    required this.color,
    this.onTap
  });

  @override
  Widget build(BuildContext context) {
    return InkWell(
      child: Container(
        padding: EdgeInsets.all(5),
        child: Stack(
          children: [
            Container(
              height: 36,
              width: 36,
              decoration: BoxDecoration(
                border: Border.all(
                  color: isSelected == true ? Colors.black.withAlpha(80):Colors.white,
                  width: 2.0,
                ),
                borderRadius: BorderRadius.circular(18.0),
              ),
            ),
            Positioned(
                left: 5,
                top: 5,
                child: Container(
                  height: 26,
                  width: 26,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(13.0),
                    color: this.color,
                  ),
                )
            )
          ],
        ),
      ),
      onTap: this.onTap,
    );
  }
}
