import 'vehicle.dart';

class Bike extends Vehicle {
  bool hasGear = false;
  // Constructor của Bike
  Bike({required String brand, required int speed, required this.hasGear})
      : super(brand: brand, speed: speed);
  @override
  void displayInfo() {
    print('brand: ${super.brand}, speed: ${super.speed}, hasGear: ${hasGear}');
  }
}
