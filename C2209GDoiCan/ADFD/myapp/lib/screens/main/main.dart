import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/login/bloc.dart';
import 'package:myapp/screens/main/cart/cart.dart';
import 'package:myapp/screens/main/notification/notification.dart';
import 'package:myapp/screens/main/product_list/product_list.dart';
import 'package:myapp/screens/main/profile/profile.dart';
import 'package:myapp/services/auth_service.dart';
import 'package:myapp/repositories/local_storage_repository.dart';

class MainScreen extends StatefulWidget {
  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _selectedIndex = 0;
  String token = '';
  int userId = 0;

  @override
  void initState() {
    super.initState();
    _loadUserData();
  }

  Future<void> _loadUserData() async {
    final localStorageRepository = LocalStorageRepository();
    final storedToken = await localStorageRepository.getToken();
    final storedUserId = await localStorageRepository.getUserId();

    if (storedToken != null && storedUserId != null) {
      setState(() {
        token = storedToken;
        userId = storedUserId;
      });
    }
  }

  List<Widget> _getWidgetOptions() {
    return <Widget>[
      ProductListScreen(),
      CartScreen(),
      NotificationsScreen(),
      ProfileScreen(userId: userId, token: token),
    ];
  }

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: _getWidgetOptions().elementAt(_selectedIndex),
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
        selectedItemColor: Colors.purple,
        unselectedItemColor: Colors.grey,
        showSelectedLabels: true,
        showUnselectedLabels: true,
        onTap: _onItemTapped,
      ),
    );
  }
}