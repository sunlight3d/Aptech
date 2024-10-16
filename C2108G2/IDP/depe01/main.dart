
import 'dart:io';
import 'dart:math';

void main() {
  //bai02();
  //bai1c();
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

}