import 'dart:convert';
import 'package:bloc/bloc.dart';
import 'package:equatable/equatable.dart';
import 'package:myapp/models/product.dart';
import 'package:http/http.dart' as http;
import 'package:myapp/models/product_attribute.dart';
import 'package:myapp/services/product_service.dart';
import 'package:stream_transform/stream_transform.dart';
import 'dart:async';
import 'package:bloc_concurrency/bloc_concurrency.dart';

part 'event.dart';
part 'state.dart';
// bloc.dart
class ProductBloc extends Bloc<ProductEvent, ProductState> {
  final throttleDuration = Duration(milliseconds: 100);
  final ProductService productService;

  ProductBloc({required this.productService}) : super(const ProductState()) {
    on<FetchProductDetail>(_onFetchProductDetail);
    on<FetchProducts>(
      _onFetched,
      transformer: throttleDroppable(throttleDuration),
    );
  }
  EventTransformer<E> throttleDroppable<E>(Duration duration) {
    return (events, mapper) {
      return droppable<E>().call(events.throttle(duration), mapper);
    };
  }
  Future<void> _onFetched(FetchProducts event, Emitter<ProductState> emit) async {
    try {
      final products = await productService.fetchProducts(
        startIndex: event.search.isEmpty ? state.products.length : 0,
        search: event.search,
      );

      if (event.search.isEmpty && event.search.trim().isEmpty) {
        emit(
          state.copyWith(
            status: ProductStatus.success,
            products: [...state.products, ...products],
            hasReachedMax: products.isEmpty,
          ),
        );
      } else {
        emit(
          state.copyWith(
            status: ProductStatus.success,
            products: products,
            hasReachedMax: products.isEmpty,
          ),
        );
      }
    } catch (_) {
      emit(state.copyWith(status: ProductStatus.failure));
    }
  }
  Future<void> _onFetchProductDetail(FetchProductDetail event, Emitter<ProductState> emit) async {
    try {
      emit(state.copyWith(status: ProductStatus.loading));
      final product = await productService.fetchProductDetail(event.productId);
      emit(state.copyWith(status: ProductStatus.success, selectedProduct: product));
    } catch (e) {
      emit(state.copyWith(status: ProductStatus.failure));
    }
  }
}

