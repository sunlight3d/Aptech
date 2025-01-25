import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:myapp/models/user.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
import 'base_service.dart';
import 'dart:async';


enum AuthenticationStatus { unknown, authenticated, unauthenticated }

class AuthService extends BaseService {
  AuthService({
    required String baseURL,
    required http.Client httpClient,
    required this.localStorageRepository,
  }) : super(baseURL: baseURL, httpClient: httpClient);

  /// Repository dùng để lưu dữ liệu cục bộ (token, userId...)
  final LocalStorageRepository localStorageRepository;

  /// Dòng trạng thái xác thực (kế thừa ý tưởng từ AuthenticationRepository)
  final _controller = StreamController<AuthenticationStatus>();

  /// Stream cho phép các Bloc/Provider lắng nghe trạng thái xác thực
  Stream<AuthenticationStatus> get status async* {
    // Tuỳ nhu cầu, ta có thể gọi API/kiểm tra token
    // tạm thời yield ra unknown, sau đó yield* _controller.stream
    yield AuthenticationStatus.unknown;
    yield* _controller.stream;
  }

  /// Hàm đăng nhập gọi API thật
  /// (Thay thế Future.delayed bằng việc gọi API ở login)
  Future<void> logIn({
    required String email,
    required String password,
  }) async {
    final url = Uri.parse('$baseURL/users/login');
    final response = await httpClient.post(
      url,
      headers: {'Content-Type': 'application/json'},
      body: json.encode({'email': email, 'password': password}),
    );

    if (response.statusCode == 200) {
      final body = json.decode(response.body) as Map<String, dynamic>;
      final userData = User.fromJson(body['data']['user']);
      final token = body['data']['token'] as String;

      // Lưu token và userId
      await localStorageRepository.saveToken(token);
      await localStorageRepository.saveUserId(userData.id);

      // Đăng nhập thành công => authenticated
      _controller.add(AuthenticationStatus.authenticated);
    } else {
      // Đăng nhập thất bại => unauthenticated
      _controller.add(AuthenticationStatus.unauthenticated);
      throw Exception('Failed to log in: ${response.body}');
    }
  }

  /// Đăng xuất => trạng thái unauthenticated
  void logOut() {
    // Có thể xoá token và userId nếu cần
    localStorageRepository.clearAll();
    _controller.add(AuthenticationStatus.unauthenticated);
  }

  /// Lấy thông tin người dùng sau khi đã có token và userId
  Future<User> getUserInfo({
    required int userId,
    required String token,
  }) async {
    final url = Uri.parse('$baseURL/users/me/$userId');
    final response = await httpClient.get(
      url,
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer $token',
      },
    );

    if (response.statusCode == 200) {
      final body = json.decode(response.body) as Map<String, dynamic>;
      final userMap = body['data'] as Map<String, dynamic>;
      return User.fromJson(userMap);
    }

    throw Exception('Failed to fetch auth info: ${response.body}');
  }

  /// Đóng StreamController để tránh rò rỉ bộ nhớ
  void dispose() => _controller.close();
}


