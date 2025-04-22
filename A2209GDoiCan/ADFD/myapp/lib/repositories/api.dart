import '../models/cart_item.dart';

class Api {
  // Private constructor
  Api._();

  // Factory constructor
  factory Api() {
    return Api._();
  }

  // Method to fetch cart items
  Future<List<CartItem>> fetchCartItems() async {
    // Simulate API delay
    await Future.delayed(const Duration(seconds: 8));

    // Return mock data
    return [
      CartItem(
        name: 'Apple Juice 11',
        description: 'description esneueu wehwuhuehwuhewhuehweu',
        price: 12.65,
        imageUrl: 'https://cdn.pixabay.com/photo/2023/09/04/23/58/woman-8233937_1280.jpg',
      ),
      CartItem(
        name: 'Apple Juice 22',
        description: 'description esneueu wehwuhuehwuhewhuehweu',
        price: 12.65,
        imageUrl: 'https://cdn.pixabay.com/photo/2023/09/04/23/58/woman-8233937_1280.jpg',
      ),
      CartItem(
        name: 'Apple Juice 33',
        description: 'description esneueu wehwuhuehwuhew edfjndujtgfh udh he huehweu',
        price: 12.65,
        imageUrl: 'https://cdn.pixabay.com/photo/2023/09/04/23/58/woman-8233937_1280.jpg',
      ),
      CartItem(
        name: 'Apple Juice 44',
        description: 'description esneueu wehwuhuehwuhew edfjndujtgfh udh he huehweu',
        price: 13.65,
        imageUrl: 'https://cdn.pixabay.com/photo/2023/09/04/23/58/woman-8233937_1280.jpg',
      ),
    ];
  }
}