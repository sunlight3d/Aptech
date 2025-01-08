import 'package:flutter/material.dart';
import 'package:myapp/models/product.dart';


class ProductItem extends StatelessWidget {
  const ProductItem({super.key, required this.product});

  final Product product;

  @override
  Widget build(BuildContext context) {
    return ListTile(
      leading: Image.network(
        product.image,
        width: 50,
        height: 50,
        fit: BoxFit.cover,
      ),
      title: Text(product.name, style: const TextStyle(fontWeight: FontWeight.bold)),
      subtitle: Text(product.description, maxLines: 2, overflow: TextOverflow.ellipsis),
      trailing: Text('\$${product.price}', style: const TextStyle(color: Colors.green)),
    );
  }
}
