import 'package:de01/models/product.dart';
import 'package:flutter/material.dart';

class ProductRow extends StatelessWidget {
  final Product product;
  const ProductRow({super.key, required this.product});

  @override
  Widget build(BuildContext context) {
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
              Text(product.code, style: TextStyle(fontSize: 16),),
              Text(product.name, style: TextStyle(fontSize: 16),),
              Container(
                width: 60,height: 60,
                color: Color(product.hexValue),
                //color: Colors.red,
              )
            ],
          ),
          SizedBox(height: 10,),
          Container(
            height: 1,
            color: Colors.grey,
          )
        ],
      ),
    );;
  }
}
