import 'product.dart';
import 'quality.dart';

int sum(int x, int y) {
  return x + y;
}

void main() {
  String fullName = "Nguyen Duc Hoang";
  var age = 19;
  print('name is : ${fullName}, age = ${age}');
  List<String> fruits = [
    "Lemon",
    "Banana",
    "orange",
    "strawbery",
    "kiwi",
    'apple'
  ];
  //iterate
  for (final fruit in fruits) {
    print(fruit);
  }
  print(fruits);
  print('Sum 2 and 3 is : ${sum(2, 3)}');
  //tim nhung qua co nhieu hon 5 ky tu
  List<String> filteredFruits =
      fruits.where((item) => item.length > 5).toList();
  //tao ra 1 array danh sach cac chu cai dau xong roi viet hoa
  print(filteredFruits);
  print(fruits.map((item) => item[0].toUpperCase()).toList());
  Product productA =
      Product(name: 'iphone 15 pro max', price: 123.45, quantity: 5);
  Product productB = Product(
      name: 'Bao Tay Chơi Game chơi Pubg, Liên Quân',
      price: 9.45,
      quantity: 10);
  productB.description = 'This si si  dcsiudh';
  Product productC = Product(
      name:
          'Miếng dán hình xăm tạm thời chống thấm nước lâu trôi lên đến 2 tuần',
      price: 123.45,
      quantity: 25);
  List<Product> products = List.of(<Product>[productA, productB, productC]);
  for (final product in products) {
    print(product);
  }
  print(Quality.veryGood.index);
}
