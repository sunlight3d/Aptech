import 'package:de04/models/task_status.dart';

class Task {
  final String name;
  final DateTime finishedDate;
  final TaskStatus status;
  Task({
    required this.name,
    required this.finishedDate,
    required this.status
  });
}