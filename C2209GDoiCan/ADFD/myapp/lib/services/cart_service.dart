import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:myapp/dtos/requests/cart.dart';
import 'package:myapp/dtos/requests/cart_checkout.dart';
import 'package:myapp/dtos/requests/cart_item_create.dart';
import 'package:myapp/dtos/responses/cart.dart';
import 'package:myapp/dtos/responses/cart_checkout.dart';
import 'package:myapp/dtos/responses/cart_item_create.dart';
import 'package:myapp/models/cart_item.dart';
import 'base_service.dart';

class CartService extends BaseService {


  /// 🔹 **Gọi API tạo giỏ hàng**
  Future<CartResponse> createCart({
    required CartRequest request,
    String? token,
  }) async {
    final response = await this.request(
      endpoint: 'carts',
      method: HttpMethod.POST,
      requestData: request.toJson(),
      token: request.userId != null ? token : null, // Nếu có user_id thì truyền token
    );

    // Chuyển đổi response thành đối tượng CartResponse
    return CartResponse.fromJson(response.data);
  }

  /// 🔹 **Gọi API thanh toán giỏ hàng**
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
    return CartCheckoutResponse.fromJson(response.data);
  }

  /// 🔹 **Gọi API xoá giỏ hàng**
  Future<ApiResponse> deleteCart({
    required int id,
    String? token,
  }) async {
    final response = await request(
      endpoint: 'carts/$id',
      method: HttpMethod.DELETE,
      token: token,
    );
    return response;
  }
}
