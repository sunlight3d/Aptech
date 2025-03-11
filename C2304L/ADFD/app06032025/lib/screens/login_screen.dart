

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
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Form(
          //autovalidateMode: AutovalidateMode.always,
          autovalidateMode: AutovalidateMode.onUserInteraction,
          key: _formKey,
          child: Container(
            //height: MediaQuery.of(context).size.height,
            height: double.infinity,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                TextFormField(
                  controller: _textEditEmail,
                  keyboardType: TextInputType.emailAddress,
                  decoration: InputDecoration(
                      hintText: 'Enter your email'
                  ),
                  // The validator receives the text that the user has entered.
                  validator: (value) => EmailValidator.validate(value ?? '') ? null : "Please enter a valid email",
                ),
                SizedBox(height: 20),
                TextFormField(
                  controller: _textEditPassword,
                  keyboardType: TextInputType.text,
                  obscureText: true,
                  decoration: InputDecoration(
                      hintText: 'Enter your password',

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
                TextButton(onPressed: () {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(content: Text('Email = ${_textEditEmail.text}, Pass: ${_textEditPassword.text}')),
                  );
                }, child: Text('Login'))
              ],
            ),
            padding: EdgeInsets.symmetric(horizontal: 30, vertical: 10),
          )
      ),
    );
  }
}
