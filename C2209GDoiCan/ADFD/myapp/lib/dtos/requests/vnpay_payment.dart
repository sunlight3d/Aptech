import 'dart:async';
import 'dart:convert';
import 'package:flutter/services.dart';
import 'package:myapp/services/base_service.dart';

/// 📌 Lớp Request để gửi API tạo thanh toán VNPAY
class VNPAYPaymentRequest {
  final double amount;
  final String bankCode;
  final String language;

  VNPAYPaymentRequest({
    required this.amount,
    required this.bankCode,
    required this.language,
  });

  Map<String, dynamic> toJson() {
    return {
      'amount': amount.toInt(), // Định dạng số nguyên
      'bankCode': bankCode,
      'language': language,
    };
  }
}
