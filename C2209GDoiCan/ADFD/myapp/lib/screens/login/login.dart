import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/login/bloc.dart';
import 'package:myapp/services/auth_service.dart';
class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  bool _passwordVisible = false;
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passwordController = TextEditingController();

  @override
  void initState() {
    super.initState();
    // Gán giá trị mặc định cho email và password
    _emailController.text = 'hoang.nd@aptechlearning.edu.vn';
    _passwordController.text = 'Abc123456';
  }

  /// Khi người dùng bấm Login, ta phát sự kiện lên Bloc
  void _handleLogin() {
    // Gửi event thay vì `context.go` trực tiếp

    context.read<LoginBloc>().add(
      // Tuỳ thuộc bạn đặt sự kiện thế nào
      // 1) Cập nhật giá trị email/phone
      LoginEmailOrPhoneChanged(_emailController.text),
    );
    context.read<LoginBloc>().add(
      LoginPasswordChanged(_passwordController.text),
    );
    // 3) Gửi sự kiện LoginSubmitted
    context.read<LoginBloc>().add(const LoginSubmitted());
  }
  @override
  Widget build(BuildContext context) {
    return BlocListener<LoginBloc, LoginState>(
      listener: (context, state) {
        // Ví dụ: nếu đăng nhập thành công, chuyển sang product_list
        if (state.status == LoginStatus.success) {
          context.go('/main');
        } else if (state.status == LoginStatus.failure) {
          // Hoặc hiển thị dialog, snackbar, vv.
          ScaffoldMessenger.of(context).showSnackBar(
            const SnackBar(content: Text('Login failed')),
          );
        }
      },
      child: Scaffold(
        body: SizedBox(
          width: double.infinity,
          child: Stack(
            children: [
              Positioned.fill(
                child: Image.asset(
                  'images/background.png',
                  fit: BoxFit.cover, // Đảm bảo ảnh phủ toàn bộ Container
                ),
              ),
              Container(
                padding: const EdgeInsets.all(10),
                height: double.infinity,
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    const SizedBox(height: 20),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: const [
                        Text(
                          'Login',
                          style: TextStyle(fontSize: 30),
                          textAlign: TextAlign.center,
                        ),
                      ],
                    ),
                    const Expanded(child: SizedBox()),
                    const Text('Email or Phone'),
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
                    const Text('Password'),
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
                                _passwordVisible
                                    ? Icons.visibility
                                    : Icons.visibility_off,
                                color: Colors.black.withAlpha(120),
                                size: 25.0,
                              ),
                            ),
                          ),
                        ),
                      ],
                    ),
                    const SizedBox(height: 10),
                    InkWell(
                      onTap: _handleLogin,
                      child: Container(
                        height: 45,
                        width: double.infinity,
                        decoration: const BoxDecoration(
                          color: Colors.purple,
                          borderRadius: BorderRadius.all(Radius.circular(10)),
                        ),
                        child: const Center(
                          child: Text(
                            'Login',
                            style: TextStyle(fontSize: 18, color: Colors.white),
                          ),
                        ),
                      ),
                    ),
                    Padding(
                      padding: const EdgeInsets.all(10),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: const [
                          Text(
                            'Forgot password ?',
                            style: TextStyle(fontSize: 14),
                          ),
                        ],
                      ),
                    ),
                    const Expanded(child: SizedBox()),
                    Padding(
                      padding: const EdgeInsets.all(10),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: const [
                          Text(
                            'Did not have account ?',
                            style: TextStyle(fontSize: 14),
                          ),
                        ],
                      ),
                    ),
                    GestureDetector(
                      onTap: () {
                        context.go('/register');
                      },
                      child: Padding(
                        padding: const EdgeInsets.all(10),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: const [
                            Text(
                              'Create account',
                              style: TextStyle(
                                fontSize: 14,
                                fontWeight: FontWeight.bold,
                                color: Colors.purple,
                              ),
                            ),
                          ],
                        ),
                      ),
                    )
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
