import 'dart:convert';
import 'package:http/http.dart' as http;
import '../models/user.dart'; // Import model User
import 'base_service.dart';

class UserService extends BaseService {
  const UserService({required super.baseURL, required super.httpClient});

  /// Hàm lấy thông tin chi tiết người dùng
  Future<User> fetchUserDetail(int userId, String token) async {
    final response = await httpClient.post(
      Uri.parse('$baseURL/users/me/$userId'),
      headers: {
        'Authorization': 'Bearer $token', // Truyền Bearer Token vào header
        'Content-Type': 'application/json',
      },
    );

    if (response.statusCode == 200) {
      final body = json.decode(response.body) as Map<String, dynamic>;
      final userData = body['data'] as Map<String, dynamic>;
      return User.fromJson(userData);
    }

    throw Exception('Failed to fetch user details: ${response.statusCode}');
  }
}