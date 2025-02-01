class CartRequest {
  final int? userId;
  final String? sessionId;

  CartRequest({this.userId, this.sessionId}) {
    // Kiểm tra hợp lệ ngay trong constructor
    if ((userId == null && sessionId == null) || (userId != null && sessionId != null)) {
      throw ArgumentError("Phải có một trong hai user_id hoặc session_id, nhưng không được cả hai.");
    }
  }

  // Chuyển đổi sang Map để gửi API
  Map<String, dynamic> toJson() {
    return {
      if (userId != null) 'user_id': userId,
      if (sessionId != null) 'session_id': sessionId,
    };
  }
}
