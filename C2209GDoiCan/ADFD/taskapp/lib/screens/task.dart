import 'package:flutter/material.dart';
import 'package:taskapp/models/task.dart';

class TaskScreen extends StatefulWidget {
  const TaskScreen({super.key});

  @override
  State<TaskScreen> createState() => _TaskScreenState();
}

class _TaskScreenState extends State<TaskScreen> {
  List<Task> tasks = <Task>[
    Task(name: 'Grocery Shopping', isFinished: false),
    Task(name: 'Finish Flutter Project', isFinished: false),
    Task(name: 'Grocery Shopping', isFinished: false),
    Task(name: 'Do something haha', isFinished: false),

    Task(name: 'Morning Workout', isFinished: true),
    Task(name: 'Pay Electricity Bill', isFinished: true),
  ];
  
  @override
  Widget build(BuildContext context) {
    final List<Task> finishedTasks = this.tasks.where((item) => item.isFinished == true).toList();
    final List<Task> unfinishedTasks = this.tasks.where((item) => item.isFinished == false).toList();
    return Scaffold(
      body: Container(
        child: Column(
          children: [
            Text('Total tasks: 10'),
            Text('Pending tasks', style: TextStyle(fontWeight: FontWeight.bold),),
            Flexible(child: ListView.builder(
                padding: const EdgeInsets.all(8),
                itemCount: unfinishedTasks.length,
                itemBuilder: (BuildContext context, int index) {
                  return Container(
                    height: 50,
                    child: Text(unfinishedTasks[index].name),
                  );
                }
            )),
            Text('Finished tasks', style: TextStyle(fontWeight: FontWeight.bold),),
            Flexible(child: ListView.builder(
                padding: const EdgeInsets.all(8),
                itemCount: finishedTasks.length,
                itemBuilder: (BuildContext context, int index) {
                  return Container(
                    height: 50,
                    child: Text(finishedTasks[index].name),
                  );
                }
            ))
          ],
        ),
      ),
    );
  }
}
