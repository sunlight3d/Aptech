import 'student.dart';

void main() async {
  int x = 1;
  int y = 2;
  // int sum = x + y;
  // String firstName = 'Nguyen';
  // String lastName = "Duc Hoang";
  // String fullName = '$firstName $lastName';
  // print('sum x and y is: $sum');
  // print('fullname is : $fullName');
  // List<String> fruits = ['banana', 'apple'];
  // fruits.add('lemon');
  // for (String fruit in fruits) {
  //   print('$fruit \n');
  // }

  Student studentA = Student(
    age: 20,
    id: 123,
    firstName: 'Nguyen',
    lastName: 'Van A',
  );
  //studentA.fullName = 'xyz';//giong C#
  print(studentA.fullName);

  //example of key-value pair
  final Map person = {'name': 'Hoang', 'age': 20};
  person['name'] = 'xyz'; //ok
  //person = {'name': 'John', 'age': 20}; //cannot re-assign

  const Map person2 = {'name': 'Hoang123', 'age': 30};
  //person2 = person;//cannot re-assign
  //person2['name'] = 'abc';//cannot change object
  print(person2);

  Future<void> printWithDelay(String message) async {
    await Future.delayed(Duration(seconds: 1));
    print(message);
  }

  await printWithDelay('haha');
  print('kaka1');
  await printWithDelay('hehe');
  print('kaka2');
  Student? studentB;
  //....
  studentB = Student(
    age: 21,
    id: 44,
    firstName: 'Nguyen',
    lastName: 'Van B',
  );
  print(studentB!.firstName);
}
