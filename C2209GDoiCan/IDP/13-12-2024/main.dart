import 'bike.dart';
import 'car.dart';
import 'electric_car.dart';

void main() {
  Car car = Car(brand: 'Ford', speed: 111, numberOfDoors: 4);
  Bike bike = Bike(brand: 'Brand11', speed: 22, hasGear: true);
  car.displayInfo();
  bike.displayInfo();
  ElectricCar electricCar =
      ElectricCar(brand: 'Brand22', speed: 333, numberOfDoors: 5);
  electricCar.chargeBattery();
}
