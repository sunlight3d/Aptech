import 'package:equatable/equatable.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:myapp/services/auth_service.dart';

part 'event.dart';
part 'state.dart';

class LoginBloc extends Bloc<LoginEvent, LoginState> {
  LoginBloc({
    required AuthService authService,
  }) : _authService = authService,
        super(const LoginState()) {
    on<LoginEmailOrPhoneChanged>(_onEmailOrPhoneChanged);
    on<LoginPasswordChanged>(_onPasswordChanged);
    on<LoginSubmitted>(_onLoginSubmitted);
    on<LoginWithGoogleRequested>(_onGoogleLoginRequested);
  }

  final AuthService _authService;
// Xử lý đăng nhập Google
  Future<void> _onGoogleLoginRequested(
      LoginWithGoogleRequested event,
      Emitter<LoginState> emit,
      ) async {
    emit(state.copyWith(status: LoginStatus.inProgress));
    try {
      await _authService.signInWithGoogle();
      emit(state.copyWith(status: LoginStatus.success));
    } catch (_) {
      emit(state.copyWith(status: LoginStatus.failure));
    }
  }
  /// Người dùng thay đổi email/phone => cập nhật state
  void _onEmailOrPhoneChanged(
      LoginEmailOrPhoneChanged event,
      Emitter<LoginState> emit,
      ) {
    emit(
      state.copyWith(emailOrPhone: event.emailOrPhone),
    );
  }

  /// Người dùng thay đổi password => cập nhật state
  void _onPasswordChanged(
      LoginPasswordChanged event,
      Emitter<LoginState> emit,
      ) {
    emit(
      state.copyWith(password: event.password),
    );
  }

  /// Người dùng nhấn Submit => gọi AuthService.logIn
  Future<void> _onLoginSubmitted(
      LoginSubmitted event,
      Emitter<LoginState> emit,
      ) async {
    // Chuyển state sang inProgress để hiển thị loading
    emit(state.copyWith(status: LoginStatus.inProgress));

    try {
      // Gọi AuthService để thực hiện login
      await _authService.logIn(
        email: state.emailOrPhone, // Có thể là email hoặc phone
        password: state.password,
      );

      // Thành công => success
      emit(state.copyWith(status: LoginStatus.success));
    } catch (_) {
      // Lỗi => failure
      emit(state.copyWith(status: LoginStatus.failure));
    }
  }
}