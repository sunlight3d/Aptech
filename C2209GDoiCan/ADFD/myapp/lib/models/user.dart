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
      id: json['id'] as int,
      email: json['email'] as String,
      name: json['name'] as String,
      role: json['role'] as int,
      avatar: json['avatar'] as String?,
      phone: json['phone'] as String?,
    );
  }

  /// A static property to represent an empty auth instance.
  static const User empty = User(
    id: 0,
    email: '',
    name: '',
    role: 0,
    avatar: null,
    phone: null,
  );

  @override
  List<Object?> get props => [id, email, phone];
}

