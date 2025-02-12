import 'package:ex001/screens/add_task_screen.dart';
import 'package:flutter/material.dart';

import 'detail_screen.dart';
class HomeScreen extends StatefulWidget {
  final String email;

  HomeScreen({required this.email});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final List<Map<String, dynamic>> _tasks = [
    {'id': 1, 'title': 'Task 1', 'completed': false},
    {'id': 2, 'title': 'Task 2', 'completed': true},
    {'id': 3, 'title': 'Task 3', 'completed': false},
  ];

  void _addTask(Map<String, dynamic> newTask) {
    setState(() {
      _tasks.add(newTask);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home Screen'),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Padding(
            padding: const EdgeInsets.all(16.0),
            child: Text(
              'Welcome, ${widget.email}',
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: _tasks.where((task) => !task['completed']).length,
              itemBuilder: (context, index) {
                final task = _tasks.where((task) => !task['completed']).toList()[index];
                return ListTile(
                  title: Text(task['title']),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => DetailScreen(task: task),
                      ),
                    );
                  },
                );
              },
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => AddTaskScreen(addTask: _addTask),
            ),
          );
        },
        child: Icon(Icons.add),
        tooltip: 'Add Task',
      ),
    );
  }
}