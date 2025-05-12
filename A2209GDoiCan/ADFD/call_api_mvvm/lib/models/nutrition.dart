class Nutrition {
  final double calories;
  final double fat;
  final double sugar;
  final double carbohydrates;
  final double protein;

  Nutrition({
    required this.calories,
    required this.fat,
    required this.sugar,
    required this.carbohydrates,
    required this.protein,
  });

  factory Nutrition.fromJson(Map<String, dynamic> json) {
    return Nutrition(
      calories: json['calories'].toDouble(),
      fat: json['fat'].toDouble(),
      sugar: json['sugar'].toDouble(),
      carbohydrates: json['carbohydrates'].toDouble(),
      protein: json['protein'].toDouble(),
    );
  }

  Map<String, dynamic> toJson() {
    return {
      'calories': calories,
      'fat': fat,
      'sugar': sugar,
      'carbohydrates': carbohydrates,
      'protein': protein,
    };
  }
}