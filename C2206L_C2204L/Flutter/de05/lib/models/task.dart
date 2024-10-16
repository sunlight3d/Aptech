import 'package:de05/models/level.dart';

class Task {
  String name;
  String description;
  DateTime finishedDate;
  Level level;
  bool completed;
  Task({
    required this.name,
    required this.description,
    required this.finishedDate,
    required this.level,
    required this.completed,
  });
  @override
  String toString() {
    return 'Task(name: $name, '
        'description: $description, '
        'finishedDate: $finishedDate, '
        'level: $level, '
        'completed: $completed)';
  }
}