/// Lớp biểu diễn các biến thể (variants) của sản phẩm
class Variant {
  final int id;
  final String name;
  final String value;
  final String image;

  Variant({
    required this.id,
    required this.name,
    required this.value,
    required this.image,
  });

  factory Variant.fromJson(Map<String, dynamic> json) {
    return Variant(
      id: json['id'] as int,
      name: json['name'] as String,
      value: json['value'] as String,
      image: json['image'] as String,
    );
  }
}