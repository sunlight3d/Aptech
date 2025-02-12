import 'product.dart';

void main() {
  int x = 10;
  print('Haha');
  //c:\flutter/bin/cache/dart-sdk
  String name = 'Hoang';
  int age = 18;
  String info = 'Name is : ${name}, age = ${age}';
  print(info);
  Map<String, dynamic> map = Map();
  map['age'] = 18;
  map['name'] = 'Hoang';
  print('Haha');
  // map.forEach((key, value) {
  //   print('Key = ${key}, value = ${value}');
  // });
  map.forEach((key, value) => print('Key = ${key}, value = ${value}'));
  //map.forEach(print);
 final List<int> someNumbers = <int>[2, 4, 6];
 someNumbers.add(9);
 //someNumbers = [3,4,6]; //error, final cannot be re-assigned
 print(someNumbers);

 const List<String> fruits = ['orange', 'apple'];
 //fruits.add('banana');
  print(fruits);
  var a = 10;
  a = 20;
 //a = 'Hoang';
  dynamic b = 10;
  b = 'Hoang';
  //b.add('dd');

  dynamic someNumbers2 = [4,6,7];
  (someNumbers2 as List<int>).add(9);
  print(someNumbers2);

  Map<String, dynamic> person1 = Map();
  person1['name'] = 'Jenny';
  person1['age'] = 20;

  Map<String, dynamic> person2 = person1;
  person2['name'] = 'Kaka';
  print(person1['name']);
  
  dynamic m1 = {
    'name': 'An',
    'age': 33
  };
  dynamic m2 = m1;
  print('hahahaha');

  Map<dynamic, dynamic> m3 = Map();
  m3[1] = 'Di choi';
  m3['name'] = 'something';
  print('aa');

  dynamic xx = '123';
  print('aa');

  Product iphone15 = Product(
      name: 'iphone 15',
      code: 'A1123',
      stock: 12,
      sold: 10
  );
  iphone15.sold = 10;
  iphone15.sold = 9;
  print('Quantity is : ${iphone15.quantity}');
}