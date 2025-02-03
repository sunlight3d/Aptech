import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/widgets/app_button.dart';

class RegisterScreen extends StatefulWidget {
  const RegisterScreen({super.key});

  @override
  State<RegisterScreen> createState() => _RegisterScreenState();
}

class _RegisterScreenState extends State<RegisterScreen> {
  bool _passwordVisible = false;
  bool _retypePasswordVisible = false;
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();
  final TextEditingController _retypePasswordController = TextEditingController();

  void _handleRegister() {
    print('Email = ${_emailController.text}, password = ${_passwordController.text}');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SizedBox(
        width: double.infinity,
        child: Stack(
          children: [
            Positioned.fill(
              child: Image.asset(
                'images/background.png',
                fit: BoxFit.cover,
              ),
            ),
            Container(
              padding: const EdgeInsets.all(10),
              height: double.infinity,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const SizedBox(height: 20),
                  const Expanded(child: SizedBox()),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: const [
                      Text(
                        'Đăng ký',
                        style: TextStyle(fontSize: 30),
                        textAlign: TextAlign.center,
                      ),
                    ],
                  ),
                  const Expanded(child: SizedBox()),

                  // Nhập Email
                  const Text('Email'),
                  TextField(
                    controller: _emailController,
                    keyboardType: TextInputType.emailAddress,
                    decoration: const InputDecoration(
                      enabledBorder: UnderlineInputBorder(
                        borderSide: BorderSide(color: Colors.purple),
                      ),
                      focusedBorder: UnderlineInputBorder(
                        borderSide: BorderSide(color: Colors.purple),
                      ),
                    ),
                  ),
                  const SizedBox(height: 20),

                  // Nhập Mật khẩu
                  const Text('Mật khẩu'),
                  Stack(
                    children: [
                      TextField(
                        controller: _passwordController,
                        obscureText: !_passwordVisible,
                        decoration: const InputDecoration(
                          enabledBorder: UnderlineInputBorder(
                            borderSide: BorderSide(color: Colors.purple),
                          ),
                          focusedBorder: UnderlineInputBorder(
                            borderSide: BorderSide(color: Colors.purple),
                          ),
                        ),
                      ),
                      Positioned(
                        right: 0,
                        child: InkWell(
                          onTap: () {
                            setState(() {
                              _passwordVisible = !_passwordVisible;
                            });
                          },
                          child: Container(
                            padding: const EdgeInsets.all(10),
                            child: Icon(
                              _passwordVisible ? Icons.visibility : Icons.visibility_off,
                              color: Colors.black.withAlpha(120),
                              size: 25.0,
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 10),

                  // Nhập Lại Mật khẩu
                  const Text('Nhập lại mật khẩu'),
                  Stack(
                    children: [
                      TextField(
                        controller: _retypePasswordController,
                        obscureText: !_retypePasswordVisible,
                        decoration: const InputDecoration(
                          enabledBorder: UnderlineInputBorder(
                            borderSide: BorderSide(color: Colors.purple),
                          ),
                          focusedBorder: UnderlineInputBorder(
                            borderSide: BorderSide(color: Colors.purple),
                          ),
                        ),
                      ),
                      Positioned(
                        right: 0,
                        child: InkWell(
                          onTap: () {
                            setState(() {
                              _retypePasswordVisible = !_retypePasswordVisible;
                            });
                          },
                          child: Container(
                            padding: const EdgeInsets.all(10),
                            child: Icon(
                              _retypePasswordVisible ? Icons.visibility : Icons.visibility_off,
                              color: Colors.black.withAlpha(120),
                              size: 25.0,
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 10),

                  // Nút Đăng ký
                  AppButton(
                    label: "Đăng ký",
                    onPressed: _handleRegister,
                  ),

                  const Expanded(child: SizedBox()),

                  // Đã có tài khoản
                  Padding(
                    padding: const EdgeInsets.all(10),
                    child: Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: const [
                        Text(
                          'Bạn đã có tài khoản?',
                          style: TextStyle(fontSize: 14),
                        ),
                      ],
                    ),
                  ),
                  GestureDetector(
                    onTap: () {
                      context.go('/login');
                    },
                    child: Padding(
                      padding: const EdgeInsets.all(10),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: const [
                          Text(
                            'Đăng nhập ngay',
                            style: TextStyle(
                              fontSize: 14,
                              fontWeight: FontWeight.bold,
                              color: Colors.purple,
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
