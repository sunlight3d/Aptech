class CartCheckoutResponse {
  final int id;
  final int userId;
  final String? sessionId;
  final int paymentStatus;
  final int status;
  final double total;
  final String address;
  final String phone;
  final String note;
  final DateTime createdAt;
  final DateTime updatedAt;

  CartCheckoutResponse({
    required this.id,
    required this.userId,
    this.sessionId,
    required this.paymentStatus,
    required this.status,
    required this.total,
    required this.address,
    required this.phone,
    required this.note,
    required this.createdAt,
    required this.updatedAt,
  });

  factory CartCheckoutResponse.fromJson(Map<String, dynamic> json) {
    return CartCheckoutResponse(
      id: json['id'] as int,
      userId: json['user_id'] as int,
      sessionId: json['session_id'] as String?,
      paymentStatus: json['payment_status'] as int,
      status: json['status'] as int,
      total: (json['total'] as num).toDouble(),
      address: json['address'] as String,
      phone: json['phone'] as String,
      note: json['note'] as String,
      createdAt: DateTime.parse(json['created_at']),
      updatedAt: DateTime.parse(json['updated_at']),
    );
  }
}
