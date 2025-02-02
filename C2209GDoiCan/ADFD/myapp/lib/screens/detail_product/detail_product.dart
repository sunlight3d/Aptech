import 'package:awesome_snackbar_content/awesome_snackbar_content.dart';
import 'package:flutter/material.dart';
import 'package:flutter/scheduler.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/cart/bloc.dart';
import 'package:myapp/bloc/product/bloc.dart';
import 'package:myapp/models/product.dart';
import 'package:myapp/models/product_variant.dart';
import 'package:myapp/services/utils.dart';

class ProductDetailScreen extends StatefulWidget {
  final int productId;

  const ProductDetailScreen({super.key, required this.productId});

  @override
  State<ProductDetailScreen> createState() => _ProductDetailScreenState();
}

class _ProductDetailScreenState extends State<ProductDetailScreen> {
  int quantity = 1;
  int selectedImageIndex = 0;
  Map<String, String> selectedVariantValues = {}; // Lưu biến thể đã chọn
  ProductVariant? selectedVariant; // Biến thể hiện tại
  late PageController _pageController;

  @override
  void initState() {
    super.initState();
    // Yêu cầu lấy chi tiết sản phẩm từ bloc
    context.read<ProductBloc>().add(FetchProductDetail(widget.productId));
    _pageController = PageController(initialPage: selectedImageIndex);
  }

  void _onPageChanged(int index) {
    setState(() {
      selectedImageIndex = index;
    });
  }

  // Hàm cập nhật số lượng, sử dụng product để lấy thông tin tồn kho
  void _handleQuantityChange(int change, Product product) {
    setState(() {
      int updatedQuantity = quantity + change;
      int maxStock = selectedVariant?.stock ?? product.stock;
      if (updatedQuantity >= 1 && updatedQuantity <= maxStock) {
        quantity = updatedQuantity;
      }
    });
  }

  // Hàm chọn biến thể phù hợp dựa trên các giá trị đã chọn
  void _selectVariant(Product product) {
    for (var variant in product.variants) {
      bool isMatch = variant['values'].every((value) {
        return selectedVariantValues[value['name']] == value['value'];
      });
      if (isMatch) {
        setState(() {
          selectedVariant = ProductVariant.fromJson(variant);
        });
        return;
      }
    }
  }

