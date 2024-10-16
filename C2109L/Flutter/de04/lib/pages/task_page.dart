import 'package:de04/models/task.dart';
import 'package:de04/models/task_status.dart';
import 'package:de04/widgets/task_widget.dart';
import 'package:flutter/material.dart';

class TaskPage extends StatefulWidget {
  TaskPage({super.key});

  @override
  State<TaskPage> createState() => _TaskPageState();
}

class _TaskPageState extends State<TaskPage> {
  List<Task> tasks = [
    Task(name: 'Read a Java book', finishedDate: DateTime(2024, 12, 6), status: TaskStatus.Completed),
    Task(name: 'These are some of the common methods for displaying alert messages ', finishedDate: DateTime(2024, 8, 15), status: TaskStatus.Pending),
    Task(name: 'The choice of method depends on factors', finishedDate: DateTime(2024, 7, 21), status: TaskStatus.Doing),
    Task(name: 'there are several ways to display alert messages in Flutter', finishedDate: DateTime(2024, 5, 25), status: TaskStatus.Doing),
    Task(name: 'In the United States, phone numbers are typically 10 digits ', finishedDate: DateTime(2024, 6, 24), status: TaskStatus.Completed),
    Task(name: 'In India, phone numbers are typically 10 digits long', finishedDate: DateTime(2024, 4, 9), status: TaskStatus.Doing),
    Task(name: 'property to change the position of the shadow', finishedDate: DateTime(2024, 3, 16), status: TaskStatus.Pending),
    Task(name: 'The home of the app is a', finishedDate: DateTime(2024, 4, 9), status: TaskStatus.Completed),
    Task(name: 'You can adjust the colors and styling according to your preferences', finishedDate: DateTime(2024, 3, 16), status: TaskStatus.Completed),
    Task(name: 'A DateTime object is in the local time zone unless explicitly created ', finishedDate: DateTime(2024, 4, 9), status: TaskStatus.Doing),
    Task(name: 'Use the add and subtract methods with a Duration object', finishedDate: DateTime(2024, 3, 16), status: TaskStatus.Completed),
  ];
  List<Task> filteredTasks = [];
  String _searchText = '';
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    filteredTasks = tasks;
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          padding: EdgeInsets.symmetric(horizontal: 10),
          child: Column(
            children: [
              TextField(
                decoration: InputDecoration(
                  hintText: 'Search tasks...',
                ),
                onChanged: (value) {
                  setState(() {
                    _searchText = value;
                    filteredTasks = tasks.where((eachTask) =>
                        eachTask.name.toLowerCase().contains(_searchText.toLowerCase())).toList();
                  });
                },
              ),
              SizedBox(height: 10), // Add some spacing between TextField and ListView
              Expanded(
                child: ListView.builder(
                  itemCount: (_searchText.isEmpty ? tasks : filteredTasks).length,
                  itemBuilder: (BuildContext context, int index) {
                    Task task = tasks[index];
                    return Container(
                      padding: EdgeInsets.only(top: 10),
                      height: 50,
                      child: Row(
                        children: [
                          Container(
                            width: MediaQuery.of(context).size.width / 2,
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(task.name, style: TextStyle(fontWeight: FontWeight.bold), overflow: TextOverflow.ellipsis,),
                                Text(task.finishedDate.toIso8601String(), overflow: TextOverflow.ellipsis,)
                              ],
                            ),
                          ),
                          Expanded(
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.end,
                              children: [
                                TaskWidget(taskStatus: task.status),
                                Icon(Icons.arrow_forward, size: 20,)
                              ],
                            ),
                          ),
                        ],
                      ),
                    );
                  },
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
