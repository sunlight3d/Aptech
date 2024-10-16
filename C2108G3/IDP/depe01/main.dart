
import 'dart:io';
import 'dart:math';
import 'student.dart';
import 'dart:convert';

void main() {
  //bai02();
  //bai1c();
  bai02();
}
void bai1b() {
  print('Input m = ');
  int m = int.parse(stdin.readLineSync() ?? '0');

  print('Input n = ');
  int n = int.parse(stdin.readLineSync() ?? '0');
  int sum = m + n;
  int substract = m - n;
  int multiply = m * n;
  int maxValue = max(sum, max(substract, multiply));
  print('Max value is : ${maxValue}');

}
void bai1c() {
  print('Input m = ');
  int m = int.parse(stdin.readLineSync() ?? '0');

  print('Input n = ');
  int n = int.parse(stdin.readLineSync() ?? '0');

  print('Input k = ');
  int k = int.parse(stdin.readLineSync() ?? '0');

  int minValue = min(m, min(n, k));
  int maxValue = max(m, min(n, k));
  int numberOfOdds = 0;
  for(int i = minValue; i < maxValue; i++) {
   if(i.isOdd == true) {
     numberOfOdds++;
   }
  }
}
void bai02(){

  Student student = Student.input();
  print(student.toString());
  String jsonString = jsonEncode(student.toJson());
  print('Chuỗi JSON: $jsonString');

  // d) Nhập xâu JSON và in ra chỉ số BMI và xếp hạng
  // Yêu cầu người dùng nhập chuỗi JSON
  print('\nNhập chuỗi JSON: ');
  String jsonInput = stdin.readLineSync()!;
  // Chuyển chuỗi JSON thành đối tượng Map
  Map<String, dynamic> jsonMap = jsonDecode(jsonInput);
  // Tạo đối tượng sinh viên từ dữ liệu Map
  Student studentFromJson = Student.fromJson(jsonMap);
  // Kiểm tra xem quá trình chuyển đổi từ JSON có thành công không
  //  '{\"name\":\"n1\",\"age\":11,\"weight\":111.0,\"height\":11.0,\"gpa\":9.0}'
  //{"name":"n1","age":11,"weight":111.0,"height":11.0,"gpa":9.0}
  print(studentFromJson.toString());
}