import 'package:flutter/material.dart';
import 'package:myapp/widgets/my_button.dart';

class Welcome extends StatelessWidget {
  Welcome({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Container(
          padding: EdgeInsets.only(left: 10, top: 20,right: 10, bottom: 20),
          child: Column(
            children: [
              Text('Chao cac ban'),
              MyButton(title: 'Presss me', onPressed: () {
                print('Hahahahaa');
              },)
            ],
          ),
          decoration: BoxDecoration(
              color: Colors.red
          ),
      ),
      ),
    );
  }
}
