import 'vehicle.dart';

class VehicleExtend extends Vehicle {
  VehicleExtend({required super.maker, required super.model, required super.fuelConsumption});
  double calculateInsurance() {
    return 1.0;
  }
}