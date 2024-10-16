import 'dart:convert';
import 'dart:io';
import 'dart:math';

import 'student.dart';

void main() {
  //bai1();
  bai2();
}
void bai2() {
  try {
    Student studentA = Student.input();
    print(jsonEncode(studentA.toJson())); //send to postman
    //String jsonString = jsonEncode(studentA);
    print('Input json string');
    String inputJsonString = stdin.readLineSync() ?? '';
    Student convertedStudent = Student.fromJson(jsonDecode(inputJsonString));
    //{"name":"hoang","age":19,"weight":165.0,"height":60.0,"gpa":5.0}
    print(studentA);
  }catch(e) {
    print(e.toString());
  }
}
void bai1() {
  print('Nhap vao so nguyen N: '); // Prompt the user to enter a number
  int n = int.parse(stdin.readLineSync() ?? '0');
  print('Ket qua N*N = ${n*n}');

  print('Nhap vao so nguyen M: ');
  int m = int.parse(stdin.readLineSync() ?? '0');
  int result = max(m + n, m * n);
  print('So lon nhat(trong so tong tich 2 so) : ${result}');

  print('Nhap vao so nguyen K: ');
  int k = int.parse(stdin.readLineSync() ?? '0');
  int mininum = min(m, min(n, k));
  int maximum = max(m, max(n, k));
  print('min = ${mininum}, max = ${maximum}');
  int numberOfOdds = 0;
  for(int i = mininum; i < maximum; i++) {
    if(i %2 != 0) {
      numberOfOdds++;
    }
  }
  print('Number of odds: ${numberOfOdds}');
}