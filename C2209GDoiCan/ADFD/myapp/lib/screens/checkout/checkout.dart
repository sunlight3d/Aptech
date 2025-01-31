import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:google_fonts/google_fonts.dart';

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
    return Scaffold(
      appBar: AppBar(
        centerTitle: true, // Đưa tiêu đề ra giữa
        title: Text(
          "Thanh toán",
          style: GoogleFonts.roboto(fontWeight: FontWeight.bold),
        ),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back, color: Colors.black),
          onPressed: () => Navigator.pop(context),
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
              onTap: () => context.go('/checkout/select-address'),
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
                      child: Text(
                        "Nguyễn Đức Hoàng, Phòng 3302, Helios Tower, Số 75, Nguyễn Trị Tam, Quận Hoàng Mai, Hà Nội",
                        style: GoogleFonts.roboto(fontSize: 16),
                      ),
                    ),
                  ],
                ),
              ),
            ),
            const SizedBox(height: 10),

            // Sản phẩm trong đơn hàng (Dữ liệu fake)
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
                children: [
                  Row(
                    children: [
                      Image.network(
                        "https://placehold.co/800@2x.png",
                        width: 80,
                        height: 80,
                      ),
                      const SizedBox(width: 10),
                      Expanded(
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              "Gối nệm Ema cho người Việt",
                              style: GoogleFonts.roboto(fontSize: 16, fontWeight: FontWeight.bold),
                            ),
                            Text(
                              "Màu tối - Size M",
                              style: GoogleFonts.roboto(fontSize: 14, color: Colors.grey),
                            ),
                            const SizedBox(height: 5),
                            Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text(
                                  "₫389.000",
                                  style: GoogleFonts.roboto(
                                    fontSize: 16,
                                    fontWeight: FontWeight.bold,
                                    color: Colors.red,
                                  ),
                                ),
                                const Text("x1", style: TextStyle(fontSize: 16)),
                              ],
                            ),
                          ],
                        ),
                      ),
                    ],
                  ),
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
                  ListTile(
                    title: const Text("Giao hàng hỏa tốc - Nhận trong ngày"),
                    trailing: selectedShippingMethod == "express" ? const Icon(Icons.check, color: Colors.orange) : null,
                    onTap: () => setState(() => selectedShippingMethod = "express"),
                  ),
                  ListTile(
                    title: const Text("Giao hàng tiết kiệm - Nhận sau 3-5 ngày"),
                    trailing: selectedShippingMethod == "standard" ? const Icon(Icons.check, color: Colors.orange) : null,
                    onTap: () => setState(() => selectedShippingMethod = "standard"),
                  ),
                ],
              ),
            ),
            const SizedBox(height: 10),

            // Mã giảm giá
            Container(
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                color: Colors.white,
                borderRadius: BorderRadius.circular(10),
                boxShadow: [
                  BoxShadow(color: Colors.grey.shade300, blurRadius: 5, spreadRadius: 2),
                ],
              ),
              child: ListTile(
                title: Text("Shopee Voucher", style: GoogleFonts.roboto(fontWeight: FontWeight.bold)),
                subtitle: Text("Miễn phí vận chuyển", style: GoogleFonts.roboto(color: Colors.green)),
                trailing: const Icon(Icons.chevron_right),
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
                  ListTile(
                    title: const Text("Thanh toán khi nhận hàng"),
                    trailing: selectedPaymentMethod == "cod" ? const Icon(Icons.check, color: Colors.orange) : null,
                    onTap: () => setState(() => selectedPaymentMethod = "cod"),
                  ),
                  ListTile(
                    title: const Text("Thanh toán VNPay"),
                    trailing: selectedPaymentMethod == "vnpay" ? const Icon(Icons.check, color: Colors.orange) : null,
                    onTap: () => setState(() => selectedPaymentMethod = "vnpay"),
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
                  Text("₫389.000", style: GoogleFonts.roboto(fontSize: 18, fontWeight: FontWeight.bold, color: Colors.red)),
                ],
              ),
            ),
            const SizedBox(height: 20),
          ],
        ),
      ),
      bottomNavigationBar: Container(
        height: 45,
        padding: const EdgeInsets.symmetric(horizontal: 16),
        decoration: BoxDecoration(
          color: Colors.white,
          boxShadow: [
            BoxShadow(color: Colors.grey.shade300, blurRadius: 5, spreadRadius: 2),
          ],
        ),
        child: InkWell(
          onTap: () {
            // Xử lý đặt hàng
          },
          child: Container(
            height: 40,
            width: double.infinity,
            decoration: const BoxDecoration(
              color: Colors.purple,
              borderRadius: BorderRadius.all(Radius.circular(10)),
            ),
            child: Center(
              child: Text(
                'Đặt hàng',
                style: GoogleFonts.roboto(fontSize: 16, color: Colors.white),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
