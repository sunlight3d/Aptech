import 'package:myflutterapp/models/laptop.dart';

class LaptopManagement {
  List<Laptop> laptops;

  LaptopManagement(this.laptops);

  // Indexer để lấy ra một laptop cụ thể bằng chỉ số.
  Laptop operator [](int index) {
    if (index >= 0 && index < laptops.length) {
      return laptops[index];
    } else {
      throw RangeError("Index out of range");
    }
  }

  // Phương thức để lọc các laptop theo tên.
  List<Laptop> filterLaptops(String keyword) {
    return laptops.where((laptop) => laptop.name.contains(keyword)).toList();
  }
}

void main() {
  // Tạo danh sách các laptop mẫu.
  List<Laptop> sampleLaptops = [
    Laptop(id: 1, name: "Laptop A", price: 1000.0, vat: 0.1),
    Laptop(id: 2, name: "Laptop B", price: 1200.0, vat: 0.1),
    Laptop(id: 3, name: "Laptop C", price: 800.0, vat: 0.1),
    Laptop(id: 4, name: "Laptop D", price: 1500.0, vat: 0.1),
  ];

  // Khởi tạo đối tượng LaptopManagement với danh sách laptop mẫu.
  LaptopManagement laptopManager = LaptopManagement(sampleLaptops);

  // Sử dụng indexer để lấy ra laptop thứ 2 (chỉ số 1).
  Laptop laptopAtIndex1 = laptopManager[1];
  print("Laptop at index 1: ${laptopAtIndex1.name}");

  // Sử dụng phương thức filterLaptops để lọc các laptop có tên chứa "A".
  List<Laptop> filteredLaptops = laptopManager.filterLaptops("A");
  print("Filtered Laptops:");
  for (var laptop in filteredLaptops) {
    print("Name: ${laptop.name}");
  }
}
