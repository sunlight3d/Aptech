//import 'package:flutter/material.dart';
import 'dart:convert';
import 'dart:io';
import 'package:luyentap01/course.dart';

int countSubstringOccurrences(String substring, String text) {
  List<String> parts = text.split(substring);
  int count = parts.length - 1;
  return count;
}

void buildMenu() {
  int choice = 0;
  int numberOfCourses = 0;
  List<Course> courses = <Course>[];
  while(choice != 4) {
    print('1-Input detail information of courses');
    print('2-Sort & Display detail information of courses');
    print('3-Export all courses into file named course.dat by binary mode');
    print('4-Exit');
    print('Enter your choice:');
    choice = int.parse(stdin.readLineSync() ?? '0');
    String filePath = './output.json';
    late Map<String, List<Course>> map;
    switch(choice) {
      case 1:
        print('You chooose 1');
        while(numberOfCourses <= 0) {
          print('Number of courses: ');
          numberOfCourses = int.parse(stdin.readLineSync()!);
          for(int i = 0; i < numberOfCourses; i++) {
            Course course = Course();
            course.input(i);
            courses.add(course);
          }
        }
      case 2:
        print('You chooose 2');
        //after sorting
        courses.sort((course1, course2) {
          return course1.courseName.compareTo(course2.courseName);
        });
        //iterate a list(array)
        /*
        courses.forEach((course) {
          print(course.toString());
        });
        */
        /*
        for(int i = 0; i < courses.length; i++) {
          print(courses[i].toString());
        }
        */
        for (var course in courses) {
          print(course.toString());
        }
      case 3:
        print('You chooose 3');
        map = {
          "courses": courses
        };
        String jsonString = jsonEncode(map);
        File('./output.json').writeAsString(jsonString);
      case 4:
        print('You chooose 4');
        String jsonString = File(filePath).readAsStringSync();
        dynamic jsonObject = jsonDecode(jsonString);
        if(jsonObject is Map<String,List<Course>>) {
          print('haha');
        }
      default:
        print('Please choose 1-4');
    }
  }

}
void bai01(){
  print("input source :");
  String source = stdin.readLineSync()!;
  print("input searching :");
  String searching = stdin.readLineSync()!;
  int count = countSubstringOccurrences(searching, source);
  print('The substring "$searching" appears in "$source" $count times.');
}
void main() {
  //bai01();
  //buildMenu();
  //runApp(const MyApp());
  test();
}

void test() {
  Course c1 = Course();
  Course c2 = Course();

  c1.courseName = 'n11';
  c1.authorName = 'a11';
  c1.description = 'dd11';
  c1.address = 'aa11';
  c1.startedDate = '2023-01-01';
  c1.price = 111;

  c2.courseName = 'n22';
  c2.authorName = 'a22';
  c2.description = 'dd22';
  c2.address = 'aa22';
  c2.startedDate = '2013-01-02';
  c2.price =222;
  try {
    Map<String, List<Map<String, dynamic>>> map = {
      "courses": <Map<String, dynamic>>[
        c1.toMap(),
        c2.toMap()
      ]
    };
    String jsonString = jsonEncode(map);
    File('./output.json').writeAsString(jsonString);
  }catch(e) {
    print('ererroror');
  }

}


