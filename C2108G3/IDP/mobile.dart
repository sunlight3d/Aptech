import 'dart:io';

class Mobile {
  String name;
  String? manufacturer;
  int releasedYear;
  double price;
  factory Mobile.input() {
  //static Mobile input() {
    print('Enter name: ');
    String _name = stdin.readLineSync() ?? '';
    print('Enter manufacturer: ');
    String _manufacturer = stdin.readLineSync() ?? '';
    int _releasedYear = 0;
    do {
      print('Enter releasedYear: ');
      _releasedYear = int.parse(stdin.readLineSync() ?? '2000');
      if (_releasedYear < 1999) {
        print('Release year must be >= 1999');
      }
    } while (_releasedYear < 1999);

    double _price = 0;
    do {
      print('Enter price: ');
      _price = double.parse(stdin.readLineSync() ?? '0');
      if (_price < 500 || _price > 6000) {
        print('Release year must be >= 1999');
      }
    } while (_price < 500 || _price > 6000);

    return new Mobile(
        name: _name,
        releasedYear: _releasedYear,
        price: _price,
        manufacturer: _manufacturer);
  }
  Mobile({
    required this.name,
    this.manufacturer,
    required this.releasedYear,
    required this.price
  });
}