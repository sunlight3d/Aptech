import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final TextEditingController _phoneNumberController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  @override
  void dispose() {
    _phoneNumberController.dispose();
    _passwordController.dispose();
    super.dispose();
  }

  @override
  void initState() {
    super.initState();
    //_loginUser();
  }

  Future<void> _loginUser() async {
    // TODO: Make API call
    // Replace 'http://ubuntu-server-01.local:8099/api/v1/users/login' with your actual API endpoint
    const apiUrl = 'http://ubuntu-server-01.local:8099/api/v1/users/login';

    final phoneNumber = _phoneNumberController.text;
    final password = _passwordController.text;

    final response = await http.post(
      Uri.parse(apiUrl),
      body: {
        'phone_number': phoneNumber,
        'password': password,
      },
    );

    if (response.statusCode == 200) {
      // Login successful, handle the response
      final responseBody = response.body;
      // TODO: Handle the response data
    } else {
      // Login failed, handle the error
      final errorMessage = response.body;
      // TODO: Handle the error message
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Login'),
      ),
      body: Column(
        children: [
          TextField(
            controller: _phoneNumberController,
            decoration: const InputDecoration(labelText: 'Phone Number'),
          ),
          TextField(
            controller: _passwordController,
            decoration: const InputDecoration(labelText: 'Password'),
            obscureText: true,
          ),
          ElevatedButton(
            onPressed: () {
              _loginUser();
            },
            child: const Text('Login'),
          ),
        ],
      ),
    );
  }
}
