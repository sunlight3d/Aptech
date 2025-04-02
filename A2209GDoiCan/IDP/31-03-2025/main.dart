import 'dart:io';

void question1a() {
  int n = 0;
  print('Enter an integer n: ');
  n = int.parse(stdin.readLineSync() ?? '0');
  int result = 1;
  for (int i = 1; i <= n; i++) {
    result = result * i;
  }
  print('Factorial of n is : ${result}');
}

void question1b() {
  int a, b;
  print('Enter integer a:');
  a = int.parse(stdin.readLineSync() ?? '0');
  print('Enter integer b:');
  b = int.parse(stdin.readLineSync() ?? '0');
  print('Sum of a and b: ${a + b}');
  print('Difference of a and b: ${a - b}');
  print('Product  of a and b: ${a * b}');
  print(
    'Division of a and b: ${b != 0 ? a / b : ' Division by zero is not allowed'}',
  );
}

bool isPalindrome(String s) {
  for (int i = 0; i < s.length / 2; i++) {
    if (s[i] != s[s.length - i - 1]) {
      return false;
    }
  }
  return true;
}

void question1c() {
  String input = '';
  print('Enter a string: ');
  input = stdin.readLineSync() ?? ''; //A man, a plan, a  canal,    Panama
  input = input.replaceAll(RegExp('[\\s+,:]+'), "").toLowerCase();
  if (isPalindrome(input)) {
    print('This string is a palindrome');
  } else {
    print('This string is NOT a palindrome');
  }
}

void question1d() {
  int numberOfVowers = 0;
  int numberOfConsonants = 0;
  String input = '';
  const List<String> vowers = ['a', 'e', 'i', 'o', 'u'];
  print('Enter a string: '); // Hello, World!
  input = (stdin.readLineSync() ?? '').toLowerCase();
  for (int i = 0; i < input.length; i++) {
    String item = input[i];
    if (vowers.contains(item)) {
      numberOfVowers++;
    } else {
      bool isNormalCharacter = RegExp(r'[a-z]').hasMatch(item);
      if (isNormalCharacter) {
        numberOfConsonants++;
      }
    }
  }
  print('Number of consonants : ${numberOfConsonants}');
  print('Number of vowers : ${numberOfVowers}');
}

bool isSpecialCharacter(String c) {
  return RegExp(r'[^a-zA-Z0-9\s]').hasMatch(c);
}

void main() {
  //question1a();
  //question1b();
  //question1c();
  question1d();
}
