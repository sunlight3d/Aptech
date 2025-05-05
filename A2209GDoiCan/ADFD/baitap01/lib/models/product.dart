class Product {
  String code;
  String colorHex;
  String name;
  double price;
  Product({required this.code, required this.colorHex, required this.name, required this.price});
  Map<String, dynamic> toJson() {
    return {
      'code': code,
      'color_hex': colorHex,
      'name': name,
      'price': price ?? 0.0
    };
  }
  factory Product.fromJson(Map<String, dynamic> map) {
    return Product(code: map['code'] as String,
        colorHex: map['color_hex'] as String,
        name: map['name'],
        price: map['price']
    );
  }
}