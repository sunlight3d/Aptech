
import 'package:flutter/material.dart';

class Login extends StatefulWidget {
  const Login({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          Container(
            decoration: BoxDecoration(
              image: DecorationImage(
                image: AssetImage("assets/background.png"),
                fit: BoxFit.cover, // This will make the image cover the whole screen
              ),
            ),
          ),
          Container(
            padding: EdgeInsets.symmetric(horizontal: 20),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Expanded(child: Container()),
                Text('Brand', style: TextStyle(fontSize: 40, color: Colors.white),),
                Expanded(child: Container()),
                TextField(
                  controller: _emailController,
                  decoration: InputDecoration(
                    labelText: 'Email',
                    labelStyle: TextStyle(color: Colors.white), // Optional: Change label text color
                    focusedBorder: UnderlineInputBorder(
                      borderSide: BorderSide(color: Colors.white), // White underline when focused
                    ),
                    enabledBorder: UnderlineInputBorder(
                      borderSide: BorderSide(color: Colors.white), // White underline when not focused
                    ),
                  ),
                ),
                TextField(
                  controller: _passwordController,
                  obscureText: true,
                  decoration: InputDecoration(
                    labelText: 'Password',
                    labelStyle: TextStyle(color: Colors.white), // Optional: Change label text color
                    focusedBorder: UnderlineInputBorder(
                      borderSide: BorderSide(color: Colors.white), // White underline when focused
                    ),
                    enabledBorder: UnderlineInputBorder(
                      borderSide: BorderSide(color: Colors.white), // White underline when not focused
                    ),
                  ),
                ),
                SizedBox(height: 25,),
                InkWell(
                  onTap: () {
                    String _email = _emailController.text;
                    String _password = _passwordController.text;
                    // Email validation
                    if (!RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$').hasMatch(_email)) {
                      print('Invalid email format');
                      return; // Exit onTap if email format is invalid
                    }

                    // Password validation
                    if (_password.length < 4) {
                      print('Password must be at least 4 characters long');
                      return; // Exit onTap if password is too short
                    }

                    if(_email=="student@aptech.com.vn" && _password=="aptech123") {
                      print('Login successfully');
                    }

                  },
                  child: Container(
                    width: double.infinity, // Adjust width as needed
                    height: 50, // Adjust height as needed
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(10),
                      border: Border.all(color: Colors.white, width: 10),
                    ),
                    child: Center(
                      child: Text(
                        'Login',
                        style: TextStyle(fontWeight: FontWeight.bold, fontSize: 18),
                        textAlign: TextAlign.center, // Align text center within the container
                      ),
                    ),
                  ),
                ),
                SizedBox(height: 15,),
                Text('Forgot password ?', style: TextStyle(color: Colors.white, fontSize: 16),),
                SizedBox(height: 15,),
                Row(
                  children: [
                    Expanded(child: Container(
                      height: 1, // Height of the line
                      color: Colors.white, // Color of the line
                      ),
                    ),
                    Padding(
                      padding: EdgeInsets.symmetric(horizontal: 12), // Adjust spacing between line and text
                      child: Text(
                        'OR',
                        style: TextStyle(color: Colors.white), // Style of the text
                      ),
                    ),
                    Expanded(child: Container(
                      height: 1, // Height of the line
                      color: Colors.white, // Color of the line
                    ),
                    ),
                  ],
                ),
                SizedBox(height: 15,),
                InkWell(
                  onTap: () {
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text("This feature is under construction"),
                      ),
                    );
                  },
                  child: Container(
                    width: double.infinity, // Adjust width as needed
                    height: 50, // Adjust height as needed
                    decoration: BoxDecoration(
                      color: Colors.blue,
                      borderRadius: BorderRadius.circular(10),
                    ),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        Icon(
                          Icons.facebook,
                          color: Colors.white,
                        ),
                        SizedBox(width: 8), // Adjust spacing between icon and text as needed
                        Text(
                          'Login with Facebook',
                          style: TextStyle(fontWeight: FontWeight.bold, fontSize: 18),
                          textAlign: TextAlign.center, // Align text center within the container
                        ),
                      ],
                    ),
                  ),
                ),
                Expanded(child: Container()),
              ],
            ),
          )
        ],
      ),
    );
  }
}
