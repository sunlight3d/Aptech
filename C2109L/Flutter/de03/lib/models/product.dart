class Product {
  final String imageName;
  final String title;
  String? subTitle;
  final String description;
  final double price;
  final int? hexValue;
  Product({
    required this.imageName,
    required this.title,
    required this.price,
    this.subTitle,
    required this.description,
    this.hexValue
  });
}