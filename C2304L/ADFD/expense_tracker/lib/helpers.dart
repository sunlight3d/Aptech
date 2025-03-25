import 'package:intl/intl.dart';
String formatDate(DateTime input) {
  final DateFormat formatter = DateFormat('yyyy-MM-dd');
  return formatter.format(input);
}