import 'package:intl/intl.dart';
import 'package:flutter/material.dart';
import 'package:awesome_snackbar_content/awesome_snackbar_content.dart';


String formatCurrency(double amount) {
  final format = NumberFormat.currency(
    locale: 'vi_VN', // Định dạng tiền tệ Việt Nam
    symbol: 'đ', // Ký hiệu tiền tệ
    decimalDigits: 0, // Số chữ số thập phân
  );
  return format.format(amount);
}

void alert(BuildContext context, String message, ContentType type) {
  final snackBar = SnackBar(
    elevation: 2,
    behavior: SnackBarBehavior.floating,
    backgroundColor: Colors.transparent,
    content: AwesomeSnackbarContent(
      title: type == ContentType.success
          ? "Thành công"
          : type == ContentType.warning
          ? "Cảnh báo"
          : type == ContentType.failure
          ? "Lỗi"
          : "Thông tin",
      message: message,
      contentType: type,
    ),
  );

  ScaffoldMessenger.of(context).showSnackBar(snackBar);
}
