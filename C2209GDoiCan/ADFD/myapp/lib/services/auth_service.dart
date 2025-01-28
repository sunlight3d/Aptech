import 'dart:convert';
// Thêm alias 'firebase_auth' cho Firebase Auth
import 'package:firebase_auth/firebase_auth.dart' as firebase_auth;
// Thêm alias 'myapp_user' cho User của ứng dụng
import 'package:google_sign_in/google_sign_in.dart';
import 'package:http/http.dart' as http;
import 'package:myapp/models/user.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
import 'base_service.dart';
import 'dart:async';


enum AuthenticationStatus { unknown, authenticated, unauthenticated }

class AuthService extends BaseService {
  AuthService({
    required super.baseURL,
    required super.httpClient,
    required this.localStorageRepository,
  });

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
  /// Đăng nhập bằng Google
  Future<void> signInWithGoogle() async {
    try {
      // Bước 1: Đăng nhập bằng Google
      final GoogleSignInAccount? googleUser = await GoogleSignIn().signIn();
      if (googleUser == null) return;

      // Bước 2: Lấy thông tin xác thực
      final GoogleSignInAuthentication googleAuth =
      await googleUser.authentication;

      // Bước 3: Tạo Firebase credential
      final firebase_auth.OAuthCredential credential = firebase_auth.GoogleAuthProvider.credential(
        accessToken: googleAuth.accessToken,
        idToken: googleAuth.idToken,
      );

      // Bước 4: Đăng nhập vào Firebase
      final firebase_auth.UserCredential userCredential =
      await firebase_auth.FirebaseAuth.instance.signInWithCredential(credential);

      // Bước 5: Lưu thông tin người dùng và token
      final token = await userCredential.user!.getIdToken();
      if (userCredential.user != null) {
        // Sử dụng firebase_auth.User
        final firebase_auth.User firebaseUser = userCredential.user!;

        // Lưu thông tin người dùng của ứng dụng (nếu cần)
        final User appUser = User(
          id: firebaseUser.uid.hashCode,
          email: firebaseUser.email ?? "",
          name: firebaseUser.displayName ?? "",
          role: 0, // Tuỳ chỉnh theo logic ứng dụng
        );
        // Lưu token và userId
        //await localStorageRepository.saveToken(token!);
        await localStorageRepository.saveUserId(appUser.id);

        // Cập nhật trạng thái xác thực
        _controller.add(AuthenticationStatus.authenticated);
      }
    } catch (e) {
      _controller.add(AuthenticationStatus.unauthenticated);
      throw Exception('Google sign-in failed: $e');
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


