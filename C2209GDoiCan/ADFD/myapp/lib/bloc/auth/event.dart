part of './bloc.dart';

sealed class AuthenticationEvent {
  const AuthenticationEvent();
}

final class AuthenticationRequested extends AuthenticationEvent {
  // Sự kiện được kích hoạt khi cần kiểm tra trạng thái xác thực
}

final class LogoutRequested extends AuthenticationEvent {
  // Sự kiện được kích hoạt khi người dùng nhấn vào nút đăng xuất
}
