
import 'dart:io';

import 'employee.dart';
List<Employee> employees = [];
void input() {
  print('Enter number of employees: ');
  int n = int.parse(stdin.readLineSync() ?? "0");
  for(int i = 0; i < n; i++) {
    Employee employee = Employee.input();
    employees.add(employee);
  }
}
void sort() {
  employees.sort((e1, e2) {
    return e1.name.compareTo(e2.name);
  });
  display();
}
void display() {
  employees.forEach((employee) {
    print(employee.toString());
  });
}
void analyse() {
  Map<int, int> map = Map();
  employees.forEach((employee) {
    int workingDays = employee.workingDays;
    //map.update(workingDays, (value) => value + 1, ifAbsent: () => 1);
    if(map.containsKey(workingDays)) {
      map[workingDays] = map[workingDays]! + 1;
    } else {
      map[workingDays] = 1;
    }
  });
  map.keys.forEach((key) {
    int numberOfEmployees = map[key] ?? 0;
    int workingDays = key;
    print('There are $numberOfEmployees with $workingDays days');
  });
}
void find() {
  double maxSalary = employees.map((e) => e.monthlySalary).reduce((a, b) => a > b ? a : b);
  List<Employee> employeesWithMaxSalary = employees.where((e) => e.monthlySalary == maxSalary).toList();
  employeesWithMaxSalary.forEach((element) {
    print(element.toString());
  });
}
void main() {
  print('hello');
}