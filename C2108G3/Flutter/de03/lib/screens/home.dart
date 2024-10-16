import 'package:de03/models/product.dart';
import 'package:de03/repositories/product.dart';
import 'package:de03/screens/detail.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';
class HomeScreen extends StatelessWidget {
  HomeScreen({super.key});
  final productRepository = GetIt.instance<ProductRepository>();
  @override
  Widget build(BuildContext context) {
    return SafeArea(child: Scaffold(
      body: Container(
        child: FutureBuilder<List<Product>>(
          future: productRepository.getProducts(),
          builder: (BuildContext context, AsyncSnapshot<List<Product>> snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              // Show a loading indicator while waiting for the data
              return const Center(child: CircularProgressIndicator());
            } else if (snapshot.hasError) {
              // Show an error message if there was an error fetching the data
              return Center(child: Text('Error: ${snapshot.error}'));
            } else {
              // Use the data to build the ListView
              List<Product> products = snapshot.data!;
              return ListView.builder(
                itemCount: products.length,
                itemBuilder: (BuildContext context, int index) {
                  Product product = products[index];
                  // Build your list item widget using the product data
                  return GestureDetector(
                    child: Container(
                      margin: EdgeInsets.only(top: 10),
                      child: Row(
                        children: [
                          SizedBox(width: 10,),
                          ClipRRect(
                            borderRadius: BorderRadius.circular(5),
                            child: Image(
                              image: NetworkImage(product.url),
                              width: 80,
                              height: 80,
                              fit: BoxFit.cover,
                            ),
                          ),
                          const SizedBox(width: 10,),
                          Column(
                            mainAxisAlignment: MainAxisAlignment.center,
                            crossAxisAlignment: CrossAxisAlignment.start,
                            children: [
                              Text(
                                product.title,
                                style: TextStyle(fontSize: 19, fontWeight: FontWeight.bold),
                              ),
                              Text('\$${product.price.toStringAsFixed(2)}'),
                            ],
                          ),
                        ],
                      ),
                    ),
                    onTap: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(
                          builder: (context) => DetailScreen(productId: product.id),
                        ),
                      );
                    },
                  );
                },
              );
            }
          },
        ),
      )
      )
    );
  }
}
