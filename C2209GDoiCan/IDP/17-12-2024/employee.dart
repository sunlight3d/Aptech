import 'dart:io';

class Employee {
  final String id;
  final String name;
  final int workingDays;
  final int dailySalary;
  Employee(
      {required this.id,
      required this.name,
      required this.workingDays,
      required this.dailySalary});
  static Employee input() {
    String id = '';
    String name = '';
    int workingDays = 0;
    int dailySalary = 0;
    while (id.length != 6) {
      print('Enter employee\'s id : ');
      id = (stdin.readLineSync() ?? '');
      if (id.length != 6) {
        print('Employee\'s id must be 6 characters');
      }
    }
    while (name.length < 5 || name.length > 100) {
      print('Enter employee\'s name : ');
      name = (stdin.readLineSync() ?? '');
      if (name.length < 5 || name.length > 100) {
        print('Employee\'s name must be 5 to 100 characters');
      }
    }
    while (workingDays < 1 || workingDays > 31) {
      print('Enter employee\'s workingDays : ');
      name = (stdin.readLineSync() ?? '');
      if (workingDays < 1 || workingDays > 31) {
        print('Employee\'s workingDays must be 1 to 31');
      }
    }
    while (dailySalary < 10 || dailySalary > 100) {
      print('Enter employee\'s salary : ');
      name = (stdin.readLineSync() ?? '');
      if (dailySalary < 10 || dailySalary > 100) {
        print('Employee\'s dailySalary must be 10 to 100');
      }
    }
    return Employee(
        id: id, name: name, workingDays: workingDays, dailySalary: dailySalary);
  }
}
