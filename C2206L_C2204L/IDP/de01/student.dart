import 'dart:convert';
import 'dart:io';

class Student {
  String name;
  int age;
  double weight;
  double height;
  double gpa;
  Student({
    required this.name,
    required this.age,
    required this.weight,
    required this.height,
    required this.gpa,
  })  : assert(age > 0, 'Age must be greater than 0'),
        assert(weight > 0, 'Weight must be greater than 0'),
        assert(height > 0, 'Height must be greater than 0'),
        assert(gpa >= 0, 'GPA must be greater than or equal to 0');
  // Convert Student object to JSON format
  Map<String, dynamic> toJson() {
    return {
      'name': name,
      'age': age,
      'weight': weight,
      'height': height,
      'gpa': gpa,
    };
  }

  // Factory constructor to create a Student object from JSON
  factory Student.fromJson(Map<String, dynamic> json) {
    return Student(
      name: json['name'] as String,
      age: json['age'] as int,
      weight: json['weight'] as double,
      height: json['height'] as double,
      gpa: json['gpa'] as double,
    );
  }
  double get bmi => weight / (height * height);
  String get rank {
    if(gpa > 8.5) {
      return 'a';
    } else if(gpa > 7.5 && gpa <= 8.5) {
      return 'b';
    } else if(gpa > 6.5 && gpa <= 7.5) {
      return 'c';
    } else if(gpa <= 6.5) {
      return 'd';
    }
    return 'invalid';
  }
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

    return Student(
        name: _name,
        age: _age,
        weight: _weight,
        height: _height,
        gpa: _gpa
    );

  }
  @override
  String toString() {
    return 'Ten nguoi: $name, \n'
            'age: $age, \n'
            'weight: $weight, '
            'height: $height, '
            'bmi: $bmi, '
            'rank: $rank, '
            'gpa: $gpa}';
  }
}