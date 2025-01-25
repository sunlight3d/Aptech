import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/login/bloc.dart';
import 'package:myapp/screens/main/cart/cart.dart';
import 'package:myapp/screens/main/notification/notification.dart';
import 'package:myapp/screens/main/product_list/product_list.dart';
import 'package:myapp/screens/main/profile/profile.dart';

import 'package:myapp/services/auth_service.dart';

class MainScreen extends StatefulWidget {
  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _selectedIndex = 0;

  static List<Widget> _widgetOptions = <Widget>[
    ProductListScreen(),
    CartScreen(),
    NotificationsScreen(),
    ProfileScreen(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: _widgetOptions.elementAt(_selectedIndex),
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.shopping_cart),
            label: 'Cart',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.notifications),
            label: 'Notifications',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.person),
            label: 'Me',
          ),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Colors.purple, // Màu tím cho tab được chọn
        unselectedItemColor: Colors.grey, // Màu xám nhạt cho các tab không được chọn
        showSelectedLabels: true, // Hiển thị nhãn của tab được chọn
        showUnselectedLabels: true, // Hiển thị nhãn của các tab không được chọn
        onTap: _onItemTapped,
      ),
    );
  }
}