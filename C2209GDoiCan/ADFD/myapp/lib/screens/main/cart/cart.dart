import 'package:awesome_snackbar_content/awesome_snackbar_content.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/cart/bloc.dart';
import 'package:myapp/dtos/responses/cart_item.dart';
import 'package:myapp/services/utils.dart';
import 'package:myapp/widgets/app_button.dart';

class CartScreen extends StatelessWidget {
  const CartScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Giỏ hàng'),
        centerTitle: true,
        leading: SizedBox.shrink(), // Ẩn nút back
      ),
      body: BlocBuilder<CartBloc, CartState>(
        builder: (context, state) {
          if (state.status == CartStatus.loading) {
            return const Center(child: CircularProgressIndicator());
          } else if (state.status == CartStatus.failure) {
            return const Center(child: Text('Không thể tải giỏ hàng!'));
          } else if (state.cartItems.isEmpty) {
            return const Center(child: Text('Giỏ hàng của bạn đang trống!'));
          }

          final List<CartItemResponse> cartItems = state.cartItems;
          final int totalQuantity =
          cartItems.fold(0, (sum, item) => sum + item.quantity);
          final double totalPrice = cartItems.fold(
              0.0, (sum, item) => sum + item.price * item.quantity);
          return Column(
            children: [
              Expanded(
                child: ListView.builder(
                  itemCount: cartItems.length,
                  itemBuilder: (context, index) {
                    final item = cartItems[index];

                    return Card(
                      margin: const EdgeInsets.symmetric(
                          horizontal: 10, vertical: 5),
                      child: Padding(
                        padding: const EdgeInsets.all(10.0),
                        child: Row(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            // Hình ảnh sản phẩm
                            Image.network(
                              item.productImage ??
                                  'https://via.placeholder.com/100',
                              width: 80,
                              height: 80,
                              fit: BoxFit.cover,
                            ),
                            const SizedBox(width: 10),

                            // Thông tin sản phẩm
                            Expanded(
                              child: Column(
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(
                                    item.productName ?? "Không xác định",
                                    style: const TextStyle(
                                        fontSize: 16,
                                        fontWeight: FontWeight.bold),
                                  ),
                                  const SizedBox(height: 5),

                                  // Biến thể sản phẩm (nếu có)
                                  if (item.variants.isNotEmpty)
                                    Column(
                                      crossAxisAlignment:
                                      CrossAxisAlignment.start,
                                      children: item.variants.map((variant) {
                                        return Text(
                                            "${variant.name}: ${variant.value}");
                                      }).toList(),
                                    ),

                                  const SizedBox(height: 5),
                                  Text(
                                    formatCurrency(item.price),
                                    style: const TextStyle(
                                      fontSize: 16,
                                      color: Colors.red,
                                    ),
                                  ),
                                  // Nút xóa sản phẩm khỏi giỏ hàng
                                  Row(
                                    mainAxisAlignment:
                                    MainAxisAlignment.spaceBetween,
                                    children: [
                                      Text("Số lượng: ${item.quantity}"),
                                      IconButton(
                                        icon: const Icon(Icons.delete, color: Colors.red),
                                        onPressed: () {
                                          alert(
                                            context,
                                            "Bạn có chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng?",
                                            ContentType.warning,
                                            onConfirm: () {
                                              context.read<CartBloc>().add(RemoveFromCart(item.id));
                                            },
                                          );
                                        },
                                      ),

                                    ],
                                  ),
                                ],
                              ),
                            ),
                          ],
                        ),
                      ),
                    );
                  },
                ),
              ),

              // Tổng tiền & nút thanh toán
              Container(
                padding: const EdgeInsets.all(15),
                decoration: BoxDecoration(
                  color: Colors.white,
                  border:
                  Border(top: BorderSide(color: Colors.grey.shade300)),
                ),
                child: Column(
                  children: [
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        const Text("Tổng số lượng:",
                            style: TextStyle(
                                fontSize: 16, fontWeight: FontWeight.bold)),
                        Text("$totalQuantity sản phẩm",
                            style: const TextStyle(fontSize: 16)),
                      ],
                    ),
                    const SizedBox(height: 5),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        const Text("Tổng tiền:",
                            style: TextStyle(
                                fontSize: 16, fontWeight: FontWeight.bold)),
                        Text(formatCurrency(totalPrice),
                            style: const TextStyle(
                                fontSize: 18,
                                color: Colors.red,
                                fontWeight: FontWeight.bold)),
                      ],
                    ),
                    const SizedBox(height: 10),
                    AppButton(
                      label: "Thanh toán ngay",
                      onPressed: () {
                        final checkoutItems = state.cartItems.map((item) {
                          return {
                            "productId": item.productVariantId,
                            "productVariantId": item.productVariantId,
                            "quantity": item.quantity,
                            "price": item.price,
                            "productName": item.productName,
                            "productImage": item.productImage,
                            "variants": item.variants.map((v) => {"name": v.name, "value": v.value}).toList(),
                          };
                        }).toList();

                        final totalAmount = state.cartItems.fold(0.0, (sum, item) => sum + item.price * item.quantity);

                        context.go('/checkout', extra: {
                          "items": checkoutItems,
                          "totalAmount": totalAmount,
                        });
                      },
                    ),
                  ],
                ),
              ),
            ],
          );
        },
      ),
    );
  }
}
