import 'package:de03/models/product.dart';
import 'package:de03/repositories/product.dart';
import 'package:de03/widgets/color_circle.dart';
import 'package:de03/widgets/header.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

class DetailScreen extends StatefulWidget {
  final int productId;
  DetailScreen({super.key, required this.productId});

  @override
  State<DetailScreen> createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  final productRepository = GetIt.instance<ProductRepository>();
  final List<Color> _colors = [
    Colors.purple,Colors.deepOrange, Colors.blue
  ];
  @override
  void initState() {
    super.initState();
    //productRepository.findById(widget.productId);
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Header(),
            FutureBuilder<Product>(
              future: productRepository.findById(widget.productId),
              builder: (BuildContext context, AsyncSnapshot<Product> snapshot){
                if (snapshot.connectionState == ConnectionState.waiting) {
                  // Show a loading indicator while waiting for the data
                  return const Center(child: CircularProgressIndicator());
                  } else if (snapshot.hasError) {
                  // Show an error message if there was an error fetching the data
                  return Center(child: Text('Error: ${snapshot.error}'));
                } else {
                  Product product = snapshot.data!;
                  return Container(
                    child: Column(
                      children: [
                        ClipRRect(
                          borderRadius: BorderRadius.circular(5),
                          child: Image(
                            image: NetworkImage(product.url),
                            width: 200,
                            height: 200,
                            fit: BoxFit.cover,
                          ),
                        ),
                        SizedBox(height: 10,),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Text(product.title, style: TextStyle(fontWeight: FontWeight.bold),),
                            Expanded(child: Container()),
                            Text('\$${product.price}' ),
                          ],
                        ),
                        Row(
                          children: _colors.map((color) => ColorCircle(color: color)).toList(),
                        )
                      ],
                    ),
                  );
                }
            }),
          ],
        ),
      ),
    );
  }
}
