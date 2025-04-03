import 'dart:io';

class Student {
  String name;
  int age;
  double weight, height;
  double gpa = 0;

  Student({
    required this.name,
    required this.age,
    required this.weight,
    required this.height,
    this.gpa = 0,
  });
  double get bmi =>
      height == 0
          ? throw Exception("Cannot calculate")
          : weight / (height * height);
  String get rank =>
      gpa > 8.5
          ? 'A'
          : (gpa >= 7.5
              ? 'B'
              : (gpa >= 6.5 ? 'C' : (gpa >= 0 ? 'D' : 'Invalid')));

  static Student input() {
    print('Ten nguoi: ');
    String name = stdin.readLineSync() ?? '';
    print('Tuoi: ');
    int age = int.parse(stdin.readLineSync() ?? '18');
    print('Can nang: ');
    double weight = double.parse(stdin.readLineSync() ?? '0');
    print('Chieu cao: ');
    double height = double.parse(stdin.readLineSync() ?? '0');
    return Student(name: name, age: age, weight: weight, height: height);
  }

  @override
  String toString() {
    // TODO: implement toString
    return 'Ten nguoi: ${name}' +
        'Tuoi: $age, ' +
        'Can nang: $weight, ' +
        'Chieu cao: $height, ' +
        'Diem tong ket: $gpa, ' +
        'rank: $rank, ' +
        'bmi: $bmi';
  }

  Map<String, dynamic> toJON() {
    Map<String, dynamic> result = Map();
    result['name'] = this.name;
    result['age'] = this.age;
    result['weight'] = this.weight;
    result['height'] = this.height;
    result['weight'] = this.weight;
    return result;
  }

  factory Student.fromJSON(Map<String, dynamic> map) {
    return Student(
      name: map['name'] as String? ?? 'Unknown',
      age: map['age'] as int? ?? 0,
      weight: (map['weight'] as num?)?.toDouble() ?? 0.0,
      height: (map['height'] as num?)?.toDouble() ?? 0.0,
    );
  }
}
