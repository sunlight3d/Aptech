import 'dart:collection';

import 'employee.dart';
import 'dart:io';

List<Employee> employees = [];
void main() {
  int choice = 0;
  while(choice != 5) {
    print('-------------------------------------------------');
    print('1.Input, 2.Sort, 3.Analyse, 4.Find, 5.Exit ');
    print('Enter your choice: ');
    print('-------------------------------------------------');
    choice = int.parse(stdin.readLineSync() ?? "0");
    switch(choice) {
      case 1:
        input();
        break;
      case 2:
        sort();
        break;
      case 3:
        analyse();
        break;
      case 4:
        find();
        break;
      default:
        if(choice != 5) {
          print('Enter 1-4');
        }
    }
  }
}
void input() {
  print('Enter number of employees:');
  int numberOfEmployees = int.parse(stdin.readLineSync() ?? "0");
  employees.clear();
  for(int i = 0; i < numberOfEmployees; i++) {
    Employee employee = Employee.input();
    employees.add(employee);
  }
}

void sort() {
  employees.sort((Employee e1, Employee e2) => e1.name.compareTo(e2.name));
  display();
}
void display() {
  employees.forEach((employee) {
    print(employee.toString());
  });
}
void analyse() {
  HashMap<int, int> hashMap = HashMap();
  employees.forEach((employee) {
    print(employee.toString());
    hashMap[employee.workingDay] = hashMap.containsKey(employee.workingDay) ? hashMap[employee.workingDay]! + 1 : 1;
  });
  hashMap.forEach((key, value) {
    print('There are $value employees with working days: $key');
  });
}
void find() {
  double maximumSalary = 0;
  employees.forEach((employee) {
    double monthlySalary = employee.workingDay * employee.dailySalary;
    maximumSalary = monthlySalary > maximumSalary ? monthlySalary: maximumSalary;
  });
  List<Employee> filteredEmployees = employees.where((employee) =>
    maximumSalary == employee.workingDay * employee.dailySalary
  ).toList();
  print('Employees with max salary:');
  filteredEmployees.forEach(print);
}