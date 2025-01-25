import 'dart:async';
import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';
import 'package:myapp/services/user_service.dart';
import 'package:myapp/models/user.dart';

part 'event.dart';
part 'state.dart';

class UserBloc extends Bloc<UserEvent, UserState> {
  final UserService userService;

  UserBloc({required this.userService}) : super(UserInitial()) {
    on<FetchUserDetail>(_onFetchUserDetail);
  }

  Future<void> _onFetchUserDetail(FetchUserDetail event, Emitter<UserState> emit) async {
    emit(UserLoading());
    try {
      final user = await userService.fetchUserDetail(event.userId, event.token);
      emit(UserLoaded(user: user));
    } catch (e) {
      emit(UserError(message: e.toString()));
    }
  }
}