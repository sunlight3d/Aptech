import 'dart:io';
import 'dart:math';
import 'dart:convert';

class Student {
  late String name;
  late int age;
  late double weight;
  late double height;
  late double gpa;
  // Named constructor
  Student() {
    name = '';
    age = 18;
    weight = 50;
    height = 150;
    gpa = 0;
  }
  void input(){
    print('Enter name: ');
    this.name = stdin.readLineSync() ?? '';

    print('Enter age: ');
    this.age = int.parse(stdin.readLineSync()!);

    print('Enter weight: ');
    this.weight = double.parse(stdin.readLineSync()!);

    print('Enter height: ');
    this.height = double.parse(stdin.readLineSync()!);

    print('Enter gpa: ');
    this.gpa = double.parse(stdin.readLineSync()!);
  }
  double get bmi {
    if (this.weight <= 0 || this.height <= 0) {
      return double.nan;
    }
    double result = weight / pow(this.height / 100, 2);
    return double.parse(result.toStringAsFixed(2));
  }
  String get rank {
    return gpa > 8.5 ? 'a' :
      (gpa >= 7.5 && gpa < 8.5 ? 'b' :
        (gpa >= 6.5 && gpa < 7.5 ? 'c' :
          (gpa < 6.5 ? 'd' : 'Invalid')));
  }
  Map<String, dynamic> toJson() {
    return {
      'name': this.name,
      'age': this.age,
      'weight': this.weight,
      'height': this.height,
      'gpa': this.gpa
    };
  }

  static void fromJson(String jsonString) {
    // Parse the JSON string
    Map<String, dynamic> jsonMap = json.decode(jsonString);
    // Access the parsed data
    Student newStudent = Student();
    newStudent.name = jsonMap['name'];
    newStudent.age = jsonMap['age'] is int ? jsonMap['age'] : int.parse(jsonMap['age']);
    newStudent.weight = jsonMap['weight'] is num ? jsonMap['weight'].toDouble() : double.parse(jsonMap['weight']);
    newStudent.height = jsonMap['height'] is num ? jsonMap['height'].toDouble() : double.parse(jsonMap['height']);
    newStudent.gpa = jsonMap['gpa'] is num ? jsonMap['gpa'].toDouble() : double.parse(jsonMap['gpa']);
    print(newStudent.toString());
  }
  @override
  String toString() {
    return 'Name: ${this.name}\n'+
    'Age: ${age} \n' +
    'Weight: ${this.weight} \n' +
    'Height: ${this.height} \n' +
    'GPA: ${this.gpa} \n' +
    'Rank: ${this.rank} \n' +
    'BMI: ${bmi} \n';
  }
}
