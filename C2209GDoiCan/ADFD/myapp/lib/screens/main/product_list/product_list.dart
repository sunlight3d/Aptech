import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:go_router/go_router.dart';
import 'package:myapp/bloc/product/bloc.dart';
import 'package:myapp/screens/main/product_list/bottom_loader.dart';
import 'product_item.dart';

class ProductListScreen extends StatefulWidget {
  const ProductListScreen({super.key});

  @override
  State<ProductListScreen> createState() => _ProductListScreenState();
}

class _ProductListScreenState extends State<ProductListScreen> {
  final _scrollController = ScrollController();
  final _searchController = TextEditingController();

  @override
  void initState() {
    super.initState();
    _scrollController.addListener(_onScroll);
  }

  @override
  void dispose() {
    _scrollController.dispose();
    _searchController.dispose();
    super.dispose();
  }

  void _onSearch(String query) {
    // Gửi sự kiện tìm kiếm đến ProductBloc
    context.read<ProductBloc>().add(FetchProducts(search: query));
  }

  void _onScroll() {
    if (_isBottom) {
      context.read<ProductBloc>().add(FetchProducts());
    }
  }

  bool get _isBottom {
    if (!_scrollController.hasClients) return false;
    final maxScroll = _scrollController.position.maxScrollExtent;
    final currentScroll = _scrollController.offset;
    return currentScroll >= (maxScroll * 0.9);
  }
  void _navigateToProductDetail(BuildContext context, int productId) {
    context.go('/main/products/$productId'); // Sử dụng GoRouter để điều hướng
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // Loại bỏ AppBar
      appBar: null,
      body: SafeArea(
        child: Column(
          children: [
            // Ô tìm kiếm
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: TextField(
                controller: _searchController,
                decoration: InputDecoration(
                  hintText: 'Search products...',
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(8.0),
                  ),
                  contentPadding: const EdgeInsets.symmetric(vertical: 8, horizontal: 10), // Giảm chiều cao
                  suffixIcon: IconButton(
                    icon: const Icon(Icons.search, color: Colors.purple,),
                    onPressed: () => _onSearch(_searchController.text),
                  ),
                ),
                onSubmitted: _onSearch,
              ),
            ),
            // Danh sách sản phẩm
            Expanded(
              child: BlocBuilder<ProductBloc, ProductState>(
                builder: (context, state) {
                  if (state.status == ProductStatus.failure) {
                    return const Center(child: Text('Failed to fetch products'));
                  } else if (state.status == ProductStatus.success) {
                    if (state.products.isEmpty) {
                      return const Center(child: Text('No products available'));
                    }
                    return ListView.builder(
                      controller: _scrollController,
                      itemCount: state.hasReachedMax
                          ? state.products.length
                          : state.products.length + 1,
                      itemBuilder: (BuildContext context, int index) {
                        if (index >= state.products.length) {
                          return const BottomLoader();
                        }
                        final product = state.products[index];
                        return GestureDetector(
                          onTap: () => _navigateToProductDetail(context, product.id), // Nhấn vào sản phẩm để điều hướng
                          child: ProductItem(product: product),
                        );
                      },
                    );
                  } else {
                    // Hiển thị loading indicator khi trạng thái là initial hoặc loading
                    return const Center(child: CircularProgressIndicator());
                  }
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
