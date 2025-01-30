import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
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
  late Product product;
  int quantity = 1;
  String? selectedImage;
  int selectedImageIndex = 0;
  bool isModalOpen = false;
  int modalImageIndex = 0;
  Map<String, String> selectedVariantValues = {}; // Lưu biến thể đã chọn
  ProductVariant? selectedVariant; // Biến thể hiện tại
  late PageController _pageController;

  @override
  void initState() {
    super.initState();
    context.read<ProductBloc>().add(FetchProductDetail(widget.productId));
    _pageController = PageController(initialPage: selectedImageIndex);
  }
  void _onPageChanged(int index) {
    setState(() {
      selectedImageIndex = index;
    });
  }
  void _handleThumbnailHover(String imageUrl) {
    setState(() {
      selectedImage = imageUrl;
    });
  }

  void _handleImageClick(int index) {
    setState(() {
      modalImageIndex = index;
      isModalOpen = true;
    });
  }

  void _handlePrevImage(List<String> images) {
    setState(() {
      modalImageIndex = (modalImageIndex == 0) ? images.length - 1 : modalImageIndex - 1;
    });
  }

  void _handleNextImage(List<String> images) {
    setState(() {
      modalImageIndex = (modalImageIndex == images.length - 1) ? 0 : modalImageIndex + 1;
    });
  }

  void _handleQuantityChange(int change) {
    setState(() {
      int updatedQuantity = quantity + change;
      int maxStock = selectedVariant?.stock ?? product.stock;

      // Chỉ tăng số lượng nếu nó không vượt quá số lượng tồn kho
      if (updatedQuantity >= 1 && updatedQuantity <= maxStock) {
        quantity = updatedQuantity;
      }
    });
  }


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
    return BlocListener<ProductBloc, ProductState>(
      listener: (context, state) {
        if (state.status == ProductStatus.success && state.selectedProduct != null) {
          product = state.selectedProduct!;
          final Map<String, String> defaultVariants = {};

          // Duyệt qua các nhóm biến thể để chọn giá trị đầu tiên của mỗi nhóm
          final variantGroups = product.variants.fold<Map<String, List<String>>>({}, (map, variant) {
            for (var value in variant['values']) {
              map.putIfAbsent(value['name'], () => []).add(value['value']);
            }
            return map;
          });

          // Chọn giá trị đầu tiên của nhóm biến thể đầu tiên và thứ hai
          int count = 0;
          for (var entry in variantGroups.entries) {
            if (count < 2 && entry.value.isNotEmpty) {
              defaultVariants[entry.key] = entry.value[0]; // Chọn giá trị đầu tiên
              count++;
            }
          }

          setState(() {
            selectedVariantValues = defaultVariants;
            _selectVariant(product);
          });
        }
      },
      child: BlocBuilder<ProductBloc, ProductState>(
        builder: (context, state) {
          if (state.status == ProductStatus.loading) {
            return const Scaffold(body: Center(child: CircularProgressIndicator()));
          } else if (state.status == ProductStatus.failure) {
            return const Scaffold(body: Center(child: Text('Lỗi khi lấy dữ liệu')));
          } else if (state.selectedProduct == null) {
            return const Scaffold(body: Center(child: Text('Không có dữ liệu sản phẩm')));
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
                  // 🖼 Ảnh chính sản phẩm (vuốt được)
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
                  // 🖼 Ảnh nhỏ (chọn ảnh)
                  SizedBox(
                    height: 80, // Chiều cao cố định cho container chứa ảnh
                    child: ListView.builder(
                      scrollDirection: Axis.horizontal,
                      itemCount: images.length,
                      itemBuilder: (context, index) {
                        String imgUrl = images[index];
                        bool isSelected = selectedImageIndex == index;
                        return GestureDetector(
                          onTap: () {
                            _pageController.animateToPage(index,
                                duration: const Duration(milliseconds: 300),
                                curve: Curves.easeInOut);
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

                  // 🛍 Thông tin sản phẩm
                  Text(product.name, style: const TextStyle(fontSize: 22, fontWeight: FontWeight.bold)),
                  const SizedBox(height: 5),
                  Text("⭐ ${product.rating.toStringAsFixed(1)} (${product.totalRatings} đánh giá)"),
                  Text("Đã bán: ${product.totalSold} sản phẩm"),
                  const SizedBox(height: 5),

                  // 💰 Giá sản phẩm
                  Row(
                    children: [
                      // Định dạng giá hiện tại
                      Text(
                        formatCurrency(selectedVariant?.price ?? product.price),
                        style: const TextStyle(
                          fontSize: 22,
                          color: Colors.red,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      const SizedBox(width: 10), // Khoảng cách giữa giá hiện tại và giá cũ
                      // Hiển thị giá cũ nếu tồn tại, nếu không thì hiển thị một Container trống
                      (selectedVariant?.oldPrice != null || product.oldPrice != null)
                          ? Text(
                        formatCurrency(selectedVariant?.oldPrice ?? product.oldPrice),
                        style: const TextStyle(
                          fontSize: 18,
                          color: Colors.grey,
                          decoration: TextDecoration.lineThrough,
                        ),
                      )
                          : const SizedBox.shrink(), // Không hiển thị gì nếu không có giá cũ
                    ],
                  ),
                  const SizedBox(height: 10),

                  // 🎭 Chọn biến thể sản phẩm
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
                          Text(variantName, style: const TextStyle(fontWeight: FontWeight.bold)),
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

                  // 📦 Số lượng sản phẩm
                  Row(
                    children: [
                      const Text("Số lượng:", style: TextStyle(fontWeight: FontWeight.bold)),
                      const SizedBox(width: 10),

                      IconButton(
                        onPressed: quantity > 1 ? () => _handleQuantityChange(-1) : null,
                        icon: const Icon(Icons.remove_circle_outline),
                      ),
                      Text("$quantity", style: const TextStyle(fontSize: 18)),
                      IconButton(
                        onPressed: quantity < (selectedVariant?.stock ?? product.stock)
                            ? () => _handleQuantityChange(1)
                            : null,
                        icon: const Icon(Icons.add_circle_outline),
                      ),


                      const SizedBox(width: 10),
                      Text("Kho: ${selectedVariant?.stock ?? product.stock}"),
                    ],
                  ),
                  const SizedBox(height: 20),

                  // 🛒 Nút thêm vào giỏ hàng & mua ngay
                  Row(
                    children: [
                      Expanded(
                        child: InkWell(
                          onTap: () {},
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
                                  Text("Thêm vào giỏ hàng", style: TextStyle(fontSize: 14, color: Colors.white)),
                                ],
                              ),
                            ),
                          ),
                        ),
                      ),
                      const SizedBox(width: 10),
                      Expanded(
                        child: InkWell(
                          onTap: () {},
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
                                  Text("Mua ngay", style: TextStyle(fontSize: 14, color: Colors.white)),
                                ],
                              ),
                            ),
                          ),
                        ),
                      ),
                    ],
                  ),
                  const SizedBox(height: 20),
                  // 📜 Mô tả sản phẩm
                  if (product.description.isNotEmpty)
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Row(
                          children: [
                            Icon(Icons.description, color: Colors.grey), // Icon mô tả
                            SizedBox(width: 5), // Khoảng cách giữa icon và text
                            Text(
                              "Mô tả sản phẩm",
                              style: TextStyle(fontWeight: FontWeight.bold, fontSize: 18),
                            ),
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
