import 'vehicle.dart';

class Car extends Vehicle {
  int? numberOfDoors;
  Car({required String brand, required int speed, required this.numberOfDoors})
      : super(brand: brand, speed: speed);
  @override
  void displayInfo() {
    print(
        'brand: ${super.brand}, speed: ${super.speed}, numberOfDoors: ${numberOfDoors}');
  }
}
