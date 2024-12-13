import 'car.dart';
import 'electric.dart';

class ElectricCar extends Car with Electric {
  ElectricCar(
      {required super.brand,
      required super.speed,
      required super.numberOfDoors});
}
