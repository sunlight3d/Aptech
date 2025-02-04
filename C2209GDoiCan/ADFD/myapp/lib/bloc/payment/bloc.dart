import 'package:equatable/equatable.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:myapp/dtos/requests/vnpay_payment.dart';
import 'package:myapp/services/payment_service.dart';

part 'event.dart';
part 'state.dart';
/// 🔹 Bloc để quản lý thanh toán
// Payment Bloc
class PaymentBloc extends Bloc<PaymentEvent, PaymentState> {
  final PaymentService paymentService;

  PaymentBloc({required this.paymentService}) : super(PaymentInitial()) {
    on<StartVNPAYPayment>((event, emit) async {
      emit(PaymentProcessing());
      try {
        await paymentService.startVNPAY("");
        emit(PaymentSuccess());
      } catch (e) {
        emit(PaymentFailure(e.toString()));
      }
    });
  }
}