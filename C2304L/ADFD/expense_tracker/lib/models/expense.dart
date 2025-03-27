class Expense {
  final String id;
  String title;
  double price;
  DateTime date;
  Expense({
    required this.id,
    required this.title,
    this.price = 0,
    required this.date});
}