import 'package:awesome_snackbar_content/awesome_snackbar_content.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:myapp/bloc/payment/bloc.dart';
import 'package:myapp/dtos/requests/vnpay_payment.dart';
import 'package:myapp/repositories/local_storage_repository.dart';
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
  late List<Map<String, dynamic>> items;
  late double totalAmount;
  Map<String, String>? currentAddress;
  final LocalStorageRepository _localStorage = LocalStorageRepository();

  @override
  void initState() {
    super.initState();
    _loadSavedAddress(); // Lấy địa chỉ đã lưu
  }

  void _loadSavedAddress() async {
    final savedAddress = await _localStorage.getSelectedAddress();
    if (savedAddress != null) {
      setState(() {
        currentAddress = savedAddress;
      });
    }
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    final Map<String, dynamic>? extra = GoRouterState.of(context).extra as Map<String, dynamic>?;

    if (extra == null || !extra.containsKey("items") || !extra.containsKey("totalAmount")) {
      SchedulerBinding.instance.addPostFrameCallback((_) {
        context.go('/main');
      });
      return;
    }

    items = List<Map<String, dynamic>>.from(extra["items"]);
    totalAmount = extra["totalAmount"] as double;

    if (extra.containsKey("selectedShippingMethod")) {
      selectedShippingMethod = extra["selectedShippingMethod"] ?? "fast";
    }
  }

  @override
  Widget build(BuildContext context) {
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
            // Địa chỉ giao hàng
            GestureDetector(
              onTap: () async {
                final selectedAddress = await context.push('/checkout/select-address');
                if (selectedAddress != null && mounted) {
                  setState(() {
                    currentAddress = selectedAddress as Map<String, String>;
                  });
                }
              },
              child: Container(
                padding: const EdgeInsets.all(12),
                decoration: BoxDecoration(
                  color: Colors.white,
                  borderRadius: BorderRadius.circular(10),
                  boxShadow: [
                    BoxShadow(color: Colors.grey.shade300, blurRadius: 5, spreadRadius: 2),
                  ],
                ),
                child: Row(
                  children: [
                    const Icon(Icons.location_on, color: Colors.orange),
                    const SizedBox(width: 10),
                    Expanded(
                      child: currentAddress != null
                          ? Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            currentAddress!['name'] ?? "Chưa có tên",
                            style: GoogleFonts.roboto(fontSize: 16, fontWeight: FontWeight.bold),
                          ),
                          Text(
                            currentAddress!['phone'] ?? "Chưa có số điện thoại",
                            style: GoogleFonts.roboto(fontSize: 14, color: Colors.grey[700]),
                          ),
                          Text(
                            currentAddress!['address'] ?? "Chưa có địa chỉ",
                            style: GoogleFonts.roboto(fontSize: 14),
                          ),
                        ],
                      )
                          : Text(
                        "Chọn địa chỉ giao hàng",
                        style: GoogleFonts.roboto(fontSize: 16, color: Colors.grey),
                      ),
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(height: 10),

            // Danh sách sản phẩm
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(10),
                boxShadow: [
                  BoxShadow(color: Colors.grey.shade300, blurRadius: 5, spreadRadius: 2),
                ],
              ),
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
                            item["productImage"],
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
                                  item["productName"],
                                  style: GoogleFonts.roboto(fontSize: 16, fontWeight: FontWeight.bold),
                                ),
                                if (item["variants"] != null && item["variants"].isNotEmpty)
                                  Column(
                                    crossAxisAlignment: CrossAxisAlignment.start,
                                    children: item["variants"].map<Widget>((variant) {
                                      return Text("${variant["name"]}: ${variant["value"]}");
                                    }).toList(),
                                  ),
                                const SizedBox(height: 5),
                                Row(
                                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                                  children: [
                                    Text(
                                      formatCurrency(item["price"]),
                                      style: GoogleFonts.roboto(
                                        fontSize: 16,
                                        fontWeight: FontWeight.bold,
                                        color: Colors.red,
                                      ),
                                    ),
                                    Text("x${item["quantity"]}", style: const TextStyle(fontSize: 16)),
                                  ],
                                ),
                              ],
                            ),
                          ),
                        ],
                      ),
                    );
                  }).toList(),
                ],
              ),
            ),
            const SizedBox(height: 10),
            // Phương thức vận chuyển
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(10),
                boxShadow: [
                  BoxShadow(color: Colors.grey.shade300, blurRadius: 5, spreadRadius: 2),
                ],
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text("Phương thức vận chuyển", style: GoogleFonts.roboto(fontWeight: FontWeight.bold)),
                  const SizedBox(height: 10),

                  RadioListTile<String>(
                    value: "fast",
                    groupValue: selectedShippingMethod,
                    activeColor: Colors.purple,
                    onChanged: (value) {
                      setState(() => selectedShippingMethod = value!);
                    },
                    title: const Text("Giao hàng nhanh - Nhận trong ngày"),
                  ),

                  RadioListTile<String>(
                    value: "standard",
                    groupValue: selectedShippingMethod,
                    activeColor: Colors.purple,
                    onChanged: (value) {
                      setState(() => selectedShippingMethod = value!);
                    },
                    title: const Text("Giao hàng tiết kiệm - Nhận sau 3-5 ngày"),
                  ),
                ],
              ),
            ),
            const SizedBox(height: 10),
            // Phương thức thanh toán
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(10),
                boxShadow: [
                  BoxShadow(color: Colors.grey.shade300, blurRadius: 5, spreadRadius: 2),
                ],
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text("Phương thức thanh toán", style: GoogleFonts.roboto(fontWeight: FontWeight.bold)),
                  const SizedBox(height: 10),

                  RadioListTile<String>(
                    value: "cod",
                    groupValue: selectedPaymentMethod,
                    activeColor: Colors.purple,
                    onChanged: (value) {
                      setState(() => selectedPaymentMethod = value!);
                    },
                    title: const Text("Thanh toán khi nhận hàng (COD)"),
                  ),

                  RadioListTile<String>(
                    value: "vnpay",
                    groupValue: selectedPaymentMethod,
                    activeColor: Colors.purple,
                    onChanged: (value) {
                      setState(() => selectedPaymentMethod = value!);
                    },
                    title: const Text("Chuyển khoản qua VNPay"),
                  ),
                ],
              ),
            ),
            const SizedBox(height: 10),
            // Tổng tiền đơn hàng
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(10),
                boxShadow: [
                  BoxShadow(color: Colors.grey.shade300, blurRadius: 5, spreadRadius: 2),
                ],
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Text("Tổng thanh toán:", style: GoogleFonts.roboto(fontSize: 18, fontWeight: FontWeight.bold)),
                  Text(formatCurrency(totalAmount), style: GoogleFonts.roboto(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.red)),
                ],
              ),
            ),
            const SizedBox(height: 20),
          ],
        ),
      ),
      bottomNavigationBar: SafeArea(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: AppButton(
            label: "Đặt hàng",
            onPressed: () {
              if (selectedPaymentMethod == "vnpay") {

              } else {
                print("✅ Thanh toán COD được chọn.");
              }
            },
          ),
        ),
      ),
    );
  }
}