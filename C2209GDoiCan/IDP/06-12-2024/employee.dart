import 'person.dart';

class Employee extends Person {
  final double salary;
  Employee(
      {required super.id,
      required super.age,
      required super.name,
      required this.salary});
}
