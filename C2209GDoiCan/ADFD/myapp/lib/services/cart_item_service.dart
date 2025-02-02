import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:myapp/dtos/requests/cart_item_create.dart';
import 'package:myapp/dtos/responses/cart_item.dart';
import 'package:myapp/dtos/responses/cart_item_create.dart';
import 'package:myapp/models/cart_item.dart';
import 'package:myapp/models/product.dart';
import 'package:myapp/models/product_variant_value.dart';
import 'base_service.dart';

/// Service gọi API liên quan đến cart items
class CartItemService extends BaseService {
  CartItemService() : super();

  /// 🔹 **Gọi API lấy danh sách mục trong giỏ hàng**
  /// - [cartId]: ID của giỏ hàng cần lấy danh sách mục
  /// - [token]: Token người dùng (nếu đã đăng nhập)
  Future<CartItemsResponse> getCartItems({
    required int cartId,
    String? token,
  }) async {
    final response = await request(
      endpoint: 'cart-items',
      method: HttpMethod.GET,
      // Truyền tham số query, BaseService sẽ chuyển đổi các tham số này thành chuỗi query
      requestData: {'cart_id': cartId.toString()},
      token: token,
    );

    // Parse dữ liệu trả về thành đối tượng CartItemsResponse
    return CartItemsResponse.fromJson(response.data);
  }
  /// 🔹 **Gọi API thêm mới 1 mục (item) vào giỏ hàng**
  Future<CartItemCreateResponse> createCartItem({
    required CartItemCreateRequest requestData,
    String? token,
  }) async {
    final response = await request(
      endpoint: 'cart-items',
      method: HttpMethod.POST,
      requestData: requestData.toJson(),
      token: token,
    );
    return CartItemCreateResponse.fromJson(response.data);
  }

  /// 🔹 **Gọi API xoá 1 mục (item) trong giỏ hàng**
  Future<CartItem> deleteCartItem({
    required int id,
    String? token,
  }) async {
    final response = await request(
      endpoint: 'cart-items/$id',
      method: HttpMethod.DELETE,
      token: token,
    );
    return CartItem.fromJson(response.data);
  }
}
