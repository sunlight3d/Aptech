

import 'package:email_validator/email_validator.dart';
import 'package:flutter/material.dart';

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController _textEditEmail = TextEditingController();
  final TextEditingController _textEditPassword = TextEditingController();
  //show/hide password
  bool _showPassword = false;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          // SizedBox(
          //   width: MediaQuery.of(context).size.width,
          //   child: Image.asset('images/background.jpeg', fit: BoxFit.fitWidth),
          // ),
          Positioned(
            top:0,
            right: 0,
            child: Image.asset(
              'images/gloves.png',
              fit: BoxFit.cover,
              width: 100,
              height: 100,
            ),
          ),
          Positioned(
            left:0,
            bottom: 0,
            child: Image.asset(
                'images/gift-bag.png', fit: BoxFit.cover,
              width: 100,
              height: 100,
            ),
          ),
          Form(
            //autovalidateMode: AutovalidateMode.always,
              autovalidateMode: AutovalidateMode.onUserInteraction,
              key: _formKey,
              child: Container(
                //height: MediaQuery.of(context).size.height,
                height: double.infinity,
                padding: EdgeInsets.symmetric(horizontal: 30, vertical: 10),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Padding(
                        padding: EdgeInsets.symmetric(vertical: 10),
                        child: Text('Login', style: TextStyle(
                            fontSize: 30,
                            fontWeight: FontWeight.bold
                        ))
                    ),
                    Text('Please signin to continue', style: TextStyle(
                      fontSize: 14,
                    )),
                    TextFormField(
                      controller: _textEditEmail,
                      keyboardType: TextInputType.emailAddress,
                      decoration: InputDecoration(
                        icon: Icon(Icons.email_outlined),
                        hintText: 'Enter your email',
                      ),
                      // The validator receives the text that the user has entered.
                      validator: (value) => EmailValidator.validate(value ?? '') ? null : "Please enter a valid email",
                    ),
                    SizedBox(height: 20),
                    TextFormField(
                      controller: _textEditPassword,
                      keyboardType: TextInputType.text,
                      obscureText: !_showPassword,

                      decoration: InputDecoration(
                        suffixIcon: TextButton(onPressed: () {

                        }, child: Text('Forgot', style: TextStyle(color: Colors.amber, fontWeight: FontWeight.bold),)),
                        hintText: 'Enter your password',
                        icon: InkWell(
                          child: Icon(_showPassword ? Icons.lock_open_outlined : Icons.lock_clock_outlined),

                          onTap: () {
                            setState(() {
                              _showPassword = !_showPassword;
                            });
                          },
                        ),
                      ),
                      // The validator receives the text that the user has entered.
                      validator: (value) {
                        if((value?.length ?? 0) < 4) {
                          return 'Password must be at least 4 characters';
                        }
                        return null;
                      },
                    ),
                    SizedBox(height: 20),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.end,
                      children: [
                        GestureDetector(
                          child: Container(
                            padding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                            decoration: BoxDecoration(
                                color: Colors.amberAccent,
                                borderRadius: BorderRadius.all(Radius.circular(20)),
                                gradient: LinearGradient(
                                  begin: Alignment.centerLeft,
                                  end: Alignment.centerRight,
                                  colors: <Color>[
                                    Colors.yellow,
                                    Colors.amber
                                  ],
                                )
                            ),
                            child: Row(
                              children: [
                                Text('Login'),
                                SizedBox(width: 5,),
                                Icon(Icons.arrow_forward)
                              ],
                            ),
                          ),
                          onTap: () {
                            ScaffoldMessenger.of(context).showSnackBar(
                              SnackBar(content: Text('Email = ${_textEditEmail.text}, Pass: ${_textEditPassword.text}')),
                            );
                          },
                        ),
                      ],
                    )
                  ],
                ),
              )
          ),
          Positioned(
              bottom: 0,
              child: Container(
                width: MediaQuery.of(context).size.width,
                padding: EdgeInsets.all(20),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Text('Dont\'s have an account ?'),
                    TextButton(onPressed: () {

                    }, child: Text('Sign up', style: TextStyle(color: Colors.amber),))
                  ],
                ),

              ),
          )
        ],
      ),
    );
  }
}
