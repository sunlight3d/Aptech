class Person {
  final String? name;
  final int? age;
  Person({this.name, this.age});
  @override
  String toString() => 'Name: $name, Age = ${age ?? 18}';
}