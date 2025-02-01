class CartResponse {
  final int id;
  final String? sessionId;
  final int? userId;
  final DateTime createdAt;
  final DateTime updatedAt;

  CartResponse({
    required this.id,
    this.sessionId,
    this.userId,
    required this.createdAt,
    required this.updatedAt,
  });

  factory CartResponse.fromJson(Map<String, dynamic> json) {
    return CartResponse(
      id: json['id'] as int,
      sessionId: json['session_id'] as String?,
      userId: json['user_id'] as int?,
      createdAt: DateTime.parse(json['created_at']),
      updatedAt: DateTime.parse(json['updated_at']),
    );
  }
}
