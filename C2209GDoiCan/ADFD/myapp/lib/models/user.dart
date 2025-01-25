import 'package:equatable/equatable.dart';

class User extends Equatable {
  final int id;
  final String email;
  final String name;
  final int role;
  final String? avatar;
  final String? phone;

  const User({
    required this.id,
    required this.email,
    required this.name,
    required this.role,
    this.avatar,
    this.phone,
  });

  factory User.fromJson(Map<String, dynamic> json) {
    return User(
      id: json['id'] as int? ?? 0, // Nếu json['id'] là null, gán giá trị 0
      email: json['email'] as String? ?? "", // Nếu json['email'] là null, gán giá trị ""
      name: json['name'] as String? ?? "", // Nếu json['name'] là null, gán giá trị ""
      role: json['role'] as int? ?? 0, // Nếu json['role'] là null, gán giá trị 0
      avatar: json['avatar'] as String? ?? "", // Nếu json['avatar'] là null, gán giá trị ""
      phone: json['phone'] as String? ?? "", // Nếu json['phone'] là null, gán giá trị ""
    );
  }

  /// A static property to represent an empty auth instance.
  static const User empty = User(
    id: 0,
    email: '',
    name: '',
    role: 0,
    avatar: '',
    phone: '',
  );

  @override
  List<Object?> get props => [id, email, phone];
}

