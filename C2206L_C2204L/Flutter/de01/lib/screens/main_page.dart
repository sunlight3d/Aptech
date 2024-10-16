import 'package:de01/widgets/header.dart';
import 'package:de01/widgets/my_button.dart';
import 'package:flutter/material.dart';

class MainPage extends StatelessWidget {
  MainPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          child: Column(
            children: [
              Header(title: 'Exam'),
              Expanded(
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                    children: [
                      MyButton(title: 'Add new product', onTap: () {
                        print('Tap add new');
                      },),
                      MyButton(title: 'Show all products', onTap: () {
                        print('Tap show all');
                      },)
                    ],
                  )
              )
            ],
          ),
        ),
      ),
    );
  }
}
