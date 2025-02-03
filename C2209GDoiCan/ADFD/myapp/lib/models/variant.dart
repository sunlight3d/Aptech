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
      id: json['id'] != null ? json['id'] as int : 0, // Giá trị mặc định là 0 nếu id null
      name: json['name'] != null ? json['name'] as String : '', // Giá trị mặc định là chuỗi rỗng nếu name null
      value: json['value'] != null ? json['value'] as String : '', // Giá trị mặc định là chuỗi rỗng nếu value null
      image: json['image'] != null ? json['image'] as String : '', // Giá trị mặc định là chuỗi rỗng nếu image null
    );
  }
}
