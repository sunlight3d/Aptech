import 'package:de01/models/product.dart';
import 'package:de01/repositories/product_repository.dart';
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
              return Container(
                padding: EdgeInsets.symmetric(horizontal: 10, vertical: 5),
                //padding: EdgeInsets.only(top: 0.05*screenWidth, right: 10, bottom: 5, left: 10),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('Mouse', style: TextStyle(fontSize: 16),),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Text(selectedProduct.code, style: TextStyle(fontSize: 16),),
                        Text(selectedProduct.name, style: TextStyle(fontSize: 16),),
                        Container(width: 60,height: 60,
                          color: Color(selectedProduct.hexValue))
                      ],
                    ),
                    SizedBox(height: 10,),
                    Container(
                      height: 1,
                      color: Colors.grey,
                    )
                  ],
                ),
              );
            },itemCount: snapshot.data?.length ?? 0,);
          },
        )
      ),
    );
  }
}
