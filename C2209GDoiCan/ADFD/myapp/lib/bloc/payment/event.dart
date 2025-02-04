part of './bloc.dart';
/// 🔹 Các sự kiện của PaymentBloc
abstract class PaymentEvent extends Equatable {
  @override
  List<Object?> get props => [];
}

class StartVNPAYPayment extends PaymentEvent {
  final VNPAYPaymentRequest request;

  StartVNPAYPayment(this.request);

  @override
  List<Object?> get props => [request];
}