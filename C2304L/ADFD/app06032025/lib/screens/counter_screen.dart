import 'package:flutter/material.dart';

class CounterScreen extends StatefulWidget {
  final String title;
  const CounterScreen({super.key, required this.title});

  @override
  State<CounterScreen> createState() => _CounterScreenState();
}

class _CounterScreenState extends State<CounterScreen> {
  int _counter = 0;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          children: [
            Text(widget.title),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  _counter = _counter - 1;
                });
              },
              child: Text('Decrease'),
            ),
            Text('counter is : ${_counter}'),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  _counter = _counter + 1;
                });
              },
              child: Text('Increase'),
            ),
          ],
        ),
      ),
    );
  }
}
