import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'base_service.dart';

class CartService extends BaseService {
  CartService({required super.baseURL, required super.httpClient});

  /// 🔹 **Gọi API tạo giỏ hàng**
  Future<ApiResponse> createCart({int? userId, String? sessionId}) async {
    if ((userId == null && sessionId == null) || (userId != null && sessionId != null)) {
      throw ArgumentError("Phải có một trong hai user_id hoặc session_id, nhưng không được cả hai.");
    }

    final response = await request(
      endpoint: 'carts',
      method: HttpMethod.POST,
      requestData: {
        if (userId != null) 'user_id': userId,
        if (sessionId != null) 'session_id': sessionId,
      },
    );

    return response;
  }
}
