import 'package:de01/widgets/mybutton.dart';
import 'package:flutter/material.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.purple,
        centerTitle: false,
        title: Text(
          'Exam',
          textAlign: TextAlign.start,
          style: TextStyle(color: Colors.white),
        ),
      ),
      body: Container(
        width: double.infinity,
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Expanded(child: Container()),
            MyButton(title: 'Add new product', onTap: (){
              print('Add new product');
            },),
            Expanded(child: Container()),
            MyButton(title: 'Show all product', onTap: (){
              print('Show all product');
            },),
            Expanded(child: Container()),

          ],
      ),
      ),
    );
  }
}
