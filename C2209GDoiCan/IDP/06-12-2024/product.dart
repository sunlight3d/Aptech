class Product {
  final String name;
  final double price;
  final int quantity;
  String? description;
  Product({required this.name, required this.price, required this.quantity});
  @override
  String toString() {
    return 'name: ${name}, ' +
        'price = ${price}' +
        'quantity = ${quantity}, ' +
        'description = ${description}';
  }
}
