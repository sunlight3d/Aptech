import 'dart:io';
import 'dart:math';
bool isPalindrome(int x) {
    String stringValue = '${x}';
    for(int i = 0; i < stringValue.length / 2; i++) {
        if(stringValue[i] != stringValue[stringValue.length - i - 1]) {
            return false;
        }
    }
    return true;
}
int factorial(int n) {
    int result = 1;
    for(int i = n; i > 0; i--) {
        result = result * i;
    }
    return result;
}
void bai1b() {
    print('Enter the first number (a): ');
    int a = int.parse(stdin.readLineSync() ?? '0');

    print('Enter the first number (b): ');
    int b = int.parse(stdin.readLineSync() ?? '0');
    a = min(a, b);
    b = max(a, b);
    int result = 0;
    for(int i = a; i <= b; i++) {
        result += factorial(i);
    }
    print('result = ${result}');
}
void bai1a() {
    int x = 0;
    print('Please enter an integer : ');
    x = int.parse(stdin.readLineSync() ?? '0');
    bool result = isPalindrome(x);
    if(result == true) {
        print('YES');
    } else {
        print('NOT palindrome');
    }
}
void bai1c() {
    int x;
    print('Please enter an integer : ');
    x = int.parse(stdin.readLineSync() ?? '0');
    String stringValue = x.toString();
    int sumOfOdds = 0;
    int sumOfEvens = 0;
    for(int i = 0; i < stringValue.length; i++) {
        int number = int.parse(stringValue[i]);
        if(number % 2 == 0) { 
            sumOfEvens += number;
        } else {
            sumOfOdds += number;
        }
    }   
    print('Sum of odds: $sumOfOdds');
    print('sum of evens : ${sumOfEvens}');
}
void bai1d() {
    int n = 5
    for(int i = 1; i <= 5; i++) {
        for(int j = 1; j <= i; j++) {
            print('$')
        }
    }

}
void main() {
    //bai1a();
    //bai1b();
    bai1c();
}
/**
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
1 6 15 20 15 6 1
 */