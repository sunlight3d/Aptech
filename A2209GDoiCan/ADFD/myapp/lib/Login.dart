import 'package:flutter/material.dart';

class Login extends StatefulWidget {
  const Login({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  TextEditingController _emailEditingController = TextEditingController();
  TextEditingController _passwordEditingController = TextEditingController();
  TextEditingController _retypePasswordEditingController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          // Background image
          Image(
            image: AssetImage('images/background.png'),
            height: MediaQuery.of(context).size.height,
            width: MediaQuery.of(context).size.width, // Add width to prevent overflow
            fit: BoxFit.cover,
          ),

          // Content column
          Center( // Center the content
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center, // Center vertically
              children: [
                Container(
                  padding: EdgeInsets.symmetric(horizontal: 10), // Add some padding
                  margin: EdgeInsets.symmetric(horizontal: 20),
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(10), // Rounded corners
                  ),
                  child: Row(
                    children: [
                      Icon(Icons.mail),
                      SizedBox(width: 10), // Add spacing between icon and text field
                      Expanded( // Make text field take remaining space
                        child: TextFormField(
                          controller: _emailEditingController,
                          decoration: const InputDecoration(
                            border: InputBorder.none, // Remove underline
                            labelText: 'Email',
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                SizedBox(height: 10,),
                Container(
                  padding: EdgeInsets.symmetric(horizontal: 10), // Add some padding
                  margin: EdgeInsets.symmetric(horizontal: 20),
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(10), // Rounded corners
                  ),
                  child: Row(
                    children: [
                      Icon(Icons.password),
                      SizedBox(width: 10), // Add spacing between icon and text field
                      Expanded( // Make text field take remaining space
                        child: TextFormField(
                          controller: _passwordEditingController,
                          obscureText: true,
                          decoration: const InputDecoration(
                            border: InputBorder.none, // Remove underline
                            labelText: 'Password',
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                SizedBox(height: 10,),
                Container(
                  padding: EdgeInsets.symmetric(horizontal: 10), // Add some padding
                  margin: EdgeInsets.symmetric(horizontal: 20),
                  decoration: BoxDecoration(
                    color: Colors.white,
                    borderRadius: BorderRadius.circular(10), // Rounded corners
                  ),
                  child: Row(
                    children: [
                      Icon(Icons.password),
                      SizedBox(width: 10), // Add spacing between icon and text field
                      Expanded( // Make text field take remaining space
                        child: TextFormField(
                          controller: _retypePasswordEditingController,
                          obscureText: true,
                          decoration: const InputDecoration(
                            border: InputBorder.none, // Remove underline
                            labelText: 'Retype password',
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                SizedBox(width: 20,),
                TextButton(onPressed: () {
                  print('You typed: email = ${_emailEditingController.text}'
                      ', password = ${_passwordEditingController.text}'
                      ',retype password = ${_retypePasswordEditingController.text}'
                  );
                }, child: Container(
                  padding: EdgeInsets.symmetric(vertical: 10, horizontal: 20),
                  decoration: BoxDecoration(
                    color: Colors.white
                  ),
                  child: Text('Login', style: TextStyle(fontWeight: FontWeight.bold, fontSize: 18, color: Colors.black),),
                ))
                // You can add more widgets here
              ],
            ),
          ),
        ],
      ),
    );
  }
}
