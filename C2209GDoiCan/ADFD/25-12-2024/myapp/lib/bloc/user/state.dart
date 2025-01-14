part of './bloc.dart';

class AuthenticationState extends Equatable {
  const AuthenticationState._({
    required this.status,
    required this.user,
  });

  /// Trạng thái ban đầu, chưa xác định trạng thái xác thực.
  const AuthenticationState.unknown()
      : this._(
    status: AuthenticationStatus.unknown,
    user: User.empty,
  );

  /// Trạng thái đã xác thực, kèm thông tin người dùng.
  const AuthenticationState.authenticated(User user)
      : this._(
    status: AuthenticationStatus.authenticated,
    user: user,
  );

  /// Trạng thái chưa xác thực.
  const AuthenticationState.unauthenticated()
      : this._(
    status: AuthenticationStatus.unauthenticated,
    user: User.empty,
  );

  /// Trạng thái xác thực hiện tại.
  final AuthenticationStatus status;

  /// Thông tin người dùng hiện tại.
  final User user;

  @override
  List<Object> get props => [status, user];
}
