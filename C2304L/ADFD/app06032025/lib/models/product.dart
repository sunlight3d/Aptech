class Product {
  final String name;
  final String description;
  final String url;
  double? rate;
  int? numberOfReviews;
  Product({
    required this.name,
    required this.description,
    required this.url,
    this.rate,
    this.numberOfReviews
  });
}