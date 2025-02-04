part of './bloc.dart';
/// 🔹 Trạng thái của PaymentBloc
// Payment State
abstract class PaymentState extends Equatable {
  @override
  List<Object?> get props => [];
}

class PaymentInitial extends PaymentState {}

class PaymentProcessing extends PaymentState {}

class PaymentSuccess extends PaymentState {}

class PaymentFailure extends PaymentState {
  final String error;
  PaymentFailure(this.error);

  @override
  List<Object?> get props => [error];
}
