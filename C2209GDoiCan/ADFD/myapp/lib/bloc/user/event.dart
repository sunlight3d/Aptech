part of 'bloc.dart';

abstract class UserEvent extends Equatable {
  @override
  List<Object?> get props => [];
}

class FetchUserDetail extends UserEvent {
  final int userId;
  final String token;

  FetchUserDetail({required this.userId, required this.token});

  @override
  List<Object?> get props => [userId, token];
}