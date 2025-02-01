import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:myapp/dtos/responses/cart.dart';
import 'package:myapp/dtos/responses/cart_checkout.dart';
import 'base_service.dart';

class CartService extends BaseService {
  CartService({required super.baseURL, required super.httpClient});

  /// 🔹 **Gọi API tạo giỏ hàng**
  Future<CartResponse> createCart({int? userId, String? sessionId, String? token}) async {
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
      token: userId != null ? token : null, // Nếu có user_id thì truyền token
    );

    // Chuyển đổi response thành đối tượng CartResponse
    return CartResponse.fromJson(response.data);
  }

  Future<CartCheckoutResponse> checkoutCart({
    required int cartId,
    required String phone,
    required String address,
    String? note,
    String? token, // Nếu có user đăng nhập thì truyền token
  }) async {
    if (cartId <= 0 || phone.isEmpty || address.isEmpty) {
      throw ArgumentError("Thiếu thông tin bắt buộc: cartId, phone hoặc address không hợp lệ.");
    }

    final response = await request(
      endpoint: 'carts/checkout',
      method: HttpMethod.POST,
      requestData: {
        'cart_id': cartId,
        'phone': phone,
        'address': address,
        if (note != null) 'note': note,
      },
      token: token,
    );

    // Chuyển đổi response thành đối tượng CartCheckoutResponse
    return CartCheckoutResponse.fromJson(response.data);
  }

}
