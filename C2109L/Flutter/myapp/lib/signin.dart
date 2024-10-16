import 'package:flutter/material.dart';
import 'package:myapp/widgets/my_button.dart';

class Signin extends StatefulWidget {
  const Signin({super.key});

  @override
  State<Signin> createState() => _SigninState();
}

class _SigninState extends State<Signin> {
  final TextEditingController _emailTextFieldController = TextEditingController();
  final TextEditingController _passwordTextFieldController = TextEditingController();
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
                  children: [
                    Container(height: screenHeight * 0.4),
                    Container(
                      height: 50,
                      margin: EdgeInsets.symmetric(horizontal: 20),
                      decoration: BoxDecoration(
                        color: Colors.white.withOpacity(0.7),
                        borderRadius: BorderRadius.circular(25),
                      ),
                      child: TextField(
                        controller: _emailTextFieldController,
                        keyboardType: TextInputType.emailAddress,
                        decoration: InputDecoration(
                          hintStyle: TextStyle(color: Colors.white),
                          hintText: 'Enter email',
                          contentPadding: EdgeInsets.symmetric(horizontal: 15),
                          border: InputBorder.none,
                        ),
                      ),
                    ),
                    SizedBox(height: 20,),
                    Container(
                      height: 50,
                      margin: EdgeInsets.symmetric(horizontal: 20),
                      decoration: BoxDecoration(
                        color: Colors.white.withOpacity(0.7),
                        borderRadius: BorderRadius.circular(25),
                      ),
                      child: TextField(
                        controller: _passwordTextFieldController,
                        keyboardType: TextInputType.text,
                        obscureText: true,
                        decoration: InputDecoration(
                          hintStyle: TextStyle(color: Colors.white),
                          hintText: 'Enter password',
                          contentPadding: EdgeInsets.symmetric(horizontal: 15),
                          border: InputBorder.none,
                        ),
                      ),
                    ),
                    SizedBox(height: 20,),
                    Container(
                      margin: EdgeInsets.symmetric(horizontal: 20),
                      child: MyButton(
                        title: 'Login',
                        textColor: Colors.white,
                        backgroundColor: Colors.blue,
                        onTap: () {
                          print('Login');
                        },
                      ),
                    ),
                    GestureDetector(
                      child: Container(
                        padding: EdgeInsets.all(10),
                        child: Text('Forgot password',
                          style: TextStyle(color: Colors.blue),
                          textAlign: TextAlign.center,
                        ),
                      ),
                      onTap: () {

                      },
                    ),
                    Container(
                        child: Row(
                            mainAxisAlignment: MainAxisAlignment.center,
                            crossAxisAlignment: CrossAxisAlignment.center,
                            children: [
                              Container(
                                padding: EdgeInsets.all(10),
                                child: Row(
                                    children:[
                                      Image(
                                        image: AssetImage('images/facebook.png'),
                                        fit: BoxFit.cover,
                                        width: 20,
                                        height: 20,
                                      ),
                                      SizedBox(width: 10,),
                                      Text('Facebook')
                                    ]
                                ),
                              ),
                              SizedBox(width: 30,),
                              Container(
                                padding: EdgeInsets.all(10),
                                child: Row(
                                    children:[
                                      Image(
                                        image: AssetImage('images/google.png'),
                                        fit: BoxFit.cover,
                                        width: 20,
                                        height: 20,
                                      ),
                                      SizedBox(width: 10,),
                                      Text('Google')
                                    ]
                                ),
                              ),

                            ]
                        )
                    ),
                  ],
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
