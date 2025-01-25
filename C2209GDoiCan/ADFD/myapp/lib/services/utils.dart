import 'package:intl/intl.dart';

String formatCurrency(double amount) {
  final format = NumberFormat.currency(
    locale: 'vi_VN', // Định dạng tiền tệ Việt Nam
    symbol: 'đ', // Ký hiệu tiền tệ
    decimalDigits: 0, // Số chữ số thập phân
  );
  return format.format(amount);
}