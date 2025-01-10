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
class ProductBloc extends Bloc<ProductEvent, ProductState> {
  final throttleDuration = Duration(milliseconds: 100);
  //final http.Client httpClient;
  final ProductService productService;


  EventTransformer<E> throttleDroppable<E>(Duration duration) {
    return (events, mapper) {
      return droppable<E>().call(events.throttle(duration), mapper);
    };
  }
  ProductBloc({required this.productService}) : super(const ProductState()) {
    on<FetchProducts>(
      _onFetched,
      transformer: throttleDroppable(throttleDuration),
    );
  }


  Future<void> _onFetched(
      FetchProducts event,
      Emitter<ProductState> emit,
      ) async {
    if (state.hasReachedMax) return;

    try {
      final products = await productService.fetchProducts(startIndex: state.products.length);

      if (products.isEmpty) {
        return emit(state.copyWith(hasReachedMax: true));
      }

      emit(
        state.copyWith(
          status: ProductStatus.success,
          products: [...state.products, ...products],
        ),
      );
    } catch (_) {
      emit(state.copyWith(status: ProductStatus.failure));
    }
  }
}
