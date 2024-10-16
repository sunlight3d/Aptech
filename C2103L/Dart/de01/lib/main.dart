import 'dart:math';
//import 'package:flutter/material.dart';
import 'dart:io';
import 'package:myapp/student.dart';

void bai01a() {
  print('Enter an integer: ');
  int n = int.parse(stdin.readLineSync() ?? "0");
  //print('Result is :${x * x}');
  print('Result is :${pow(n, 2)}');
}
void bai01b() {
  print('Enter m = ');
  int m = int.parse(stdin.readLineSync()!);
  print('Enter n = ');
  int n = int.parse(stdin.readLineSync()!);
  int sum = m + n;
  int multiply = m * n;
  int minus = m - n;
  print('sum = ${sum}, multiply = ${multiply}, minus = ${minus}');//string concatenation
  print('Max value is ${max(max(sum, multiply), minus)}');
  print('Min value is ${min(min(sum, multiply), minus)}');
}
void bai01c() {
  print('Enter a = ');
  int a = int.parse(stdin.readLineSync()!);
  print('Enter b = ');
  int b = int.parse(stdin.readLineSync()!);
  print('Enter c = ');
  int c = int.parse(stdin.readLineSync()!);
  print('max value is ${max(max(a, b), c)}');
  print('min value is ${min(min(a, b), c)}');
}
void bai01d(){
  print('Enter a = ');
  int a = int.parse(stdin.readLineSync()!);
  print('Enter b = ');
  int b = int.parse(stdin.readLineSync()!);
  print('Enter c = ');
  int c = int.parse(stdin.readLineSync()!);
  int minValue = min(min(a, b), c);
  int maxValue = max(max(a, b), c);
  int numberOfOdds = 0;
  for(int i = minValue; i < maxValue; i++) {
    if(i % 2 != 0) {
      numberOfOdds++;
      print('number ${numberOfOdds} is: ${i}');
    }
  }
  print('numbers of odds is: ${numberOfOdds}');
}
void bai02a2b() {
  Student student = Student();
  student.input();
  print(student.toJson().toString());
  String jsonString = '{"name": "NGuyen VAn A", "age": 18, "weight": 75, "height": 170, "gpa": 7.3}';
  Student.fromJson(jsonString);
}
void main() {
  //bai01a();
  //bai01b();
  //bai01c();
  //bai01d();
  bai02a2b();

  //runApp(const MyApp());
}
/*
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: Scaffold(
        body: Center(
          child: Text('Chao cacmfidfidj ban', style: TextStyle(fontSize: 30),),
        ),
      )
    );
  }
}
*/

