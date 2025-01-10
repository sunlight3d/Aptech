import 'package:flutter/material.dart';
import 'package:myapp/models/product.dart';


class ProductItem extends StatelessWidget {
  const ProductItem({super.key, required this.product});

  final Product product;

  @override
  Widget build(BuildContext context) {
    if(product.id == 78) {
      print('haha');
    }
    return ListTile(
      leading: Image.network(
        product.image.trim().length == 0 ? 'https://bizflyportal.mediacdn.vn/bizflyportal/459/347/2020/06/02/17/37/70515910726734841.jpg' : product.image,
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
