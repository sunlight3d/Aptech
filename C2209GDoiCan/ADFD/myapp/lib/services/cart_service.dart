import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:myapp/dtos/requests/cart.dart';
import 'package:myapp/dtos/requests/cart_checkout.dart';
import 'package:myapp/dtos/responses/cart.dart';
import 'package:myapp/dtos/responses/cart_checkout.dart';
import 'base_service.dart';

class CartService extends BaseService {
  CartService({required super.baseURL, required super.httpClient});

  /// 🔹 **Gọi API tạo giỏ hàng**
  Future<CartResponse> createCart({required CartRequest request, String? token}) async {
    final response = await this.request(
      endpoint: 'carts',
      method: HttpMethod.POST,
      requestData: request.toJson(),
      token: request.userId != null ? token : null, // Nếu có user_id thì truyền token
    );

    // Chuyển đổi response thành đối tượng CartResponse
    return CartResponse.fromJson(response.data);
  }


  Future<CartCheckoutResponse> checkoutCart({
    required CartCheckoutRequest request,
    String? token, // Nếu có user đăng nhập thì truyền token
  }) async {
    final response = await this.request(
      endpoint: 'carts/checkout',
      method: HttpMethod.POST,
      requestData: request.toJson(),
      token: token,
    );

    // Chuyển đổi response thành đối tượng CartCheckoutResponse
    return CartCheckoutResponse.fromJson(response.data);
  }


}
