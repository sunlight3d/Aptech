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

void alert(BuildContext context, String message, ContentType type, {VoidCallback? onConfirm}) {
  if (type == ContentType.warning || type == ContentType.failure) {
    // Hiển thị hộp thoại xác nhận nếu là lỗi hoặc cảnh báo
    showDialog(
      context: context,
      builder: (context) => AlertDialog(
        title: Text(
          type == ContentType.warning ? "Cảnh báo" : "Lỗi",
          style: TextStyle(
            fontSize: 18,
            fontWeight: FontWeight.bold,
            color: type == ContentType.warning ? Colors.orange : Colors.red,
          ),
        ),
        content: Text(message),
        actions: [
          TextButton(
            onPressed: () => Navigator.of(context).pop(), // Đóng hộp thoại
            child: const Text("Hủy", style: TextStyle(color: Colors.grey)),
          ),
          TextButton(
            onPressed: () {
              Navigator.of(context).pop(); // Đóng hộp thoại trước
              if (onConfirm != null) {
                onConfirm(); // Gọi callback khi xác nhận
              }
            },
            child: Text(
              "Xác nhận",
              style: TextStyle(color: type == ContentType.warning ? Colors.orange : Colors.red),
            ),
          ),
        ],
      ),
    );
  } else {
    // Hiển thị SnackBar nếu là thông tin hoặc thành công
    final snackBar = SnackBar(
      elevation: 2,
      behavior: SnackBarBehavior.floating,
      backgroundColor: Colors.transparent,
      content: AwesomeSnackbarContent(
        title: type == ContentType.success
            ? "Thành công"
            : "Thông tin",
        message: message,
        contentType: type,
      ),
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }
}

