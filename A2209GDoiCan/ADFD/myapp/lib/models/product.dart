class Product {
  int? id;
  String title;
  String url;
  double price;
  int reviews;
  List<String> specifications;

  Product({
    this.id,
    required this.title,
    required this.url,
    required this.price,
    this.reviews = 0,
    this.specifications = const [],
  });

  factory Product.fromJson(Map<String, dynamic> json) {
    return Product(
      title: (json['title']?.toString() ?? '').trim().isEmpty
          ? 'Product Title'
          : json['title'].toString(),
      url: (json['url']?.toString() ?? '').startsWith('http')
          ? json['url'].toString()
          : 'https://example.com/default.png',
      price: (json['price'] is num)
          ? (json['price'] as num).toDouble()
          : double.tryParse(json['price']?.toString() ?? '') ?? 0.0,
      reviews: int.tryParse(json['reviews']?.toString() ?? '') ?? 0,
      specifications: (json['specifications'] is List)
          ? List<String>.from(
          (json['specifications'] as List)
              .where((item) => item != null)
              .map((item) => item.toString()))
          : [],
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'title': title.toString().trim().isEmpty ? '' : title,
      'url': url.startsWith('http') ? url : 'https://example.com/default.png',
      'price': double.tryParse(price.toString()) ?? 0.0,
      'reviews': reviews.clamp(0, double.infinity),
      'specifications': List<String>.from(
          specifications.map((item) => item.toString())),
    };
  }

  @override
  String toString() {
    return 'Product(title: $title, url: $url, price: $price, reviews: $reviews, specifications: $specifications)';
  }
}