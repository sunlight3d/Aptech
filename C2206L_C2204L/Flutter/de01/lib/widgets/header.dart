import 'package:flutter/material.dart';

class Header extends StatelessWidget {
  final String title;
  Header({super.key, required this.title});

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 60,
      color: Colors.purple,
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: [
          SizedBox(width: 10,),
          Text('Exam', style: TextStyle(fontSize: 25, color: Colors.white), )
        ],
      ),
    );
  }
}
