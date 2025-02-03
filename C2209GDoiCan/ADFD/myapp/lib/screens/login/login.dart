import 'package:awesome_snackbar_content/awesome_snackbar_content.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:flutter_svg/flutter_svg.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/login/bloc.dart';
import 'package:myapp/services/utils.dart';
import 'package:myapp/widgets/app_button.dart';

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
    _emailController.text = 'hoang.nd@aptechlearning.edu.vn';
    _passwordController.text = 'Abc123456';
  }

  /// Xử lý đăng nhập
  void _handleLogin() {
    context.read<LoginBloc>().add(LoginEmailOrPhoneChanged(_emailController.text));
    context.read<LoginBloc>().add(LoginPasswordChanged(_passwordController.text));
    context.read<LoginBloc>().add(const LoginSubmitted());
  }

  /// Xử lý đăng nhập bằng Google
  void _handleGoogleLogin() {
    context.read<LoginBloc>().add(const LoginWithGoogleRequested());
  }

  @override
  Widget build(BuildContext context) {
    return BlocListener<LoginBloc, LoginState>(
      listener: (context, state) {
        if (state.status == LoginStatus.success) {
          context.go('/main');
        } else if (state.status == LoginStatus.failure) {
          SchedulerBinding.instance.addPostFrameCallback((_) {
            alert(context, "Đăng nhập thất bại", ContentType.failure);
          });
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
                          'Đăng nhập',
                          style: TextStyle(fontSize: 30),
                          textAlign: TextAlign.center,
                        ),
                      ],
                    ),
                    const Expanded(child: SizedBox()),

                    // Nhập Email hoặc Số điện thoại
                    const Text('Email hoặc Số điện thoại'),
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

                    // Nút Đăng nhập
                    AppButton(
                      label: "Đăng nhập",
                      onPressed: _handleLogin,
                    ),

                    // Nút Đăng nhập bằng Google
                    const SizedBox(height: 20),
                    InkWell(
                      onTap: _handleGoogleLogin,
                      child: Container(
                        height: 45,
                        width: double.infinity,
                        decoration: BoxDecoration(
                          color: Colors.white,
                          border: Border.all(color: Colors.grey),
                          borderRadius: BorderRadius.circular(10),
                        ),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            SvgPicture.asset(
                              'images/google-icon.svg',
                              height: 24,
                            ),
                            const SizedBox(width: 10),
                            const Text(
                              'Đăng nhập bằng Google',
                              style: TextStyle(fontSize: 16),
                            ),
                          ],
                        ),
                      ),
                    ),

                    // Quên mật khẩu
                    Padding(
                      padding: const EdgeInsets.all(10),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: const [
                          Text(
                            'Quên mật khẩu?',
                            style: TextStyle(fontSize: 14),
                          ),
                        ],
                      ),
                    ),

                    const Expanded(child: SizedBox()),

                    // Đăng ký tài khoản
                    Padding(
                      padding: const EdgeInsets.all(10),
                      child: Row(
                        mainAxisAlignment: MainAxisAlignment.center,
                        children: const [
                          Text(
                            'Bạn chưa có tài khoản?',
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
                              'Tạo tài khoản',
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
              )
            ],
          ),
        ),
      ),
    );
  }
}