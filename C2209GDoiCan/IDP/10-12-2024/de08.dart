import 'dart:convert';
import 'dart:io';

import 'product.dart';

void question01a() {
  String inputString = '';
  print('Enter a string to check : ');
  inputString = stdin.readLineSync() ?? '';
  inputString = inputString.trim();
  if (inputString.length == 0) {
    print('Not a palindrome');
    return;
  }
  for (int i = 0; i < inputString.length / 2; i++) {
    String start = inputString[i];
    String end = inputString[inputString.length - 1 - i];
    //print('${start} - ${end}');
    if (start != end) {
      print('Not a palindrome');
      return;
    }
  }
  print('This is a palindrome');
}

int factorial(int n) {
  if (n <= 1) {
    return 1;
  }
  int result = 1;
  for (int i = 1; i <= n; i++) {
    result *= i;
  }
  return result;
}

void question01b() {
  int a, b, result;
  print('Enter a = ');
  a = int.parse(stdin.readLineSync() ?? '0');

  print('Enter b = ');
  b = int.parse(stdin.readLineSync() ?? '0');
  result = 0;
  for (int i = a; i <= b; i++) {
    result += factorial(i);
  }
  print('The sum of factorials from ${a} to ${b} is ${result}');
}

void question01c() {
  String inputNumber;

  print('Enter an integer:');
  inputNumber = stdin.readLineSync() ?? '';
  inputNumber = inputNumber.trim();
  int totalOdds = 0;
  int totalEvens = 0;
  List<int> oddNumbers = [];
  List<int> evenNumbers = [];
  for (int i = 0; i < inputNumber.length; i++) {
    int eachDigit = int.parse(inputNumber[i]);
    if (eachDigit % 2 == 0) {
      totalEvens += eachDigit;
      evenNumbers.add(eachDigit);
    } else {
      totalOdds += eachDigit;
      oddNumbers.add(eachDigit);
    }
  }
  // In kết quả
  print('Sum of even digits: $totalEvens (${evenNumbers.join(' + ')})');
  print('Sum of odd digits: $totalOdds (${oddNumbers.join(' + ')})');
}

void question02ab() {
  Product newProduct = Product.input();
  print('Enter quantity to buy:');
  int quantity = int.parse(stdin.readLineSync() ?? '0');
  newProduct.updateStock(quantity);
  print('Total price: ${newProduct.calculateTotalPrice(quantity)}');

  print('tax is : ${newProduct.tax}');
}

void question02c() {
  int numberOfProducts;
  List<Product> products = <Product>[];
  print('Enter number of products:');
  numberOfProducts = int.parse(stdin.readLineSync() ?? '0');
  for (int i = 0; i < numberOfProducts; i++) {
    Product product = Product.input();
    products.add(product);
  }
  print('Sorted Products by Price: ');
  products.sort((a, b) => a.price.toInt() - b.price.toInt());
  int index = 0;
  for (final Product product in products) {
    index++;
    print('${index} . ${product.toString()}');
  }
}

void main() {
  //print('de 08');
  //question01a();
  //print(factorial(100));
  //question01b();
  //question01c();

  //question02ab();
  question02c();
}
