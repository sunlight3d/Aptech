import 'package:de01/models/product.dart';
import 'package:de01/repositories/product_repository.dart';
import 'package:de01/widgets/product_row.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

class ProductListScreen extends StatelessWidget {
  const ProductListScreen({super.key});

  @override
  Widget build(BuildContext context) {
    double screenWidth = MediaQuery.of(context).size.width;
    final productRepository = GetIt.instance<ProductRepository>();
    return Scaffold(
      body: SafeArea(
        child: FutureBuilder<List<Product>>(
          future: productRepository.fetchProducts(),
          builder: (BuildContext context, AsyncSnapshot<List<Product>> snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return CircularProgressIndicator(); // Show a progress indicator while loading
            } else if (snapshot.hasError) {
              return Text('Error: ${snapshot.error}'); // Show an error message if an error occurred
            }
            return ListView.builder(itemBuilder: (context, index) {
              Product selectedProduct = snapshot.data![index];
              return ProductRow(product: selectedProduct);
            },itemCount: snapshot.data?.length ?? 0,);
          },
        )
      ),
    );
  }
}
