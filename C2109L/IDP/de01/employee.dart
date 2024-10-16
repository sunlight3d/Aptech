import 'dart:io';

class Employee {
  String id;
  String name;
  int workingDays;
  double dailySalary;
  Employee({
    required this.id,
    required this.name,
    required this.workingDays,
    required this.dailySalary
  });
  factory Employee.input() {
    String _id = "";
    while(_id.length != 6) {
      print('Enter id: ');
      _id = stdin.readLineSync() ?? '';
    }
    String _name = "";
    while(_name.length < 5 || _name.length > 100) {
      print('Enter name: ');
      _name = stdin.readLineSync() ?? '';
    }
    int _workingDays = 0;
    while(_workingDays < 1 || _workingDays > 31) {
      print('Enter _workingDays: ');
      _workingDays = int.parse(stdin.readLineSync() ?? '0');
    }
    double _dailySalary = 0;
    while(_dailySalary < 10 || _dailySalary > 100) {
      print('Enter _workingDays: ');
      _dailySalary = double.parse(stdin.readLineSync() ?? '0');
    }
    return Employee(
        id: _id,
        name: _name,
        workingDays: _workingDays,
        dailySalary: _dailySalary
    );
  }
  @override
  String toString() {
    // TODO: implement toString
    return 'id: $id, name: $name, workingDays: $workingDays, dailySalary: $dailySalary';
  }
  //monthly_salary = (workingDays x dailySalary)
  double get monthlySalary => workingDays * dailySalary;
}