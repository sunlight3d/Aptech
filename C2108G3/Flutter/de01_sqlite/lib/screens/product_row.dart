import 'package:flutter/material.dart';
import 'package:productapp/models/product.dart';

class ProductRow extends StatelessWidget {
  Product product;
  ProductRow({super.key, required this.product});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        SizedBox(height: 5,),
        Container(
          padding: EdgeInsets.symmetric(horizontal: 10),
          child: Row(
            children: [
              Expanded(child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(product.name, style: TextStyle(fontSize: 18),),
                  SizedBox(height: 20,),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Text(product.code, style: TextStyle(fontSize: 18),),
                      Spacer(),
                      Text(product.price.toString(), style: TextStyle(fontSize: 18),),
                      Spacer()
                    ],
                  )
                ],
              ),),
              Container(
                color: Color(int.parse(product.hexValue!.substring(1), radix: 16) + 0xFF000000),
                padding: EdgeInsets.all(10),
                height: 80,
                width: 80,
              )
            ],
          ),
        ),
        SizedBox(height: 10,),
        Container(
          height: 1,
          width: MediaQuery.of(context).size.width - 20,
          color: Colors.black26,
        ),
        SizedBox(height: 5,)
      ],
    );
  }
}
