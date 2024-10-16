import 'package:de03/api/product_api.dart';
import 'package:de03/main.dart';
import 'package:de03/models/product.dart';
import 'package:de03/pages/detail.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/svg.dart';

class ProductsListPage extends StatelessWidget {
  List<Product> products = [];
  final productApi = getIt.get<ProductApi>();
  ProductsListPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: appBar(),
      body: Column(
        children: [
          Container(
            margin: EdgeInsets.only(left: 20, top: 40, right: 20),
            decoration: BoxDecoration(
              boxShadow: [
                BoxShadow(
                  color: Color(0xff1D1617).withOpacity(0.11),
                  blurRadius: 40,
                  spreadRadius: 0.0,
                )
              ],
            ),
            child: TextField(
              decoration: InputDecoration(
                filled: true,
                fillColor: Colors.white,
                contentPadding: EdgeInsets.all(15),
                prefixIcon: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: SvgPicture.asset("assets/icons/Search.svg"),
                ),
                suffixIcon: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: SvgPicture.asset("assets/icons/filter.svg"),
                ),
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(15),
                  borderSide: BorderSide.none,
                ),
              ),
            ),
          ),
          FutureBuilder<List<Product>>(
            future: productApi.getProducts(),
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.waiting) {
                // Show a loading indicator while waiting for the data
                return Center(child: CircularProgressIndicator());
              } else if (snapshot.hasError) {
                // Show an error message if an error occurred
                return Center(child: Text('Error: ${snapshot.error}'));
              } else {
                // Display the products list when the data is available
                final List<Product> products = snapshot.data!;
                return Expanded(
                  child: ListView.builder(
                    itemCount: products.length,
                    itemBuilder: (context, index) {
                      return GestureDetector(
                        onTap: () {
                          // Navigate to the DetailPage when a product is tapped
                          Navigator.push(
                            context,
                            MaterialPageRoute(
                              builder: (context) =>
                                  DetailPage(productId: products[index].id ?? 0),
                            ),
                          );
                        },
                        child: Container(
                          width: 100,
                          height: 100,
                          margin: const EdgeInsets.only(top: 16, bottom: 16),
                          child: ListTile(
                            title: Text(
                              products[index].title,
                              maxLines: 1,
                            ),
                            subtitle:
                            Text('\$${products[index].price.toStringAsFixed(2)}'),
                            leading: Image.network(
                              products[index].imageUrl,
                              width: 70.0,
                              height: 100.0,
                              fit: BoxFit.contain,
                            ),
                          ),
                        ),
                      );
                    },
                  ),
                );
              }
            },
          )

        ],
      ),
    );
  }

  AppBar appBar() {
    return AppBar(
      title: const Text(
        "Products",
        style: TextStyle(
          fontSize: 18,
          fontWeight: FontWeight.bold,
          color: Colors.black,
        ),
      ),
      backgroundColor: Colors.white,
      centerTitle: true,
      // leading: Container(
      //   margin: const EdgeInsets.all(10),
      //   alignment: Alignment.center,
      //   decoration: BoxDecoration(
      //     color: Color(0xffF7F8F8),
      //     borderRadius: BorderRadius.circular(10),
      //   ),
      //   child: SvgPicture.asset(
      //     'assets/icons/Arrow.svg',
      //     height: 20,
      //     width: 20,
      //   ),
      // ),
      actions: [
        Container(
          margin: const EdgeInsets.all(10),
          alignment: Alignment.center,
          decoration: BoxDecoration(
            color: Color(0xffF7F8F8),
            borderRadius: BorderRadius.circular(20),
          ),
          child: SvgPicture.asset(
            'assets/icons/dots.svg',
            height: 20,
            width: 10,
          ),
        ),
      ],
    );
  }
}
