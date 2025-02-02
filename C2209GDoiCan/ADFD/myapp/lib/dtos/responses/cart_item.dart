import 'package:myapp/models/cart_item.dart';

/// Lớp chứa thông tin kết quả trả về của API lấy danh sách cart items
class CartItemsResponse {
  final String message;
  final List<CartItem> data;
  final int currentPage;
  final int totalPages;
  final int total;

  CartItemsResponse({
    required this.message,
    required this.data,
    required this.currentPage,
    required this.totalPages,
    required this.total,
  });

  factory CartItemsResponse.fromJson(Map<String, dynamic> json) {
    return CartItemsResponse(
      message: json['message'] as String,
      data: (json['data'] as List)
          .map((item) => CartItem.fromJson(item))
          .toList(),
      currentPage: json['currentPage'] as int,
      totalPages: json['totalPages'] as int,
      total: json['total'] as int,
    );
  }
}