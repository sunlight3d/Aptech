import "dart:io";

import "vehicle.dart";
void main() {
  Vehicle v1 = Vehicle.input();
  //print(v1);
  print('Distance on a full tank: ${v1.distance}');
}