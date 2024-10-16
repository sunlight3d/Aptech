import 'package:flutter/material.dart';
import 'package:flutterapp/constants/app_font_sizes.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final TextEditingController _emailEditingController = TextEditingController();
  final TextEditingController _passwordEditingController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Stack(
          children: [
            Container(
                decoration: BoxDecoration(
                  image: DecorationImage(
                    image: AssetImage('assets/images/background.jpg'),
                    fit: BoxFit.cover,
                  ),
                )
            ),
            Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Container(
                  height: 70,
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Container(
                        width: 70,
                        height: 70,
                      ),
                      Expanded(
                        child: Text(
                          'This is a title', textAlign: TextAlign.center,
                          style: AppFontSizes.normal,
                        ),),
                      Container(
                        width: 70,
                        height: 70,
                      )
                    ],
                  ),
                  decoration: BoxDecoration(
                      color: Color.fromARGB(50, 255, 0, 0)
                  ),
                ),
                SizedBox(height: 200,),
                Padding(
                  padding: EdgeInsets.symmetric(horizontal: 10),
                  child: Column(
                    mainAxisAlignment: MainAxisAlignment.start,
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('Email address:'.toUpperCase(), style: TextStyle(fontSize: 15, color: Colors.white)),
                      TextField(
                        controller: _emailEditingController,
                        style: TextStyle(color: Colors.white), // Màu chữ trắng
                        cursorColor: Colors.white, // Màu gạch ngang trắng
                        decoration: InputDecoration(
                          hintText: 'Email',
                          hintStyle: TextStyle(color: Colors.white), // Màu placeholder trắng
                          focusedBorder: UnderlineInputBorder(
                            borderSide: BorderSide(color: Colors.white), // Màu gạch ngang khi focus
                          ),
                          enabledBorder: UnderlineInputBorder(
                            borderSide: BorderSide(color: Colors.white), // Màu gạch ngang khi không focus
                          ),
                        ),
                      ),
                      SizedBox(height: 20,),
                      Text('Password:'.toUpperCase(), style: TextStyle(fontSize: 15, color: Colors.white)),
                      TextField(
                        controller: _passwordEditingController,
                        obscureText: true, // Hiển thị dấu * thay cho các ký tự gõ
                        style: TextStyle(color: Colors.white),
                        decoration: InputDecoration(
                          hintText: 'Enter password',
                          hintStyle: TextStyle(color: Colors.white), // Màu placeholder trắng
                          focusedBorder: UnderlineInputBorder(
                            borderSide: BorderSide(color: Colors.white), // Màu gạch ngang khi focus
                          ),
                          enabledBorder: UnderlineInputBorder(
                            borderSide: BorderSide(color: Colors.white), // Màu gạch ngang khi không focus
                          ),
                        ),
                      ),
                      SizedBox(height: 20,),
                      Row(
                        children: [
                          Expanded(child: GestureDetector(
                            onTap: () {
                              // Do something when the button is tapped
                              print('Email = ${_emailEditingController.value.text}, '
                                  'password = ${_passwordEditingController.value.text}');

                            },
                            child: Container(
                              decoration: BoxDecoration(
                                color: Colors.white, // Nền trắng
                                borderRadius: BorderRadius.circular(10.0), // Bo tròn góc
                              ),
                              padding: EdgeInsets.symmetric(vertical: 12.0, horizontal: 20.0),
                              child: Center(
                                child: Text(
                                  'Login',
                                  style: TextStyle(
                                    color: Colors.black, // Chữ đen
                                    fontSize: 18.0,
                                  ),
                                ),
                              ),
                            ),
                          )),
                          SizedBox(width: 10,),
                          Expanded(child: GestureDetector(
                            onTap: () {
                              // Do something when the button is tapped
                              print('Button haha');
                            },
                            child: Container(
                              decoration: BoxDecoration(
                                color: Colors.white, // Nền trắng
                                borderRadius: BorderRadius.circular(10.0), // Bo tròn góc
                              ),
                              padding: EdgeInsets.symmetric(vertical: 12.0, horizontal: 20.0),
                              child: Center(
                                child: Text(
                                  'Register',
                                  style: TextStyle(
                                    color: Colors.black, // Chữ đen
                                    fontSize: 18.0,
                                  ),
                                ),
                              ),
                            ),
                          ))
                        ],
                      )
                    ],
                  ),
                )
              ],
            ),
          ],
        ),
      ),
    );
  }
}
