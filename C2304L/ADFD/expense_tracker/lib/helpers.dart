import 'package:intl/intl.dart';
String formatDate(DateTime input) {
  //final DateFormat formatter = DateFormat('yyyy-MM-dd');
  final DateFormat formatter = DateFormat('dd-MM-yyyy');
  return formatter.format(input);
}