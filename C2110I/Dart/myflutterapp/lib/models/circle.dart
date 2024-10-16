import 'dart:math';

import 'package:flutter/cupertino.dart';

class Circle {
  final double radius;
  Circle({
    this.radius = 1.0,
  });
  get perimeter => 3.14 * radius * 2;
  get area => pi * radius * radius;
}