import 'package:flutter/material.dart';
import 'package:myapp/models/product.dart';

class GridItem extends StatelessWidget {
  Product product;
  final GestureTapCallback? onTap;
  GridItem({super.key, required this.product, this.onTap});

  @override
  Widget build(BuildContext context) {

    return InkWell(
      child: Container(
        margin: EdgeInsets.all(5),
        decoration: BoxDecoration(
          borderRadius: BorderRadius.all(Radius.circular(10)),
          border: Border.all(
            color: Colors.green,
            width: 1,
          ),
        ),
        child: Padding(
          padding: EdgeInsets.all(10),
          child: SingleChildScrollView( // ✅ Bọc đây
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: [
                    Text('\$${product.price}'),
                  ],
                ),
                Image.network(
                  product.url,
                  width: 100,
                  height: 100,
                ),
                Text(
                  product.title,
                  style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 18,
                    color: Colors.green,
                  ),
                ),
                SizedBox(height: 5),
                ...product.specifications.map((spec) => Text(spec))
                // thêm bao nhiêu dòng cũng được
              ],
            ),
          ),
        ),
      ),
      onTap: onTap,
    );

  }
}
