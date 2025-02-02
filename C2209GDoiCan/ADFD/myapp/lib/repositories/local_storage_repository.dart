import 'dart:math';

import 'package:shared_preferences/shared_preferences.dart';

class LocalStorageRepository {
  const LocalStorageRepository();

  /// Lưu token
  Future<void> saveToken(String token) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString('token', token);
  }

  /// Lưu userId
  Future<void> saveUserId(int userId) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setInt('userId', userId);
  }

  /// Lưu cartId
  Future<void> saveCartId(int cartId) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setInt('cartId', cartId);
  }

  /// Lấy token đã lưu
  Future<String?> getToken() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getString('token');
  }

  /// Lấy userId đã lưu
  Future<int?> getUserId() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getInt('userId');
  }

  /// Lấy cartId đã lưu
  Future<int?> getCartId() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getInt('cartId');
  }

  /// Xoá dữ liệu khi đăng xuất
  Future<void> clearAll() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.remove('token');
    await prefs.remove('userId');
    await prefs.remove('cartId');
  }
  /// Lấy sessionId đã lưu
  Future<String?> getSessionId() async {
    final prefs = await SharedPreferences.getInstance();
    return prefs.getString('sessionId');
  }

  /// Lưu sessionId
  Future<void> saveSessionId(String sessionId) async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.setString('sessionId', sessionId);
  }
  /// Tạo một session id ngẫu nhiên
  /// Mặc định trả về chuỗi 32 ký tự gồm chữ cái (in hoa, in thường) và số.
  String generateSessionId({int length = 32}) {
    const chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    final random = Random.secure();
    return List.generate(length, (_) => chars[random.nextInt(chars.length)]).join();
  }
}
