

part of 'bloc.dart';

enum ProductStatus { initial, loading, success, failure }

class ProductState extends Equatable {
  const ProductState({
    this.status = ProductStatus.initial,
    this.products = const <Product>[],
    this.hasReachedMax = false,
    this.selectedProduct,
  });

  final ProductStatus status;
  final List<Product> products;
  final bool hasReachedMax;
  final Product? selectedProduct;

  ProductState copyWith({
    ProductStatus? status,
    List<Product>? products,
    bool? hasReachedMax,
    Product? selectedProduct,
  }) {
    return ProductState(
      status: status ?? this.status,
      products: products ?? this.products,
      hasReachedMax: hasReachedMax ?? this.hasReachedMax,
      selectedProduct: selectedProduct ?? this.selectedProduct,
    );
  }
  @override
  String toString() {
    return '''ProductState { status: $status, hasReachedMax: $hasReachedMax, products: ${products.length} }''';
  }

  @override
  List<Object?> get props => [status, products, hasReachedMax, selectedProduct];
}


