import 'package:flutter/material.dart';

class Login extends StatefulWidget {
  const Login({super.key});

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  int _counter = 0;
  int _currentIndex = 0;

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          children: [
            TextButton(
                onPressed: () {
                  setState(() {
                    _counter = _counter <= 0 ? 0 : _counter - 1;
                  });
                },
                child: Text('Decrease')
            ),
            Text(
              'Counter is: $_counter',
              style: TextStyle(fontSize: 40, fontWeight: FontWeight.bold),
            ),
            TextButton(
                onPressed: () {
                  setState(() {
                    _counter = _counter + 1;
                  });
                },
                child: Text('Increase')
            )
          ],
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _currentIndex, // Thiết lập index hiện tại
        onTap: (index) {
          setState(() {
            _currentIndex = index; // Cập nhật state khi tap
          });
        },
        items: [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Home',
            activeIcon: Icon(
              Icons.home,
              color: Colors.red,
            ),
          ),
          BottomNavigationBarItem(
              icon: Icon(Icons.search),
              activeIcon: Icon(
                Icons.search,
                color: Colors.red,
              ),
              label: 'Search'
          ),
          BottomNavigationBarItem(
              icon: Icon(Icons.camera),
              activeIcon: Icon(
                Icons.camera,
                color: Colors.red,
              ),
              label: 'Camera'
          )
        ],
        selectedItemColor: Colors.red, // Màu cho item được chọn
        unselectedItemColor: Colors.grey, // Màu cho item không được chọn
      ),
    );
  }
}