import 'package:flutter/material.dart';
import 'package:myapp/models/product.dart';
import 'package:myapp/product_detail.dart';
import 'package:myapp/repositories/api.dart';
import 'package:myapp/widgets/grid_item.dart';

class ProductGrid extends StatefulWidget {
  const ProductGrid({super.key});

  @override
  State<ProductGrid> createState() => _ProductGridState();
}

class _ProductGridState extends State<ProductGrid> {
  final Api _api = Api();
  late Future<List<Product>> _futureFetchProducts;

  @override
  void initState() {
    super.initState();
    _futureFetchProducts = _api.fetchProducts();
  }
  @override
  Widget build(BuildContext context) {

    return Scaffold(
      body: Center(
        child: FutureBuilder<List<Product>>(
          future: _futureFetchProducts, // async work
          builder: (BuildContext context, AsyncSnapshot<List<Product>> snapshot) {
            switch (snapshot.connectionState) {
              case ConnectionState.waiting: return Text('Loading....');
              default: 
                if (snapshot.hasError)
                  return Text('Error: ${snapshot.error}');
                else {
                  List<Product> _products = snapshot.data as List<Product>;
                  return GridView.builder(
                    itemCount: _products.length,
                    gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 2,
                      childAspectRatio: 2.5/4, // ✅ giảm xuống để item cao hơn
                    ),
                    itemBuilder: (BuildContext context, int index) {
                      Product _product = _products[index];
                      return GridItem(product: _product, onTap: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(builder: (context) => ProductDetail(id: _product.id!)),
                        );
                      },);
                    },
                  );
                }

            }
          },
        ),
      )
    );
  }
}
