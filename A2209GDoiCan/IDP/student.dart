class Student {
  int id;
  String? firstName;
  String? lastName;
  int age;
  Student({required this.id, this.firstName, this.lastName, required this.age});
  String get fullName => '${firstName} $lastName'; //getter, read-only
  @override
  String toString() {
    return 'id : ${id}, firstname : ${firstName ?? ''}, lastname: ${lastName ?? ''}';
  }
}
