import 'package:de04/models/task_status.dart';
import 'package:flutter/material.dart';

class TaskWidget extends StatelessWidget {
  final TaskStatus taskStatus;
  TaskWidget({
    super.key,
    required this.taskStatus
  });

  @override
  Widget build(BuildContext context) {
    Color backgroundColor = Colors.white;
    if(taskStatus == TaskStatus.Pending) {
      backgroundColor = Colors.green;
    } else if(taskStatus == TaskStatus.Completed) {
      backgroundColor = Colors.blue;
    } else {
      backgroundColor = Colors.orange;
    }
    String text = taskStatus == TaskStatus.Pending
        ? 'Pending' : (taskStatus == TaskStatus.Doing
        ? 'Doing' : 'Completed');
    return Container(
      height: 50,
      padding: EdgeInsets.symmetric(horizontal: 10),
      decoration: BoxDecoration(
        color: backgroundColor,
        borderRadius: BorderRadius.circular(25), // Set borderRadius to 25 for rounded corners
      ),
      child: Center(
        child: Text(text),
      ),
    );
  }
}
