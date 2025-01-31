import 'dart:convert';
import 'dart:async';
import 'package:firebase_auth/firebase_auth.dart' as firebase_auth;
import 'package:google_sign_in/google_sign_in.dart';
import 'package:myapp/models/user.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
import 'base_service.dart';

enum AuthenticationStatus { unknown, authenticated, unauthenticated }

class AuthService extends BaseService {
  final LocalStorageRepository localStorageRepository;

  AuthService({
    required super.baseURL,
    required super.httpClient,
    required this.localStorageRepository,
  });

  final _controller = StreamController<AuthenticationStatus>();

  Stream<AuthenticationStatus> get status async* {
    yield AuthenticationStatus.unknown;
    yield* _controller.stream;
  }

  /// 🔹 **Đăng nhập thường**
  Future<void> logIn({
    required String email,
    required String password,
  }) async {
    final response = await request(
      endpoint: 'users/login',
      method: HttpMethod.POST,
      requestData: {'email': email, 'password': password},
    );

    final userData = User.fromJson(response.data['user']);
    final token = response.data['token'] as String;

    await localStorageRepository.saveToken(token);
    await localStorageRepository.saveUserId(userData.id);
    _controller.add(AuthenticationStatus.authenticated);
  }

  /// 🔹 **Đăng nhập bằng Google**
  Future<void> signInWithGoogle() async {
    try {
      final GoogleSignInAccount? googleUser = await GoogleSignIn().signIn();
      if (googleUser == null) return;

      final GoogleSignInAuthentication googleAuth = await googleUser.authentication;
      final firebase_auth.OAuthCredential credential = firebase_auth.GoogleAuthProvider.credential(
        accessToken: googleAuth.accessToken,
        idToken: googleAuth.idToken,
      );

      final firebase_auth.UserCredential userCredential =
      await firebase_auth.FirebaseAuth.instance.signInWithCredential(credential);

      if (userCredential.user != null) {
        final firebase_auth.User firebaseUser = userCredential.user!;

        final Map<String, dynamic> userData = {
          "email": firebaseUser.email ?? "",
          "display_name": firebaseUser.displayName ?? "",
          "photo_url": firebaseUser.photoURL ?? "",
          "google_id": firebaseUser.uid,
          "phone_number": firebaseUser.phoneNumber ?? "",
        };

        final response = await request(
          endpoint: 'users/google/login',
          method: HttpMethod.POST,
          requestData: userData,
        );

        final user = User.fromJson(response.data['user']);
        final token = response.data['token'] as String;

        await localStorageRepository.saveToken(token);
        await localStorageRepository.saveUserId(user.id);
        _controller.add(AuthenticationStatus.authenticated);
      }
    } catch (e) {
      _controller.add(AuthenticationStatus.unauthenticated);
      throw Exception('Google sign-in failed: $e');
    }
  }

  /// 🔹 **Lấy thông tin người dùng**
  Future<User> getUserInfo({required int userId, required String token}) async {
    final response = await request(
      endpoint: 'users/me/$userId',
      method: HttpMethod.GET,
      token: token,
    );

    return User.fromJson(response.data);
  }

  /// 🔹 **Đăng xuất**
  void logOut() {
    localStorageRepository.clearAll();
    _controller.add(AuthenticationStatus.unauthenticated);
  }

  /// 🔹 **Đóng StreamController để tránh rò rỉ bộ nhớ**
  void dispose() => _controller.close();
}
