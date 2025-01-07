// ProductAttribute class
import 'package:equatable/equatable.dart';
class ProductAttribute extends Equatable {
  final int id;
  final String name;
  final String value;

  const ProductAttribute({
    required this.id,
    required this.name,
    required this.value,
  });

  // Parse from JSON
  factory ProductAttribute.fromJson(Map<String, dynamic> json) {
    return ProductAttribute(
      id: json['id'],
      name: json['name'],
      value: json['value'],
    );
  }

  // Convert to JSON
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'value': value,
    };
  }

  @override
  List<Object?> get props => [id, name, value];
}
