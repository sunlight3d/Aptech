import 'dart:collection';
import 'dart:io';

import 'mobile.dart';

List<Mobile> mobiles = [];

void main() {
  print('--------------------------------------------------');
  print('1 - Input list of mobiles');
  print('2 - Sort by name');
  print('3 - Analyze statistics of Mobiles by manufacturer');
  print('4 -  Find Mobiles by manufacturer and price');
  print('5 -  Exit');
  print('--------------------------------------------------');
  int choice = 0;
  while(choice != 5) {
    switch(choice) {
      case 1:
        input();
        break;
      case 2:
        analyze();
        break;
      case 3:
        break;
      case 4:
        break;
      default:
        if(choice != 5) {
          print('Please choose 1-4');
        }
    }
    print('Do you want to continue(y/n) ?');
    String answer = stdin.readLineSync()?.toLowerCase().trim() ?? '';
    if (answer == 'y') {
      // Code for 'y' answer
    } else {
      break;
    }
  }
}
void input() {
  int numberOfMobiles = int.parse(stdin.readLineSync() ?? "0");
  mobiles.clear();
  for(int i = 0; i < numberOfMobiles; i++) {
    Mobile mobile = Mobile.input();
    if(mobile != null) {
      mobiles.add(mobile);
    }
  }
}
void analyze() {
  Map<String, int> hashMap = {};

  for (var mobile in mobiles) {
    hashMap[mobile.name] = (hashMap[mobile.name] ?? 0) + 1;
  }
  print('Statistic results:');
  for (var entry in hashMap.entries) {
    print('There are ${entry.value} manufactured by ${entry.key}');
  }
}
void find() {
  print('Manufacture: ');
  String manufacture = stdin.readLineSync()?.trim() ?? '';

  print('Min price: ');
  double minPrice = double.tryParse(stdin.readLineSync()?.trim() ?? '0') ?? 0;

  print('Max price: ');
  double maxPrice = double.tryParse(stdin.readLineSync()?.trim() ?? '0') ?? 0;

  List<Mobile> filteredMobiles = mobiles.where((mobile) {
    return (mobile.manufacturer??'').toLowerCase() == manufacture.toLowerCase() &&
        mobile.price > minPrice &&
        mobile.price < maxPrice;
  }).toList();

  for (var mobile in filteredMobiles) {
    print('Mobile: ${mobile.name}, Price: ${mobile.price}');
  }
}