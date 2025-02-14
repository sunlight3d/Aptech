import 'dart:core';
import 'dart:io';

class Vehicle {
    final String maker;
    final String model;
    final double fuelConsumption;
    Vehicle({
        required this.maker,
        required this.model,
        required this.fuelConsumption,
    });
    double get distance => 50 * fuelConsumption;
    static input() {
        print('Maker:'); String maker = stdin.readLineSync() ?? '';
        print('Model:'); String model = stdin.readLineSync() ?? '';
        print('Fuel consumption:'); double fuelConsumption = double.parse(stdin.readLineSync() ?? '0');
        return Vehicle(maker: maker, model: model, fuelConsumption: fuelConsumption);
    }
    @override
    String toString() => 'maker: ${maker}, model: ${model}, fuelConsumption = ${fuelConsumption}';
}