import 'package:blogapp/models/person.dart';
import 'package:flutter/material.dart';

class Welcome extends StatelessWidget {
  //properties
  int x, y;
  Welcome({
    super.key,
    required this.x,
    required this.y
  });

  @override
  Widget build(BuildContext context) {
    print("haha");
    Person personA = Person(name: 'hoang');
    Person personB = Person(name: 'john', age: 22);
    List<Person> persons = [personA, personB];
    persons.forEach((person) {
      print(person);
    });
    for(int i = 0; i < persons.length; i++) {
      Person person = persons[i];
      print(person);
    }
    return Scaffold(
      body: Center(
        child: Text('This is welcome, x = ${x}, y = $y, personA = ${personA}'),
      ),
    );
  }
}
