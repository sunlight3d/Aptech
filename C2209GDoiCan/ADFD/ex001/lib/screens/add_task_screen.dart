import 'package:flutter/material.dart';


class AddTaskScreen extends StatelessWidget {
  final TextEditingController _titleController = TextEditingController();
  final Function(Map<String, dynamic>) addTask;

  AddTaskScreen({required this.addTask});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Add Task'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: _titleController,
              decoration: InputDecoration(labelText: 'Enter Task Title'),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                final newTask = {
                  'id': DateTime.now().millisecondsSinceEpoch, // Unique ID
                  'title': _titleController.text,
                  'completed': false,
                };
                addTask(newTask);
                Navigator.pop(context);
              },
              child: Text('Save Task'),
            ),
          ],
        ),
      ),
    );
  }
}