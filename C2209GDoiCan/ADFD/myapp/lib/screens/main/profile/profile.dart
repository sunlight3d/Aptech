import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/user/bloc.dart';
import 'package:myapp/models/user.dart';
import 'package:myapp/services/user_service.dart';

class ProfileScreen extends StatelessWidget {
  final int userId;
  final String token;

  const ProfileScreen({super.key, required this.userId, required this.token});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: BlocProvider(
        create: (context) => UserBloc(userService: context.read<UserService>())
          ..add(FetchUserDetail(userId: userId, token: token)),
        child: BlocBuilder<UserBloc, UserState>(
          builder: (context, state) {
            if (state is UserLoading) {
              return const Center(
                child: CircularProgressIndicator(
                  color: Colors.purple, // Màu tím cho loading indicator
                ),
              );
            } else if (state is UserLoaded) {
              final user = state.user;

              return SingleChildScrollView(
                child: Column(
                  children: [
                    // Phần ảnh profile với viền và background gradient
                    Container(
                      height: 250,
                      width: double.infinity,
                      decoration: BoxDecoration(
                        gradient: const LinearGradient(
                          colors: [Colors.purple, Colors.deepPurpleAccent],
                          begin: Alignment.topLeft,
                          end: Alignment.bottomRight,
                        ),
                        borderRadius: const BorderRadius.only(
                          bottomLeft: Radius.circular(30),
                          bottomRight: Radius.circular(30),
                        ),
                      ),
                      child: Center(
                        child: Container(
                          padding: const EdgeInsets.all(5), // Khoảng cách giữa ảnh và viền
                          decoration: BoxDecoration(
                            shape: BoxShape.circle, // Hình dạng bo tròn
                            border: Border.all(
                              color: Colors.white, // Màu viền trắng
                              width: 4, // Độ dày viền
                            ),
                          ),
                          child: CircleAvatar(
                            radius: 60,
                            backgroundImage: user.avatar != null && user.avatar!.isNotEmpty
                                ? NetworkImage(user.avatar!)
                                : const AssetImage('assets/user-profile.png') as ImageProvider,
                            backgroundColor: Colors.white, // Màu nền avatar
                          ),
                        ),
                      ),
                    ),

                    // Phần thông tin người dùng
                    Padding(
                      padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 30),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          // Tên người dùng
                          Center(
                            child: Text(
                              user.name,
                              style: const TextStyle(
                                fontSize: 28,
                                fontWeight: FontWeight.bold,
                                color: Colors.purple, // Màu tím cho tên
                              ),
                            ),
                          ),
                          const SizedBox(height: 30),

                          // Thông tin chi tiết người dùng sử dụng Card và ListTile
                          Card(
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(15),
                            ),
                            elevation: 5,
                            child: Column(
                              children: [
                                ListTile(
                                  leading: const Icon(Icons.email, color: Colors.purple),
                                  title: const Text('Email'),
                                  subtitle: Text(user.email),
                                ),
                                const Divider(),
                                ListTile(
                                  leading: const Icon(Icons.phone, color: Colors.purple),
                                  title: const Text('Phone'),
                                  subtitle: Text(user.phone != null && user.phone!.isNotEmpty ? user.phone! : 'N/A'),
                                ),
                                const Divider(),
                                ListTile(
                                  leading: const Icon(Icons.person, color: Colors.purple),
                                  title: const Text('Role'),
                                  subtitle: Text(user.role == 1 ? 'Admin' : 'User'),
                                ),
                              ],
                            ),
                          ),

                          const SizedBox(height: 30),

                          // Nút chỉnh sửa thông tin (nếu cần)
                          Center(
                            child: ElevatedButton.icon(
                              onPressed: () {
                                context.go('/login'); // Sử dụng GoRouter để điều hướng
                              },
                              icon: const Icon(Icons.logout, color: Colors.white), // Icon logout với màu trắng
                              label: const Text('Logout'), // Text hiển thị
                              style: ElevatedButton.styleFrom(
                                backgroundColor: Colors.purple, // Màu nền tím
                                foregroundColor: Colors.white, // Màu chữ và icon trắng
                                padding: const EdgeInsets.symmetric(horizontal: 20, vertical: 10),
                                textStyle: const TextStyle(
                                  fontSize: 16,
                                  fontWeight: FontWeight.bold,
                                  color: Colors.white, // Màu chữ trắng
                                ),
                                shape: RoundedRectangleBorder(
                                  borderRadius: BorderRadius.circular(10), // Bo góc
                                ),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
              );
            } else if (state is UserError) {
              return Center(
                child: Text(
                  'Error: ${state.message}',
                  style: const TextStyle(
                    fontSize: 18,
                    color: Colors.red, // Màu đỏ cho thông báo lỗi
                  ),
                ),
              );
            } else {
              return const Center(
                child: Text(
                  'No user data available',
                  style: TextStyle(
                    fontSize: 18,
                    color: Colors.grey, // Màu xám cho thông báo không có dữ liệu
                  ),
                ),
              );
            }
          },
        ),
      ),
    );
  }
}
