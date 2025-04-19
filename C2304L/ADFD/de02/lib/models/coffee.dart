class Coffee {
  int id = 0;
  String title = '';
  double price = 0.0;
  String image = '';
  String description = '';
  List<String> ingredients = [];
  int totalSales = 0;
  Coffee({required this.id,
    required this.title,
    required this.price,
    required this.description,
    required this.image,
    required this.totalSales,
    required this.ingredients
  });
  // Factory method to create a Coffee instance from JSON
  factory Coffee.fromJson(Map<String, dynamic> json) {
    print('haha');
    if(json['title'].toString().toLowerCase().contains('nitro')) {
      print('haha');
    }
    return Coffee(
      id: json['id'] ?? 0,
      title: json['title'] ?? '',
      price: (json['price'] ?? 0.0).toDouble(),
      description: json['description'] ?? '',
      image: json['image'] ?? '',
      totalSales: json['totalSales'] ?? 0,
      ingredients: List<String>.from(json['ingredients'] ?? []),
    );
  }

  // Method to convert Coffee instance to JSON
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'title': title,
      'price': price,
      'description': description,
      'image': image,
      'totalSales': totalSales,
      'ingredients': ingredients,
    };
  }

  /*
  "id": 1,
"title": "Black Coffee",
"price": 1.5,
"description": "A simple, bold brew made without milk or sugar. It’s rich, aromatic, and perfect for those who enjoy a pure coffee flavor.",
"image": "https://images.unsplash.com/photo-1494314671902-399b18174975?auto=format&fit=crop&q=80&w=1887&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
"ingredients": ["x", "y"],
"totalSales": 111
  * */
}