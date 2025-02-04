import 'package:flutter/services.dart';
import 'package:myapp/dtos/requests/vnpay_payment.dart';
import 'package:myapp/services/base_service.dart';

class PaymentService extends BaseService {
  static const MethodChannel _channel = MethodChannel('vnpay_payment');

  PaymentService({super.baseURL});
  /// Gọi VNPAY SDK trên Android qua MethodChannel
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