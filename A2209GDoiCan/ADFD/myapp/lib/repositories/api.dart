import 'package:myapp/models/product.dart';

import '../models/cart_item.dart';

class Api {
  // Private constructor
  Api._();

  // Factory constructor
  factory Api() {
    return Api._();
  }
  List<Product> fakeProducts = [
    Product(
      id: 1,
      title: "Wireless Bluetooth Earbuds",
      url: "https://media.wired.com/photos/5f52a44bb555bc55dbcdf5a8/master/w_2560%2Cc_limit/Gear-Wireless-Bluetooth-1226031847.jpg",
      price: 59.99,
      reviews: 1284,
      specifications: [
        "Bluetooth 5.0",
        "20hrs battery life",
        "IPX5 waterproof",
        "Touch controls"
      ],
    ),
    Product(
      id: 2,
      title: "Smart Fitness Watch",
      url: "https://dam.mediacorp.sg/image/upload/s--ZD1MMipU--/f_auto,q_auto/c_fill,g_auto,h_622,w_830/v1/mediacorp/tdy/image/2023/03/23/20230323_istock_fitness_tracker_wearable.jpg?itok=RB9zy1mb",
      price: 129.99,
      reviews: 892,
      specifications: [
        "Heart rate monitor",
        "Sleep tracking",
        "50m water resistant",
        "7-day battery"
      ],
    ),
    Product(
      id: 3,
      title: "4K Ultra HD Smart TV",
      url: "https://down-vn.img.susercontent.com/file/vn-11134201-7ra0g-m8egvnh67adgbe",
      price: 699.99,
      reviews: 245,
      specifications: [
        "55-inch display",
        "HDR10+",
        "Smart OS with apps",
        "3 HDMI ports"
      ],
    ),
    Product(
      id: 4,
      title: "Electric Toothbrush",
      url: "https://icybeardental.com/cdn/shop/files/Electric_Toothbrush_Ice.jpg?v=1743796575&width=1280",
      price: 39.95,
      reviews: 1532,
      specifications: [
        "3 brushing modes",
        "2-week battery life",
        "Pressure sensor",
        "Includes 2 brush heads"
      ],
    ),
    Product(
      id: 5,
      title: "Portable Bluetooth Speaker",
      url: "https://media.wired.com/photos/668458d80c2402683d4823a4/master/w_960,c_limit/Sony-SRS-XB100-Bluetooth-Speaker-Reviewer-Photo-SOURCE-Ryan-Waniata.jpg",
      price: 79.50,
      reviews: 587,
      specifications: [
        "20W output",
        "15hr playtime",
        "IP67 dust/water proof",
        "Party pairing mode"
      ],
    ),
    Product(
      id: 6,
      title: "Ergonomic Office Chair",
      url: "https://m.media-amazon.com/images/I/71aGX3PevYL.jpg",
      price: 249.99,
      reviews: 342,
      specifications: [
        "Adjustable height",
        "Lumbar support",
        "Breathable mesh",
        "360° swivel"
      ],
    ),
    Product(
      id: 7,
      title: "Air Fryer Oven",
      url: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSv3pGBNoxu6Ltl_dOTLZPmuyIdxQ9UPEUKMg&s",
      price: 119.99,
      reviews: 876,
      specifications: [
        "5.8QT capacity",
        "7 cooking functions",
        "Digital touchscreen",
        "Auto shut-off"
      ],
    ),
    Product(
      id: 8,
      title: "Gaming Laptop",
      url: "https://i.pcmag.com/imagery/reviews/00ujXpkUDw1FIczR1gVekQk-1.fit_lim.size_919x518.v1722353639.jpg",
      price: 1499.99,
      reviews: 156,
      specifications: [
        "RTX 3060 GPU",
        "16GB RAM",
        "1TB SSD",
        "144Hz display"
      ],
    ),
    Product(
      id: 9,
      title: "Noise Cancelling Headphones",
      url: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_LbwemxTzA7F_0NwrT_FrXxsYkphCFPaSsA&s",
      price: 199.99,
      reviews: 2103,
      specifications: [
        "Active noise cancellation",
        "30hr battery",
        "Foldable design",
        "Built-in mic"
      ],
    ),
    Product(
      id: 10,
      title: "Robot Vacuum Cleaner",
      url: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfjp8tnqO1HYN1_-VN2dTWnSNR51vvq75RiA&s",
      price: 299.00,
      reviews: 432,
      specifications: [
        "Smart mapping",
        "Self-charging",
        "App control",
        "Works with Alexa"
      ],
    ),
  ];
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
  Future<List<Product>> fetchProducts() async {
    // Simulate API delay
    await Future.delayed(const Duration(seconds: 10));
    return fakeProducts;
  }
  Future<Product> getProductDetail(int id) async {
    // Simulate API delay
    await Future.delayed(const Duration(seconds: 5));
    return fakeProducts.where((item) => item.id == id).first;
  }
}