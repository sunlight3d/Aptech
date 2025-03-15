import 'package:app03062025/models/product.dart';
import 'package:flutter/material.dart';

class ProductListScreen extends StatefulWidget {
  const ProductListScreen({super.key});

  @override
  State<ProductListScreen> createState() => _ProductListScreenState();
}

class _ProductListScreenState extends State<ProductListScreen> {
  List<Product> products = [
    Product(
        name: 'NXX juds 123',
        url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfeeazugzVRRy-xKO1nZpzhfxrEk9mHH0xXA&s',
        description: 'Dry clean, cyclo filter, low energy comsumtion',
        rate: 4.34,
        numberOfReviews: 20),
    Product(
        name: 'My product ab 876772',
        url: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxfyEMdCEh8epBW48z9dtegb04iYnMP7oj4Q&s',
        description: 'Dry clean, cyclo filter, low energy comsumtion',
        rate: 3.4,
        numberOfReviews: 87)
  ];
  Widget _generateStars(double rate) {
    List<Widget> result = <Widget>[];
    //sao sang
    for(int i = 0; i < rate.toInt(); i++) {
      result.add(Icon(Icons.star, color: Colors.amber,size: 20,));
    }
    if(rate - rate.toInt() > 0) {
      result.add(Icon(Icons.star_half, color: Colors.amber, size: 20,));
    }
    int currentIndex = result.length;
    //sao toi
    for(int i = currentIndex; i < 5; i++) {
      result.add(Icon(Icons.star, size: 20, color: Colors.black26,));
    }
    return Row(
      children: result,
    );
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView.builder(itemBuilder: (BuildContext context, int index) {
        Product product = products[index];
        return Container(
          padding: EdgeInsets.symmetric(horizontal: 10),
          child: Row(
            children: [
              Image.network(
                  product.url,
                width: 100,
                height: 100,
              ),
              SizedBox(width: 10,),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text('LG vk 12345'.toUpperCase(), style: TextStyle(color: Colors.blue, fontSize: 16),),
                  ...product.description!.split(',').map((String item) {
                    return Text(item);
                  }),
                  _generateStars(product.rate ?? 0),
                  Text((product.numberOfReviews ?? 0)  > 1 ?
                    '${product.numberOfReviews} reviews' : '${product.numberOfReviews} review')
                ],
              ),
              Column(
                children: [

                ],
              )
            ],
          ),
        );
      },
      itemCount: products.length,),
    );
  }
}
