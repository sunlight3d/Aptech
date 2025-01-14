part of 'bloc.dart';

/// Xác định các trạng thái khi login
enum LoginStatus { initial, inProgress, success, failure }

final class LoginState extends Equatable {
  const LoginState({
    this.status = LoginStatus.initial,
    this.emailOrPhone = '',
    this.password = '',
  });

  /// Trạng thái đăng nhập
  final LoginStatus status;

  /// Người dùng có thể nhập email hoặc phone
  final String emailOrPhone;

  /// Mật khẩu
  final String password;

  LoginState copyWith({
    LoginStatus? status,
    String? emailOrPhone,
    String? password,
  }) {
    return LoginState(
      status: status ?? this.status,
      emailOrPhone: emailOrPhone ?? this.emailOrPhone,
      password: password ?? this.password,
    );
  }

  @override
  List<Object> get props => [status, emailOrPhone, password];
}
