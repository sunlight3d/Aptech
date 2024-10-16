import 'dart:io';
class Student {
  String name;
  int age;
  double weight;
  double height;
  double gpa;
  double get bmi => weight / (height * height);
  @override
  String toString() {
    return 'name: ${name},'
        'age: ${age},'
        'weight: ${weight},'
        'height: ${height},'
        'bmi: ${bmi}';
  }
  String get range {
    if (gpa < 0 || gpa > 10) {
      throw new Exception("Value must be > 0 and <= 10");
    } else if (gpa >= 8.5) {
      return "A";
    } else if (gpa >= 7.5) {
      return "B";
    } else if (gpa >= 6.5) {
      return "C";
    } else {
      return "D";
    }
  }

  Student({
    required this.name,
    required this.age,
    required this.height,
    required this.weight,
    required this.gpa
  });

  factory Student.input() {
    print('Enter name: ');
    String _name = stdin.readLineSync() ?? '';

    print('Enter age: ');
    int _age = int.parse(stdin.readLineSync() ?? '18');

    print('Enter weight: ');
    double _weight = double.parse(stdin.readLineSync() ?? '0');

    print('Enter height: ');
    double _height = double.parse(stdin.readLineSync() ?? '0');

    print('Enter gpa: ');
    double _gpa = double.parse(stdin.readLineSync() ?? '0');

    return new Student(
        name: _name,
        age: _age,
        height: _height,
        weight: _weight,
        gpa: _gpa
    );
  }
}