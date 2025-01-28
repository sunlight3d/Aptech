part of 'bloc.dart';

sealed class LoginEvent extends Equatable {
  const LoginEvent();

  @override
  List<Object> get props => [];
}

/// Người dùng thay đổi ô nhập email/phone
final class LoginEmailOrPhoneChanged extends LoginEvent {
  const LoginEmailOrPhoneChanged(this.emailOrPhone);

  final String emailOrPhone;

  @override
  List<Object> get props => [emailOrPhone];
}

/// Người dùng thay đổi ô nhập password
final class LoginPasswordChanged extends LoginEvent {
  const LoginPasswordChanged(this.password);

  final String password;

  @override
  List<Object> get props => [password];
}

/// Người dùng nhấn nút "Đăng nhập"
final class LoginSubmitted extends LoginEvent {
  const LoginSubmitted();
}
/// Người dùng nhấn đăng nhập bằng Google
final class LoginWithGoogleRequested extends LoginEvent {
  const LoginWithGoogleRequested();
}