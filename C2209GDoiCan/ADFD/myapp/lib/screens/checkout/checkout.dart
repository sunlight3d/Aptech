import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:myapp/bloc/cart/bloc.dart';
import 'package:myapp/services/utils.dart';
import 'package:myapp/widgets/app_button.dart';

class CheckoutScreen extends StatefulWidget {
  const CheckoutScreen({super.key});

  @override
  State<CheckoutScreen> createState() => _CheckoutScreenState();
}

class _CheckoutScreenState extends State<CheckoutScreen> {
  String selectedPaymentMethod = "cod";
  String selectedShippingMethod = "fast";

  @override
  Widget build(BuildContext context) {
    return BlocBuilder<CartBloc, CartState>(
      builder: (context, state) {
        if (state.cartItems.isEmpty) {
          return Scaffold(
            appBar: AppBar(
              title: const Text("Thanh toán"),
              centerTitle: true,
            ),
            body: const Center(child: Text("Giỏ hàng trống, vui lòng thêm sản phẩm trước khi thanh toán!")),
          );
        }

        final items = state.cartItems;
        final totalAmount = items.fold(0.0, (sum, item) => sum + item.price * item.quantity);

        return Scaffold(
          appBar: AppBar(
            centerTitle: true,
            title: Text(
              "Thanh toán",
              style: GoogleFonts.roboto(fontWeight: FontWeight.bold),
            ),
            leading: IconButton(
              icon: const Icon(Icons.arrow_back, color: Colors.black),
              onPressed: () => context.go('/main'),
            ),
            backgroundColor: Colors.white,
            elevation: 0,
          ),
          body: SingleChildScrollView(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text("Sản phẩm trong đơn hàng", style: GoogleFonts.roboto(fontWeight: FontWeight.bold)),
                const SizedBox(height: 10),
                ...items.map((item) {
                  return Padding(
                    padding: const EdgeInsets.symmetric(vertical: 8.0),
                    child: Row(
                      children: [
                        Image.network(
                          item.productImage ?? 'https://via.placeholder.com/100',
                          width: 80,
                          height: 80,
                          fit: BoxFit.cover,
                        ),
                        const SizedBox(width: 10),
                        Expanded(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                item.productName,
                                style: GoogleFonts.roboto(fontSize: 16, fontWeight: FontWeight.bold),
                              ),
                              if (item.variants.isNotEmpty)
                                Column(
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                  children: item.variants.map((variant) {
                                    return Text("${variant.name}: ${variant.value}");
                                  }).toList(),
                                ),
                              const SizedBox(height: 5),
                              Text(
                                formatCurrency(item.price),
                                style: GoogleFonts.roboto(fontSize: 16, fontWeight: FontWeight.bold, color: Colors.red),
                              ),
                              Text("x${item.quantity}", style: const TextStyle(fontSize: 16)),
                            ],
                          ),
                        ),
                      ],
                    ),
                  );
                }).toList(),
                const SizedBox(height: 10),
                Text("Tổng thanh toán:", style: GoogleFonts.roboto(fontSize: 18, fontWeight: FontWeight.bold)),
                Text(formatCurrency(totalAmount), style: GoogleFonts.roboto(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.red)),
                const SizedBox(height: 20),
                AppButton(
                  label: "Đặt hàng",
                  onPressed: () {
                    print("✅ Xác nhận thanh toán");
                  },
                ),
              ],
            ),
          ),
        );
      },
    );
  }
}
