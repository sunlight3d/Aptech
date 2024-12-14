import 'dart:io';

void question01a() {
  int n;
  print('Enter a number: ');
  n = int.parse(stdin.readLineSync() ?? '0');
  if (n <= 0) {
    print('Invalid input');
    return;
  }
  int result = 1;
  for (int i = 1; i <= n; i++) {
    result *= i;
  }
  print('result : ${result}');
}

void question01b() {
  int a, b;
  print('Enter number a : ');
  a = int.parse(stdin.readLineSync() ?? '0');
  print('Enter number b : ');
  b = int.parse(stdin.readLineSync() ?? '0');
  print('Sum of a and b: ${a + b}');
  print('Difference of a and b:  ${(a - b).abs()}');
  print('Product of a and b: ${a * b}');
  if (b == 0) {
    print('Division of a by b: Division by zero is not allowed');
  } else {
    print('Division of a and b: ${a / b}');
  }
}

void question01c() {
  String inputString;
  print('Enter a string to check : ');
  inputString = stdin.readLineSync() ?? '';
  inputString = inputString.replaceAll(" ", "");
  inputString = inputString.replaceAll(",", "");
  print(inputString);
  if (checkPalindrome(inputString) == true) {
    print('The string is a palindrome');
  } else {
    print('The string is not a palindrome.');
  }
}

bool checkPalindrome(String inputString) {
  for (int i = 0; i < inputString.length / 2; i++) {
    if (inputString[i].toLowerCase() !=
        inputString[inputString.length - i - 1].toLowerCase()) {
      print(
          '${inputString[i].toLowerCase()} - ${inputString[inputString.length - i - 1].toLowerCase()}');
      return false;
    }
  }
  return true;
}

void main() {
  //question01a();
  //question01b();
  question01c();
}
