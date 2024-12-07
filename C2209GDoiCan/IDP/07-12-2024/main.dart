import 'dart:io';
import 'product.dart';

void bai01() {
  int choice = 0;
  List<Map<String, dynamic>> students = [];
  print('1. Add new student');
  print('2. Show all students');
  print('3. Update a student');
  print('4. Delete a student');
  do {
    print('Enter your choice(1 - 5)');
    choice = int.parse(stdin.readLineSync() ?? "0");
    switch (choice) {
      case 1:
        Map<String, dynamic> student = Map();
        print("Enter student's name : ");
        student['name'] = stdin.readLineSync();

        print("Enter student's age : ");
        student['age'] = int.parse(stdin.readLineSync() ?? '18');

        students.add(student);
        break;
      case 2:
        students.forEach((student) => print(student));
        break;
      case 3:
        print("Enter student's name to update : ");
        String searchName = stdin.readLineSync() ?? '';
        Map<String, dynamic>? foundStudent = students
            .where((student) =>
                student['name'].toString().toLowerCase() ==
                searchName.toLowerCase())
            .toList()
            .firstOrNull;
        if (foundStudent == null) {
          print('Cannot find the student with name = ${searchName}');
        } else {
          print('Enter new name : ');
          foundStudent['name'] = stdin.readLineSync() ?? searchName;

          print('Enter new age : ');
          foundStudent['age'] =
              int.parse(stdin.readLineSync() ?? foundStudent['age']);
        }
        break;
      case 4:
        print("You choose 4");
        break;
      default:
        break;
    }
  } while (choice != 5);
  print('End program');
}

void bai02() {
  List<Product> products = [];
  print('Number of products : ');
  int numberOfProducts = int.parse(stdin.readLineSync() ?? '3');
  for (int i = 0; i < numberOfProducts; i++) {
    Product product = Product.input();
    products.add(product);
  }
}

void main() {
  // bai01();
  bai02();
}
