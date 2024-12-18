import 'dart:io';
import 'dart:math';

void question1a() {
  int employeeID = 0;
  print('Enter Employee ID: ');
  employeeID = int.parse(stdin.readLineSync() ?? '0');
  //get digits
  int exponential = 1;
  bool isAmstrongNumber = false;
  while (true) {
    int result = 0;
    for (int i = 0; i < employeeID.toString().length; i++) {
      result += pow(int.parse(employeeID.toString()[i]), exponential).toInt();
    }
    if (result == employeeID) {
      isAmstrongNumber = true;
      print('${employeeID} is an Armstrong number');
      print('exponential = ${exponential}');
      break;
    } else if (result > employeeID) {
      break;
    }
    exponential++;
  }
  if (isAmstrongNumber == false) {
    print('${employeeID} is not an Armstrong number');
  }
}

int factorial(int n) {
  if (n <= 1) {
    return 1;
  } else {
    return n*factorial(n - 1);
  }
}

void question1b() {
  int employeeCode1, employeeCode2, employeeCode3;
  print('Enter Employee Code 1 : ');
  employeeCode1 = int.parse(stdin.readLineSync() ?? '0');

  print('Enter Employee Code 2 : ');
  employeeCode2 = int.parse(stdin.readLineSync() ?? '0');

  print('Enter Employee Code 3 : ');
  employeeCode3 = int.parse(stdin.readLineSync() ?? '0');
  int result = factorial(employeeCode1) +
      factorial(employeeCode2) +
      factorial(employeeCode3);
  print('Sum of factorials: ${result}');
}
void question1c(){
  List<int> salaries1 = <int>[];
  List<int> salaries2 = <int>[];
  List<int> salaries3 = <int>[];
  print('Enter salaries for Department 1 : ');
  salaries1 = (stdin.readLineSync() ?? '').split(' ').map((item) => int.parse(item)).toList();
  print('Highest Salary in Department 1: ${salaries1.reduce(max)}');

  print('Enter salaries for Department 2 : ');
  salaries2 = (stdin.readLineSync() ?? '').split(' ').map((item) => int.parse(item)).toList();
  print('Highest Salary in Department 2: ${salaries2.reduce(max)}');

  print('Enter salaries for Department 3 : ');
  salaries3 = (stdin.readLineSync() ?? '').split(' ').map((item) => int.parse(item)).toList();
  print('Highest Salary in Department 3: ${salaries3.reduce(max)}');

  print('Overall Highest Salary: ${[salaries1.reduce(max), salaries2.reduce(max), salaries3.reduce(max)].reduce(max)}');


}
void main() {
  //question1a();
  //question1b();
  question1c();
}
