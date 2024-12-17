import 'dart:io';

import 'employee.dart';

int numberOfEmployees = 0;
List<Employee> employees = <Employee>[];
void showMenu() {
  int choice = 0;
  while (true) {
    print('Enter your choice: ');
    choice = int.parse(stdin.readLineSync() ?? '0');
    if (choice == 5) {
      print('Exit program');
      break;
    }
    switch (choice) {
      case 1:
        print('Enter number of employees : ');
        numberOfEmployees = int.parse(stdin.readLineSync() ?? '0');
        for (int i = 0; i < numberOfEmployees; i++) {
          Employee newEmployee = Employee.input();
          employees.add(newEmployee);
        }
        break;
      case 2:
        employees.sort((e1, e2) => e1.name.compareTo(e2.name));
        break;
      case 3:
        Map<int, int> map = new Map();
        for (Employee employee in employees) {
          if (map[employee.workingDays] == null) {
            map[employee.workingDays] = 1;
          } else {
            map[employee.workingDays] = map[employee.workingDays]! + 1;
          }
        }
        //display the map
        
        break;
      case 4:
        print('You choose 4');
        break;
      default:
        print('Invalid choice. You must enter 1-5');
    }
    print('Do you want to continue(y/n) ? If user type: y or Y');
    String confirm = stdin.readLineSync() ?? 'Yes';
    if (confirm.trim().toLowerCase() != 'y') {
      print('Exit program');
      break;
    }
  }
}

void main() {
  showMenu();
}
