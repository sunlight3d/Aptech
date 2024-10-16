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
    print("Student's details: ");
    return """
      name: $name, 
      age: $age, 
      weight: $weight, 
      height: $height, 
      gpa: $gpa, 
      bmi: ${bmi.toStringAsFixed(2)},
      gpa: ${gpa},
      rank: ${range}
      """;
  }
  Map<String, dynamic> toJson() {
    return {
      "name": name,
      "age": age,
      "weight": weight,
      "height": height,
      "gpa": gpa,
    };
  }
  //static Student fromJson(Map<String, dynamic> json) {
  factory Student.fromJson(Map<String, dynamic> json) {
    try {
      // Lấy các giá trị từ chuỗi JSON
      String name = json['name'] ?? '';
      int age = (json['age']?.toInt()) ?? 18;
      double weight = json['weight']?.toDouble();
      double height = json['height']?.toDouble();
      double gpa = json['gpa']?.toDouble();

      // Kiểm tra xem có giá trị nào bị thiếu không
      final bool validateWeightHeight = !weight.isNegative && weight > 0 &&
          !height.isNegative && height > 0;
      final bool validateGpa = !gpa.isNaN && !gpa.isNegative;

      if (!validateGpa || !validateWeightHeight) {
        throw FormatException("Dữ liệu JSON không hợp lệ: Thiếu giá trị");
      }

      // Kiểm tra cân nặng và chiều cao có giá trị hợp lệ không
      if (weight <= 0 || height <= 0) {
        throw Exception(
            'Cân nặng hoặc chiều cao không hợp lệ trong dữ liệu JSON.');
      }

      // Tạo đối tượng Student từ dữ liệu JSON
      Student student = Student(
          name: name,
          age: age,
          height: height,
          weight: weight,
          gpa: gpa
      );
      //Student student = Student(name: name, age, weight, height, gpa);
      return student;
    } catch (e) {
      // Nếu có lỗi xảy ra trong quá trình xử lý JSON, ném ra một Exception
      throw Exception('Dữ liệu không hợp lệ: $e');
    }
  }
  String get range {
    if (gpa < 0 || gpa > 10) {
      //throw new Exception("Value must be > 0 and <= 10");
      throw new Exception("Invalid.Value must be > 0 and <= 10");
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