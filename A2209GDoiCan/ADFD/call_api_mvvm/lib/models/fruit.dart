import 'nutrition.dart';

class Fruit {
  final String name;
  final int id;
  final String family;
  final String order;
  final String genus;
  final Nutrition nutritions;

  Fruit({
    required this.name,
    required this.id,
    required this.family,
    required this.order,
    required this.genus,
    required this.nutritions,
  });

  factory Fruit.fromJson(Map<String, dynamic> json) {
    return Fruit(
      name: json['name'],
      id: json['id'],
      family: json['family'],
      order: json['order'],
      genus: json['genus'],
      nutritions: Nutrition.fromJson(json['nutritions']),
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'name': name,
      'id': id,
      'family': family,
      'order': order,
      'genus': genus,
      'nutritions': nutritions.toJson(),
    };
  }
}
