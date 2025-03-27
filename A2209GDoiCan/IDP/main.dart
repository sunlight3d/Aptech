void main() {
  int x = 1;
  int y = 2;
  int sum = x + y;
  String firstName = 'Nguyen';
  String lastName = "Duc Hoang";
  String fullName = '$firstName $lastName';
  print('sum x and y is: $sum');
  print('fullname is : $fullName');
  List<String> fruits = ['banana', 'apple'];
  fruits.add('lemon');
  for (String fruit in fruits) {
    print('$fruit \n');
  }
}
