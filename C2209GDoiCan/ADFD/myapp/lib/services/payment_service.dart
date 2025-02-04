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

class PaymentService extends BaseService {
  static const MethodChannel _channel = MethodChannel('vnpay_payment');

  PaymentService({super.baseURL});

  /// 📌 Gọi API tạo payment URL từ server
  Future<String> createVNPAYPayment(VNPAYPaymentRequest requestData) async {
    try {
      final response = await super.request(  // Sử dụng super để gọi hàm từ BaseService
        endpoint: "payments/create_payment_url",
        method: HttpMethod.POST,
        requestData: requestData.toJson(),
      );

      if (response.data != null && response.data["payment_url"] != null) {
        return response.data["payment_url"];
      } else {
        throw Exception("Không lấy được URL thanh toán VNPAY");
      }
    } catch (e) {
      throw Exception("Lỗi khi tạo payment URL: $e");
    }
  }

  /// 📌 Mở VNPAY Payment trên Android bằng MethodChannel
  Future<void> startVNPAY(String paymentUrl) async {
    try {
      final String result = await _channel.invokeMethod('startVNPAYPayment', {
        'paymentUrl': paymentUrl,
      });
      print("✅ VNPAY Response: $result");
    } on PlatformException catch (e) {
      print("❌ Failed to start VNPAY: '${e.message}'.");
      throw Exception("Lỗi khi khởi động VNPAY: ${e.message}");
    }
  }
}