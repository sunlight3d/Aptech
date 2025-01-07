import 'package:bloc/bloc.dart';
import 'package:meta/meta.dart';
import 'package:equatable/equatable.dart';
import 'package:myapp/models/product.dart';
import 'package:http/http.dart' as http;
part 'event.dart';
part 'state.dart';
class ProductBloc extends Bloc<ProductEvent, ProductState> {
  ProductBloc({required this.httpClient}) : super(const ProductState()) {
    // TODO: Đăng ký xử lý sự kiện ProductFetched
  }

  final http.Client httpClient;
}
