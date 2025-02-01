class CartCheckoutRequest {
  final int cartId;
  final String phone;
  final String address;
  final String? note;

  CartCheckoutRequest({
    required this.cartId,
    required this.phone,
    required this.address,
    this.note,
  }) {
    // Kiểm tra hợp lệ ngay trong constructor
    if (cartId <= 0 || phone.isEmpty || address.isEmpty) {
      throw ArgumentError("Thiếu thông tin bắt buộc: cartId, phone hoặc address không hợp lệ.");
    }
  }

  // Chuyển đổi sang Map để gửi API
  Map<String, dynamic> toJson() {
    return {
      'cart_id': cartId,
      'phone': phone,
      'address': address,
      if (note != null) 'note': note,
    };
  }
}
