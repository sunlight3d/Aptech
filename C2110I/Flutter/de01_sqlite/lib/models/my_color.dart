import 'package:flutter/material.dart';

class MyColor {
  int? id;
  String name;
  String hexValue;
  MyColor({
    this.id,
    required this.name,
    required this.hexValue
  });
  //calculated value from hexValue
  Color get color => Color(int.parse(hexValue.substring(1), radix: 16) + 0xFF000000);
  @override
  String toString() {
    // TODO: implement toString
    return 'name: ${this.name}, color: ${color}';
  }
  Map<String, dynamic> toMap() {
    //Map = json = Dictionary
    var map = <String, dynamic>{
      'name': name,
      'hexValue': hexValue
    };
    if (id != null) {
      map['id'] = id;
    }
    return map;
  }
  factory MyColor.fromMap(Map<String, dynamic> map) {
    return MyColor(
        id: map['id'],
        name: map['name'],
        hexValue: map['hexValue']
    );
  }
}