
import 'package:de03/api/product_api.dart';
import 'package:de03/main.dart';
import 'package:de03/models/product.dart';
import 'package:flutter/material.dart';
import 'package:flutter_svg/flutter_svg.dart';

class DetailPage extends StatelessWidget {
  final int productId;
  DetailPage({Key? key, required this.productId}) : super(key: key);
  Product? product;
  final productApi = getIt.get<ProductApi>();

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(
        title: const Text(
          "Detail",
          style: TextStyle(
            fontSize: 18,
            fontWeight: FontWeight.bold,
            color: Colors.black,
          ),
        ),
        backgroundColor: Colors.white,
        centerTitle: true,
        leading: GestureDetector(
          onTap: () {
            // Navigate back to the previous screen (List of Products)
            Navigator.pop(context);
          },
          child: Container(
            margin: const EdgeInsets.all(10),
            alignment: Alignment.center,
            decoration: BoxDecoration(
              color: Color(0xffF7F8F8),
              borderRadius: BorderRadius.circular(10),
            ),
            child: SvgPicture.asset(
              'assets/icons/Arrow.svg',
              height: 20,
              width: 20,
            ),
          ),
        ),
        actions: [
          Container(
            margin: const EdgeInsets.all(10),
            alignment: Alignment.center,
            decoration: BoxDecoration(
              color: const Color(0xffF7F8F8),
              borderRadius: BorderRadius.circular(20),
            ),
            child: SvgPicture.asset(
              'assets/icons/dots.svg',
              height: 20,
              width: 20,
            ),
          ),
        ],
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: SingleChildScrollView(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              FutureBuilder<Product?>(
                future: productApi.getProductById(this.productId),
                builder: (context, snapshot) {
                  if (snapshot.connectionState == ConnectionState.waiting) {
                    // Show a loading indicator while waiting for the data
                    return Center(child: CircularProgressIndicator());
                  } else if (snapshot.hasError) {
                    // Show an error message if an error occurred
                    return Center(child: Text('Error: ${snapshot.error}'));
                  } else {
                    product = snapshot.data as Product;
                    if(product == null) {
                      return Center(child: Text('Cannot find this product'),);
                    }
                    // Display the products list when the data is available
                    return Column(
                      children: [
                        Container(
                          width: double.infinity,
                          margin: const EdgeInsets.only(top: 30, bottom: 20),
                          height: 200,
                          decoration: BoxDecoration(
                            image: DecorationImage(
                              image: AssetImage(product?.imageUrl ?? ''),
                              fit: BoxFit.contain,
                            ),
                          ),
                        ),
                        SizedBox(
                          height: 30,
                        ),
                        Padding(
                          padding: EdgeInsets.all(16.0),
                          child: Row(
                            children: [
                              // Phần tên sản phẩm
                              Expanded(
                                child: Text(
                                  product?.title ?? '',
                                  style:
                                  TextStyle(fontSize: 25, fontWeight: FontWeight.bold),
                                ),
                              ),

                              // Phần giá và icon chọn màu

                              Text(
                                '\$${product?.price ?? 0}',
                                style: TextStyle(fontSize: 20, color: Colors.lightBlue),
                              ),
                              SizedBox(height: 8),
                              // Icon chọn màu (thay đổi biểu tượng và kích thước tùy thuộc vào thiết kế của bạn)
                            ],
                          ),
                        ),
                        const Padding(
                          padding: EdgeInsets.all(16.0),
                          child: Row(
                            children: [
                              Icon(Icons.circle, size: 30, color: Colors.red),
                              Icon(Icons.circle, size: 30, color: Colors.black),
                              Icon(Icons.circle,
                                  size: 30, color: Color.fromARGB(255, 30, 72, 210)),
                            ],
                          ),
                        ),
                        const SizedBox(height: 30),

                        // Mô tả sản phẩm
                        Text(
                          //'SizedBox trong Flutter có tác dụng tạo ra một hộp có kích thước cố định, được sử dụng để thêm khoảng trống hoặc đặt kích thước cho các widget bên trong nó. Nó có một số tính năng quan trọng:',
                          product?.title ?? '',
                          style: TextStyle(fontSize: 14),
                        ),
                      ],
                    );
                  }
                },
              ),
              Container(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Container(
                      margin: const EdgeInsets.only(bottom: 50),
                      child: Column(
                        children: [
                          IconButton(
                            onPressed: () {},
                            icon: SvgPicture.asset(
                              'icons/cart.svg',
                              height: 50,
                              width: 50,
                            ),
                          ),
                          const SizedBox(height: 8),
                          const Text(
                            '+ Add to Cart',
                            style: TextStyle(fontSize: 14, fontWeight: FontWeight.w600),
                          ),
                        ],
                      ),
                    )
                  ],
                )
              )
            ],
          ),
        ),
      ),
      floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,
    );
  }

}
