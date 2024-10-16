import 'package:de03/models/product.dart';
import 'package:flutter/material.dart';

class ProductRepository {
  List<Product> products = <Product>[
    Product(
      id: 1,
      name: 'iPhone 14',
      url: 'https://cdn.hoanghamobile.com/i/preview/Uploads/2023/09/13/iphone-15-black-pure-back-iphone-15-black-pure-front-2up-screen-usen.png',
      price: 134.5,
      description: 'Daily Cash is available in the United States when using Apple Card with Apple Pay (where available) at Exxon- or Mobil-branded pumps and attached convenience stores. To pay at the pump with Apple Pay, use either Exxon Mobil Rewards+ mobile app or contactless payment. Excludes purchases at third-party merchants, including independent car washes',
      color: Colors.white,
    ),
    Product(
      id: 2,
      name: 'Samsung Galaxy S22',
      url: 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2022/02/09/image-removebg-preview-11.png',
      price: 999.99,
      description: 'You can choose to direct Daily Cash to a Savings account or to an Apple Cash card. If you do not have either set up to receive your Daily Cash, it can be applied as statement credit. Apple Card and Savings accounts are issued or provided by Goldman Sachs Bank USA, Salt Lake City Branch, Member FDIC. The Apple Cash card is issued by Green Dot Bank, Member FDIC',
      color: Colors.white,
    ),
    Product(
      id: 3,
      name: 'Sony Playstation 5',
      url: 'https://thegioigames.vn/wp-content/uploads/2022/08/sony-playstation-5-console-b-4.jpg',
      price: 499.99,
      description: '. Actual posting times vary by merchant. Daily Cash is subject to exclusions, and additional details apply. See the Apple Card Customer Agreement for more information. Savings accounts are not available in American Samoa, Guam, Northern Mariana Islands, or US Minor Outlying Islands. To set up Savings, you must add Apple Card to Wallet on an iPhone or iPad that supports and has the latest version of iOS or iPadOS',
      color: Colors.white,
    ),
    Product(
      id: 4,
      name: 'MacBook Pro',
      url: 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/mbp-spacegray-select-202206?wid=1280&hei=1190&fmt=jpeg&qlt=90&.v=1664497359481',
      price: 1999.99,
      description: 'achs Bank USA, Salt Lake City Branch. Member FDIC. Apple Card Owners and Co‑Owners may individually apply for a S',
      color: Colors.white,
    ),
    Product(
      id: 5,
      name: 'Nike Air Max',
      url: 'https://product.hstatic.net/1000007560/product/giay_golf_nam_air_max_90_g_dx5999-162_nike__1__97825319ea414de7a9d463e150f453b5_1024x1024.jpg',
      price: 129.99,
      description: 'achs Bank USA, Salt Lake City Branch. Member FDIC. Apple Card Owners and Co‑Owners may individually apply for a S',
      color: Colors.white,
    ),
    Product(
      id: 6,
      name: 'Canon EOS R5',
      url: 'https://bizweb.dktcdn.net/thumb/large/100/451/485/products/sony-wf-1000xm5-jpeg.jpg?v=1686888478397',
      price: 2999.99,
      description: 'achs Bank USA, Salt Lake City Branch. Member FDIC. Apple Card Owners and Co‑Owners may individually apply for a S',
      color: Colors.white,
    ),
    Product(
      id: 7,
      name: 'Bose QuietComfort Earbuds',
      url: 'https://bizweb.dktcdn.net/thumb/large/100/451/485/products/sony-wf-1000xm5-jpeg.jpg?v=1686888478397',
      price: 279.99,
      description: 'achs Bank USA, Salt Lake City Branch. Member FDIC. Apple Card Owners and Co‑Owners may individually apply for a S',
      color: Colors.white,
    ),
    Product(
      id: 8,
      name: 'Nintendo Switch Lite',
      url: 'https://34gameshop.vn/wp-content/uploads/2023/03/03-1.png',
      price: 199.99,
      description: 'achs Bank USA, Salt Lake City Branch. Member FDIC. Apple Card Owners and Co‑Owners may individually apply for a S',
      color: Colors.white,
    ),
    Product(
      id: 9,
      name: 'Amazon Echo Dot (3rd Gen)',
      url: 'https://cdn-amz.woka.io/images/I/6182S7MYC2L._SR476,476_.jpg',
      price: 49.99,
      description: 'achs Bank USA, Salt Lake City Branch. Member FDIC. Apple Card Owners and Co‑Owners may individually apply for a S',
      color: Colors.white,
    ),
    Product(
      id: 10,
      name: 'GoPro HERO9 Black',
      url: 'https://cdn.vjshop.vn/camera-hanh-dong/gopro/gopro-11/anh-san-pham/gopro-hero-11-1-500x500.jpg',
      price: 349.99,
      description: 'achs Bank USA, Salt Lake City Branch. Member FDIC. Apple Card Owners and Co‑Owners may individually apply for a S',
      color: Colors.white,
    ),
    Product(
      id: 11,
      name: 'Adidas Ultraboost',
      url: 'https://cdn.runningshoesguru.com/wp-content/uploads/2023/03/Adidas-Ultraboost-Light-2-1.jpeg',
      price: 179.99,
      description: 'heel in your account are based on your posted account balance at the time of the estimate and do not include pending transactions or any other purchases you may make before the end',
      color: Colors.white,
    ),
  ];
  Future<List<Product>> fetchProducts() async {
    // Simulate fetching products from an external source (e.g., API, database)
    await Future.delayed(const Duration(milliseconds: 200));
    return products;
  }
}