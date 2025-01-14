import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:myapp/models/user.dart';
import 'base_service.dart';

enum AuthenticationStatus { unknown, authenticated, unauthenticated }
class AuthService extends BaseService {
  const AuthService({required String baseURL, required http.Client httpClient})
      : super(baseURL: baseURL, httpClient: httpClient);

  Future<Map<String, dynamic>> login({required String email, required String password}) async {
    final url = Uri.parse('$baseURL/users/login');
    final response = await httpClient.post(
      url,
      headers: {
        'Content-Type': 'application/json',
      },
      body: json.encode({
        'email': email,
        'password': password,
      }),
    );

    if (response.statusCode == 200) {
      final body = json.decode(response.body) as Map<String, dynamic>;
      return {
        'message': body['message'],
        'user': User.fromJson(body['data']['user']),
        'token': body['data']['token'],
      };
    }

    throw Exception('Failed to log in: ${response.body}');
  }
}
