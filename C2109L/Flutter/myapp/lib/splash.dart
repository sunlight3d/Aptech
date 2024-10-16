import 'package:flutter/material.dart';
import 'package:myapp/widgets/my_button.dart';

class Splash extends StatelessWidget {
  const Splash({super.key});

  @override
  Widget build(BuildContext context) {
    final screenWidth = MediaQuery.of(context).size.width;
    final screenHeight = MediaQuery.of(context).size.height;
    return Scaffold(
      body: SafeArea(
        child: Container(
          width: screenWidth,
          height: screenHeight,
          child: Stack(
            children: [
              Image(
                image: AssetImage('images/background.jpeg'),
                fit: BoxFit.cover,
                width: screenWidth,
                height: screenHeight,
              ),
              Container(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.start,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('Hello', style: TextStyle(fontSize: 60, color: Colors.black),),
                    Text('This is test', style: TextStyle(fontSize: 20, color: Colors.black),),
                    Expanded(child: Container()),
                    Container(
                      height: screenHeight * 0.25,
                      width: double.infinity,
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: [
                          MyButton(
                              title: 'Login',
                              textColor: Colors.white,
                              backgroundColor: Colors.blue,
                              onTap: () {
                                print('Login');
                              },
                          ),
                          SizedBox(height: 20,),
                          MyButton(
                            title: 'Sign up',
                            textColor: Colors.blue,
                            backgroundColor: Colors.white,
                            onTap: () {
                              print('Sign up');
                            },
                          ),
                        ],
                      ),
                    )
                  ],
                ),
                padding: EdgeInsets.all(10),
              )
            ],
          ),
        ),
      ),
    );
  }
}
