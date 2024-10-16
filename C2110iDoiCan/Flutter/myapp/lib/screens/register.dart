import 'package:flutter/material.dart';

class Register extends StatefulWidget {
  const Register({super.key});

  @override
  State<Register> createState() => _RegisterState();
}

class _RegisterState extends State<Register> {
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }
  @override
  Widget build(BuildContext context) {
    final TextEditingController _userNameTextEditingController = TextEditingController();
    final TextEditingController _passwordTextEditingController = TextEditingController();
    return Scaffold(
        body: Stack(
          children: [
            Container(
                decoration: BoxDecoration(
                    color: Colors.white
                )),
            Container(
              padding: EdgeInsets.symmetric(horizontal: 20),
              //width: double.infinity,
              child: Column(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Container(
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                      Text('devRNZ', style: TextStyle(fontSize: 50, fontWeight: FontWeight.bold, color: Colors.black),),
                      Padding(
                        child: Text('Username:', textAlign: TextAlign.start,),
                          padding: EdgeInsets.symmetric(vertical: 10),
                      ),
                      TextField(decoration: InputDecoration(
                        hintText: 'Enter your username', // Placeholder text
                      ),
                        controller: _userNameTextEditingController,
                      ),
                      Text('Password:'),
                      TextField(
                        obscureText: true,
                        decoration: InputDecoration(
                          hintText: 'Enter password', // Placeholder text
                        ),
                        controller: _userNameTextEditingController,
                      )
                      ],
                    ),
                  ),

                ],
              ),
            )
          ],
        )
    );;
  }
}
