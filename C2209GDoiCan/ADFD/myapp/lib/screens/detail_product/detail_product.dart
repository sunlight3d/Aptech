import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/product/bloc.dart';
import 'package:myapp/models/product.dart';
import 'package:myapp/models/product_variant.dart';

class ProductDetailScreen extends StatefulWidget {
  final int productId;

  const ProductDetailScreen({super.key, required this.productId});

  @override
  State<ProductDetailScreen> createState() => _ProductDetailScreenState();
}

class _ProductDetailScreenState extends State<ProductDetailScreen> {
  int quantity = 1;
  String? selectedImage;
  int selectedImageIndex = 0;
  bool isModalOpen = false;
  int modalImageIndex = 0;
  Map<String, String> selectedVariantValues = {}; // Lưu biến thể đã chọn
  ProductVariant? selectedVariant; // Biến thể hiện tại

  @override
  void initState() {
    super.initState();
    context.read<ProductBloc>().add(FetchProductDetail(widget.productId));
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

  void _handleQuantityChange(int change, int stock) {
    setState(() {
      int updatedQuantity = quantity + change;
      if (updatedQuantity >= 1 && updatedQuantity <= stock) {
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
    return BlocBuilder<ProductBloc, ProductState>(
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
                // 🖼 Ảnh chính sản phẩm
                GestureDetector(
                  onTap: () => _handleImageClick(selectedImageIndex),
                  child: Image.network(
                    selectedImage ?? images[0],
                    height: 300,
                    fit: BoxFit.cover,
                  ),
                ),
                const SizedBox(height: 10),

                // 🖼 Ảnh nhỏ
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: images.asMap().entries.map((entry) {
                    int index = entry.key;
                    String imgUrl = entry.value;
                    return GestureDetector(
                      onTap: () => _handleThumbnailHover(imgUrl),
                      child: Container(
                        margin: const EdgeInsets.symmetric(horizontal: 5),
                        padding: const EdgeInsets.all(2),
                        decoration: BoxDecoration(
                          border: Border.all(color: selectedImage == imgUrl ? Colors.blue : Colors.grey),
                          borderRadius: BorderRadius.circular(8),
                        ),
                        child: Image.network(imgUrl, width: 60, height: 60, fit: BoxFit.cover),
                      ),
                    );
                  }).toList(),
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
                    Text("${selectedVariant?.price ?? product.price}₫",
                        style: const TextStyle(fontSize: 22, color: Colors.red, fontWeight: FontWeight.bold)),
                    const SizedBox(width: 10),
                    Text("${selectedVariant?.oldPrice ?? product.oldPrice}₫",
                        style: const TextStyle(fontSize: 18, color: Colors.grey, decoration: TextDecoration.lineThrough)),
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
                      onPressed: () => _handleQuantityChange(-1, selectedVariant?.stock ?? product.stock),
                      icon: const Icon(Icons.remove_circle_outline),
                    ),
                    Text("$quantity", style: const TextStyle(fontSize: 18)),
                    IconButton(
                      onPressed: () => _handleQuantityChange(1, selectedVariant?.stock ?? product.stock),
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
                      const Text("📄 Mô tả sản phẩm", style: TextStyle(fontWeight: FontWeight.bold, fontSize: 18)),
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
    );
  }
}
