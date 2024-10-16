import 'package:de01/models/my_color.dart';

class ColorRepository {
  List<MyColor> colors = <MyColor>[
    MyColor(name: 'white', hexValue: 0xFFFFFFFF),
    MyColor(name: 'purple', hexValue: 0xFF800080),
    MyColor(name: 'blue', hexValue: 0xFF0000FF),
    MyColor(name: 'cyan', hexValue: 0xFF00FFFF),
    MyColor(name: 'red', hexValue: 0xFFFF0000),
    MyColor(name: 'yellow', hexValue: 0xFFFFFF00),
    MyColor(name: 'orange', hexValue: 0xFFFFA500),
  ];

  Future<List<MyColor>> fetchColors() async {
    // Simulate fetching products from an external source (e.g., API, database)
    await Future.delayed(const Duration(milliseconds: 200));
    return colors;
  }
}