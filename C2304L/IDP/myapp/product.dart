/*
    Mã sản phẩm (String)
    Tên sản phẩm (String)
    Giá sản phẩm (double)
    Số lượng tồn kho (int)
* */
class Product {
  final String code;
  final String name;
  double? price;
  int stock;
  int sold;
  Product({
    required this.code,
    required this.name,
    this.price,
    required this.stock,
    required this.sold
  });
  Product get empty => Product(code: '', name: '', stock: 0, price: 0, sold: 0); //getter
  int get quantity => stock + sold;
}