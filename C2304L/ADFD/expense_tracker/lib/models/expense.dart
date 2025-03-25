class Expense {
  final String name;
  final double price;
  final DateTime date;
  Expense({
    required this.name,
    this.price = 0,
    required this.date});
}