  @override
  Widget build(BuildContext context) {
    return MultiBlocListener(
      listeners: [
        // Listener của ProductBloc để cập nhật dữ liệu sản phẩm
        BlocListener<ProductBloc, ProductState>(
          listener: (context, state) {
            if (state.status == ProductStatus.success && state.selectedProduct != null) {
              final product = state.selectedProduct!;
              final Map<String, String> defaultVariants = {};

              // Tạo danh sách các nhóm biến thể: key là tên nhóm, value là danh sách các giá trị
              final variantGroups = product.variants.fold<Map<String, List<String>>>({}, (map, variant) {
                for (var value in variant['values']) {
                  map.putIfAbsent(value['name'], () => []).add(value['value']);
                }
                return map;
              });

              // Chọn giá trị đầu tiên của các nhóm biến thể (chỉ lấy 2 nhóm đầu tiên)
              int count = 0;
              for (var entry in variantGroups.entries) {
                if (count < 2 && entry.value.isNotEmpty) {
                  defaultVariants[entry.key] = entry.value[0];
                  count++;
                }
              }

              setState(() {
                selectedVariantValues = defaultVariants;
                _selectVariant(product);
              });
            }
          },
        ),
        // Listener của CartBloc để hiện thông báo sau khi thêm vào giỏ hàng
        BlocListener<CartBloc, CartState>(
          listener: (context, state) {
            if (state.status == CartStatus.success || state.status == CartStatus.failure) {
              SchedulerBinding.instance.addPostFrameCallback((_) {
                alert(context, state.message, state.status == CartStatus.success ? ContentType.success : ContentType.failure);
              });
            }
          },
        ),
      ],
      child: BlocBuilder<ProductBloc, ProductState>(
        builder: (context, state) {
          if (state.status == ProductStatus.loading) {
            return const Scaffold(
              body: Center(child: CircularProgressIndicator()),
            );
          } else if (state.status == ProductStatus.failure) {
            alert(context, 'Lỗi khi lấy dữ liệu', ContentType.failure);
            return const Scaffold(
              body: Center(child: Text('Lỗi khi lấy dữ liệu')),
            );
          } else if (state.selectedProduct == null) {
            alert(context, 'Không có dữ liệu sản phẩm', ContentType.warning);
            return const Scaffold(
              body: Center(child: Text('Không có dữ liệu sản phẩm')),
            );
          }

          final product = state.selectedProduct!;
          final images = product.images.isNotEmpty ? product.images : ["https://via.placeholder.com/400"];

          return Scaffold(
            appBar: AppBar(
              title: const Text('Chi tiết sản phẩm'),
              leading: IconButton(
                icon: const Icon(Icons.arrow_back),
                onPressed: () => context.pop(),
              ),
            ),
            body: SingleChildScrollView(
              padding: const EdgeInsets.all(16.0),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  // Ảnh chính sản phẩm (vuốt được)
                  SizedBox(
                    height: 300,
                    child: PageView.builder(
                      controller: _pageController,
                      itemCount: images.length,
                      onPageChanged: _onPageChanged,
                      itemBuilder: (context, index) {
                        return Center(
                          child: Image.network(
                            images[index],
                            height: 300,
                            fit: BoxFit.cover,
                          ),
                        );
                      },
                    ),
                  ),
                  const SizedBox(height: 10),
                  // Ảnh nhỏ (thumbnail)
                  SizedBox(
                    height: 80,
                    child: ListView.builder(
                      scrollDirection: Axis.horizontal,
                      itemCount: images.length,
                      itemBuilder: (context, index) {
                        String imgUrl = images[index];
                        bool isSelected = selectedImageIndex == index;
                        return GestureDetector(
                          onTap: () {
                            _pageController.animateToPage(
                              index,
                              duration: const Duration(milliseconds: 300),
                              curve: Curves.easeInOut,
                            );
                          },
                          child: Container(
                            margin: const EdgeInsets.symmetric(horizontal: 5),
                            padding: const EdgeInsets.all(2),
                            decoration: BoxDecoration(
                              border: Border.all(color: isSelected ? Colors.blue : Colors.grey),
                              borderRadius: BorderRadius.circular(8),
                            ),
                            child: Image.network(
                              imgUrl,
                              width: 60,
                              height: 60,
                              fit: BoxFit.cover,
                            ),
                          ),
                        );
                      },
                    ),
                  ),
                  const SizedBox(height: 10),
                  // Thông tin sản phẩm
                  Text(product.name,
                      style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
                  const SizedBox(height: 5),
                  Text("⭐ ${product.rating.toStringAsFixed(1)} (${product.totalRatings} đánh giá)"),
                  Text("Đã bán: ${product.totalSold} sản phẩm"),
                  const SizedBox(height: 5),
                  // Giá sản phẩm
                  Row(
                    children: [
                      Text(
                        formatCurrency(selectedVariant?.price ?? product.price),
                        style: const TextStyle(
                          fontSize: 22,
                          color: Colors.red,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      const SizedBox(width: 10),
                      (selectedVariant?.oldPrice != null)
                          ? Text(
                        formatCurrency(selectedVariant?.oldPrice ?? product.oldPrice),
                        style: const TextStyle(
                          fontSize: 18,
                          color: Colors.grey,
                          decoration: TextDecoration.lineThrough,
                        ),
                      )
                          : const SizedBox.shrink(),
                    ],
                  ),
                  const SizedBox(height: 10),
                  // Chọn biến thể sản phẩm
                  Text("Phân loại:", style: const TextStyle(fontWeight: FontWeight.bold)),
                  Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: product.variants.fold<Map<String, List<String>>>({}, (map, variant) {
                      for (var value in variant['values']) {
                        map.putIfAbsent(value['name'], () => []).add(value['value']);
                      }
                      return map;
                    }).entries.map((entry) {
                      String variantName = entry.key;
                      List<String> values = entry.value.toSet().toList();
                      return Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(variantName,
                              style: const TextStyle(fontWeight: FontWeight.bold)),
                          Wrap(
                            spacing: 8,
                            children: values.map((value) {
                              bool isSelected = selectedVariantValues[variantName] == value;
                              return ChoiceChip(
                                label: Text(value),
                                selected: isSelected,
                                onSelected: (selected) {
                                  setState(() {
                                    selectedVariantValues[variantName] = value;
                                    _selectVariant(product);
                                    quantity = 1;
                                  });
                                },
                              );
                            }).toList(),
                          ),
                          const SizedBox(height: 10),
                        ],
                      );
                    }).toList(),
                  ),
                  // Số lượng sản phẩm
                  Row(
                    children: [
                      const Text("Số lượng:",
                          style: TextStyle(fontWeight: FontWeight.bold)),
                      const SizedBox(width: 10),
                      IconButton(
                        onPressed: quantity > 1
                            ? () => _handleQuantityChange(-1, product)
                            : null,
                        icon: const Icon(Icons.remove_circle_outline),
                      ),
                      Text("$quantity", style: const TextStyle(fontSize: 18)),
                      IconButton(
                        onPressed: quantity < (selectedVariant?.stock ?? product.stock)
                            ? () => _handleQuantityChange(1, product)
                            : null,
                        icon: const Icon(Icons.add_circle_outline),
                      ),
                      const SizedBox(width: 10),
                      Text("Kho: ${selectedVariant?.stock ?? product.stock}"),
                    ],
                  ),
                  const SizedBox(height: 20),
                  // Nút thêm vào giỏ hàng & mua ngay
                  Row(
                    children: [
                      Expanded(
                        child: InkWell(
                          onTap: () {
                            // Kiểm tra biến thể đã được chọn (nếu cần)
                            if (selectedVariant == null) {
                              alert(context, "Vui lòng chọn biến thể sản phẩm.", ContentType.warning);
                              return;
                            }
                            // Gửi sự kiện AddToCart đến CartBloc
                            context.read<CartBloc>().add(
                              AddToCart(
                                productVariantId: selectedVariant!.id, // Giả sử ProductVariant có trường id
                                quantity: quantity,
                              ),
                            );
                          },
                          child: Container(
                            height: 45,
                            decoration: BoxDecoration(
                              color: Colors.orange,
                              borderRadius: BorderRadius.circular(10),
                            ),
                            child: const Center(
                              child: Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                  Icon(Icons.shopping_cart, color: Colors.white),
                                  SizedBox(width: 5),
                                  Text(
                                    "Thêm vào giỏ hàng",
                                    style: TextStyle(fontSize: 14, color: Colors.white),
                                  ),
                                ],
                              ),
                            ),
                          ),
                        ),
                      ),
                      const SizedBox(width: 10),
                      Expanded(
                        child: InkWell(
                          onTap: () {
                            // Xử lý mua ngay: chuyển hướng đến màn hình thanh toán
                            context.push("/checkout");
                          },
                          child: Container(
                            height: 45,
                            decoration: BoxDecoration(
                              color: Colors.red,
                              borderRadius: BorderRadius.circular(10),
                            ),
                            child: const Center(
                              child: Row(
                                mainAxisAlignment: MainAxisAlignment.center,
                                children: [
                                  Icon(Icons.attach_money, color: Colors.white),
                                  SizedBox(width: 5),
                                  Text(
                                    "Mua ngay",
                                    style: TextStyle(fontSize: 14, color: Colors.white),
                                  ),
                                ],
                              ),
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 20),
                  // Mô tả sản phẩm
                  if (product.description.isNotEmpty)
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Row(
                          children: [
                            Icon(Icons.description, color: Colors.grey),
                            const SizedBox(width: 5),
                            const Text("Mô tả sản phẩm",
                                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 18)),
                          ],
                        ),
                        const SizedBox(height: 5),
                        Text(product.description),
                      ],
                    ),
                  const SizedBox(height: 30),
                ],
              ),
            ),
          );
        },
      ),
    );
  }
}
