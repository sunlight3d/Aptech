import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';
import 'package:myapp/services/auth_service.dart';

import '../../models/user.dart';

part 'event.dart';
part 'state.dart';

class AuthenticationBloc extends Bloc<AuthenticationEvent, AuthenticationState> {
  AuthenticationBloc({
    required AuthService authService,
  }) : _authService = authService,
        super(const AuthenticationState.unknown()) {
    on<AuthenticationRequested>(_onRequested);
    on<LogoutRequested>(_onLogoutRequested);
  }

  final AuthService _authService;

  /// Lắng nghe thay đổi status từ AuthService.status
  Future<void> _onRequested(
      AuthenticationRequested event,
      Emitter<AuthenticationState> emit,
      ) {
    return emit.onEach<AuthenticationStatus>(
      _authService.status,
      onData: (status) async {
        switch (status) {
          case AuthenticationStatus.unauthenticated:
            emit(const AuthenticationState.unauthenticated());
            break;
          case AuthenticationStatus.authenticated:
            final user = await _tryGetUser();
            emit(
              user != null
                  ? AuthenticationState.authenticated(user)
                  : const AuthenticationState.unauthenticated(),
            );
            break;
          case AuthenticationStatus.unknown:
            emit(const AuthenticationState.unknown());
            break;
        }
      },
      onError: addError,// Gửi lỗi (nếu có) vào phương thức addError của Bloc để xử lý.
    );
  }

  /// Xử lý khi người dùng bấm nút logout
  void _onLogoutRequested(
      LogoutRequested event,
      Emitter<AuthenticationState> emit,
      ) {
    _authService.logOut();
  }

  /// Thử lấy auth từ AuthService
  Future<User?> _tryGetUser() async {
    try {
      final token = await _authService.localStorageRepository.getToken();
      final userId = await _authService.localStorageRepository.getUserId();
      if (token != null && userId != null) {
        final user = await _authService.getUserInfo(userId: userId, token: token);
        return user;
      }
      return null;
    } catch (_) {
      return null;
    }
  }
}