import 'package:de03/models/product.dart';
import 'package:de03/repositories/product_repository.dart';
import 'package:de03/screens/detail_screen.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

class HomeScreen extends StatelessWidget {
  const HomeScreen({super.key});
  //https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/1886_Starley_%27Rover%27_Safety_Cycle_British_Motor_Museum_09-2016_%2829928044262%29.jpg/1920px-1886_Starley_%27Rover%27_Safety_Cycle_British_Motor_Museum_09-2016_%2829928044262%29.jpg
  @override
  Widget build(BuildContext context) {
    final productRepository = GetIt.instance<ProductRepository>();
    return Scaffold(
      body: SafeArea(
        child: FutureBuilder(
          future: productRepository.fetchProducts(),
          builder: (BuildContext context, AsyncSnapshot<List<Product>> snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
            return CircularProgressIndicator(); // Show a progress indicator while loading
            } else if (snapshot.hasError) {
            return Text('Error: ${snapshot.error}'); // Show an error message if an error occurred
            } else {
              List<Product> products = snapshot.data!;
              return Container(
                child: ListView.builder(
                    itemCount: products.length,
                    itemBuilder: (BuildContext context, int index) {
                      Product selectedProduct = products[index];
                      return InkWell(
                        child: Container(
                          padding: EdgeInsets.symmetric(horizontal: 10, vertical: 5),
                          child: Row(
                            children: [
                              ClipRRect(
                                borderRadius: BorderRadius.all(Radius.circular(10)),
                                child: Image.network(
                                  selectedProduct.url,
                                  width: 100,
                                  height: 100,
                                  fit: BoxFit.cover,
                                ),
                              ),
                              SizedBox(width: 10,),
                              Column(
                                mainAxisAlignment: MainAxisAlignment.start,
                                crossAxisAlignment: CrossAxisAlignment.start,
                                children: [
                                  Text(selectedProduct.name,style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),),
                                  SizedBox(height: 10,),
                                  Text('\$'+'${selectedProduct.price}',style: TextStyle(fontSize: 16),),
                                ],
                              )
                            ],
                          ),
                        ),
                        onTap: () {
                          Navigator.of(context).push(
                            MaterialPageRoute(
                              builder: (context) => DetailScreen(product: selectedProduct),
                            ),
                          );
                        },
                      );
                    }),
              );
            }
          }
        ),
      ),
    );
  }
}
