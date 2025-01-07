part of 'bloc.dart';

// Sealed class ProductEvent
sealed class ProductEvent extends Equatable {
  @override
  List<Object?> get props => [];
}

// Event để lấy danh sách sản phẩm
final class FetchProducts extends ProductEvent {
  final int page;
  final String search;

  // Constructor với các tham số mặc định
  FetchProducts({this.page = 1, this.search = ""});

  @override
  List<Object?> get props => [page, search];
}
