import 'package:flutter/material.dart';
import 'package:myapp/repositories/api.dart';
import 'package:myapp/widgets/cartitem_card.dart';
import 'models/cart_item.dart';

class CartList extends StatefulWidget {
  const CartList({super.key});

  @override
  State<CartList> createState() => _CartListState();
}

class _CartListState extends State<CartList> {
  final Api _api = Api();
  late Future<List<CartItem>> _futureCartItems;

  @override
  void initState() {
    super.initState();
    _futureCartItems = _api.fetchCartItems();
  }

  void _increaseQuantity(int index, List<CartItem> items) {
    setState(() {
      items[index].quantity++;
    });
  }

  void _decreaseQuantity(int index, List<CartItem> items) {
    setState(() {
      if (items[index].quantity > 1) {
        items[index].quantity--;
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: FutureBuilder<List<CartItem>>(
        future: _futureCartItems,
        builder: (context, snapshot) {
          // Loading state
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(
              child: CircularProgressIndicator(),
            );
          }

          // Error state
          if (snapshot.hasError) {
            return Center(
              child: Text('Error: ${snapshot.error}'),
            );
          }

          // Success state
          if (snapshot.hasData) {
            final cartItems = snapshot.data!;
            return ListView.builder(
              itemCount: cartItems.length,
              itemBuilder: (context, index) {
                return CartItemCard(
                  item: cartItems[index],
                  onIncrease: () => _increaseQuantity(index, cartItems),
                  onDecrease: () => _decreaseQuantity(index, cartItems),
                );
              },
            );
          }

          // Empty state
          return const Center(
            child: Text('No items found'),
          );
        },
      ),
    );
  }
}