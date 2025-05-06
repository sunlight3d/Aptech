import 'package:baitap01/database/db_helper.dart';
import 'package:baitap01/models/product.dart';
import 'package:flutter/material.dart';

class ProductListScreen extends StatefulWidget {
  ProductListScreen({super.key});

  @override
  State<ProductListScreen> createState() => _ProductListScreenState();
}

class _ProductListScreenState extends State<ProductListScreen> {
  int _numberOfReloadings = 0;
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("List of Products")),
      body: FutureBuilder<List<Product>>(
          future: DBHelper().getProducts(),
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return Center(child: CircularProgressIndicator());
            }
            if (snapshot.hasError) {
              return Center(child: Text("Lỗi: ${snapshot.error}"));
            }
            final products = snapshot.data ?? [];
            if (products.isEmpty) {
              return Center(child: Text("Chưa có sản phầm nào"));
            }
            return ListView.builder(
                padding: const EdgeInsets.all(12),
                itemCount: products.length,
                itemBuilder: (BuildContext context, int index) {
                  Product selectedProduct = products[index];
                  return Dismissible(
                      key: Key(selectedProduct.code),
                      background: Container(color: Colors.red),
                      onDismissed: (direction){
                        print(direction);
                        DBHelper().deleteProduct(selectedProduct.code);
                        setState(() {
                          _numberOfReloadings = _numberOfReloadings < 1000 ? _numberOfReloadings + 1 : 0;
                        });
                      },
                      child: Container(
                    height: 100,
                    decoration: BoxDecoration(
                      //color: Color(int.parse(selectedProduct.colorHex.replaceAll('#', '0xff'))),
                    ),
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.start,
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text('Name : ${selectedProduct.name}'),
                        Text('Price : ${selectedProduct.price}')
                      ],
                    ),
                  )
                  );
                }
                );
          }),
    );
  }
}
