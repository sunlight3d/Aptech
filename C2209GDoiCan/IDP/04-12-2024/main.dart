import 'dart:math';
int sum(int x, int y) {
    return x + y;
}
void main() {
  String fullName = "Nguyen Duc Hoang";
  var age = 19;
  print('name is : ${fullName}, age = ${age}');
  List<String> fruits = ["Lemon", "Banana", "orange", "strawbery", "kiwi", 'apple'];
  //iterate
  for(final fruit in fruits) {
    print(fruit);
  }  
  print(fruits);
  print('Sum 2 and 3 is : ${sum(2,3)}');
  //tim nhung qua co nhieu hon 5 ky tu
  List<String> filteredFruits = fruits.where((item) => item.length > 5).toList();
  //tao ra 1 array danh sach cac chu cai dau xong roi viet hoa  
  print(filteredFruits);
  print(fruits.map((item) => item[0].toUpperCase()).toList());
  
}