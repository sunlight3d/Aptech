import 'package:de05/models/level.dart';
import 'package:de05/models/task.dart';
import 'package:flutter/material.dart';
class Exercise1 extends StatefulWidget {
  const Exercise1({super.key});

  @override
  State<Exercise1> createState() => _Exercise1State();
}

class _Exercise1State extends State<Exercise1> {
  //states
  List<Task> tasks = <Task>[
    Task(
        name: 'Do Java homework',
        description: 'This is a work',
        finishedDate: DateTime(2024, 12, 20),
        level: Level.HIGH,
        completed: true
    ),
    Task(name: 'Do Java homework 2', description: 'This is work 2', finishedDate: DateTime(2024, 12, 21), level: Level.MEDIUM, completed: false),
    Task(name: 'Do Java homework 3', description: 'This is work 3', finishedDate: DateTime(2024, 12, 22), level: Level.LOW, completed: true),
    Task(name: 'Do Java homework 4', description: 'This is work 4', finishedDate: DateTime(2024, 12, 23), level: Level.HIGH, completed: false),
    Task(name: 'Do Java homework 5', description: 'This is work 5', finishedDate: DateTime(2024, 12, 24), level: Level.MEDIUM, completed: true),
    Task(name: 'Do Java homework 6', description: 'This is work 6', finishedDate: DateTime(2024, 12, 25), level: Level.LOW, completed: false),
    Task(name: 'Do Java homework 7', description: 'This is work 7', finishedDate: DateTime(2024, 12, 26), level: Level.HIGH, completed: true),
    Task(name: 'Do Java homework 8', description: 'This is work 8', finishedDate: DateTime(2024, 12, 27), level: Level.MEDIUM, completed: false),
    Task(name: 'Do Java homework 9', description: 'This is work 9', finishedDate: DateTime(2024, 12, 28), level: Level.LOW, completed: true),
    Task(name: 'Do Java homework 10', description: 'This is work 10', finishedDate: DateTime(2024, 12, 29), level: Level.HIGH, completed: false)
  ];
  @override
  void initState() {
    // TODO: implement initState
    super.initState();

  }
  int get numberOfCompletedTasks => tasks
      .where((eachTask) => eachTask.completed == true)
      .toList().length;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          _showAddTaskDialog();
        },
        child: Icon(Icons.add, color: Colors.deepOrange,),
      ),
      body: Container(
        padding: EdgeInsets.symmetric(horizontal: 10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('My Tasks', style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),),
            Text('$numberOfCompletedTasks of ${tasks.length} tasks completed', style: TextStyle(fontSize: 16),),
            Expanded(
                child: ListView.builder(
                    itemCount: tasks.length,
                    itemBuilder: (BuildContext context, int index) {
                      Task selectedTask = tasks[index];
                      return Container(
                        padding: EdgeInsets.symmetric(vertical: 10),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.spaceBetween,
                          children: [
                            Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                    selectedTask.name,
                                    style: TextStyle(decoration: selectedTask.completed == true ? TextDecoration.lineThrough : TextDecoration.none)
                                ),
                                SizedBox(height: 5,),
                                Text(
                                  '${selectedTask.description} . ${selectedTask.level}',
                                  style: TextStyle(decoration: selectedTask.completed == true ? TextDecoration.lineThrough : TextDecoration.none)),
                              ],
                            ),
                            Checkbox(value: selectedTask.completed, onChanged: (bool? newValue) {
                              print('newValue = ${newValue ?? false}');
                              setState(() {
                                tasks[index].completed = newValue ?? false;
                              });
                            })
                          ],
                        ),
                      );
                })
            )
          ],
        ),
      ),
    );
  }
  void _showAddTaskDialog() {
    final _formKey = GlobalKey<FormState>(); // Key cho Form
    String taskName = ''; // Biến lưu tên Task
    String taskDescription = '';
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Add New Task'),
          content: Form(
            key: _formKey,
            child: Column(
              children: [
                TextFormField(
                  decoration: InputDecoration(hintText: 'Enter task name'),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Please enter some text';
                    }
                    return null;
                  },
                  onSaved: (value) {
                    taskName = value ?? '';
                  },
                ),
                TextFormField(
                  decoration: InputDecoration(hintText: 'Enter description'),
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Enter description';
                    }
                    return null;
                  },
                  onSaved: (value) {
                    taskDescription = value ?? '';
                  },
                )
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: Text('Cancel'),
              onPressed: () {
                Navigator.of(context).pop(); // Đóng dialog
              },
            ),
            TextButton(
              child: Text('Add'),
              onPressed: () {
                if (_formKey.currentState!.validate()) {
                  _formKey.currentState!.save();
                  // Thêm Task mới vào danh sách ở đây
                  Navigator.of(context).pop();
                }
              },
            ),
          ],
        );
      },
    );
  }
}

