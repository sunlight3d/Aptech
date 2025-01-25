import 'package:flutter/material.dart';
import 'package:myapp/models/product.dart';
import 'package:flutter/material.dart';
import 'package:myapp/models/product.dart';
import 'package:myapp/services/utils.dart'; // Import file utils.dart

class ProductItem extends StatelessWidget {
  const ProductItem({super.key, required this.product});

  final Product product;

  // Hàm hiển thị sao dựa trên rating
  Widget buildRatingStars(double rating) {
    int fullStars = rating.floor(); // Số sao đầy
    double remainder = rating - fullStars; // Phần dư để xác định sao nửa
    bool hasHalfStar = remainder >= 0.5; // Có sao nửa hay không

    return Row(
      children: [
        // Hiển thị sao đầy
        for (int i = 0; i < fullStars; i++)
          const Icon(
            Icons.star,
            color: Colors.amber,
            size: 16.0,
          ),
        // Hiển thị sao nửa (nếu có)
        if (hasHalfStar)
          const Icon(
            Icons.star_half,
            color: Colors.amber,
            size: 16.0,
          ),
        // Hiển thị sao rỗng (nếu cần)
        for (int i = 0; i < 5 - fullStars - (hasHalfStar ? 1 : 0); i++)
          const Icon(
            Icons.star_border,
            color: Colors.amber,
            size: 16.0,
          ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return InkWell(
      onTap: () {
        // Xử lý khi người dùng nhấn vào sản phẩm
        print('Product ${product.id} clicked');
      },
      child: Card(
        margin: const EdgeInsets.all(8.0),
        elevation: 1.0,
        child: Padding(
          padding: const EdgeInsets.all(12.0),
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Hình ảnh sản phẩm
              Container(
                width: 100,
                height: 100,
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(8.0),
                  image: DecorationImage(
                    image: NetworkImage(
                      product.image.trim().isEmpty
                          ? 'https://bizflyportal.mediacdn.vn/bizflyportal/459/347/2020/06/02/17/37/70515910726734841.jpg'
                          : product.image,
                    ),
                    fit: BoxFit.cover,
                  ),
                ),
              ),
              const SizedBox(width: 12.0), // Khoảng cách giữa ảnh và thông tin

              // Thông tin sản phẩm
              Expanded(
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    // Tên sản phẩm
                    Text(
                      product.name,
                      style: const TextStyle(
                        fontSize: 16.0,
                        fontWeight: FontWeight.bold,
                      ),
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    const SizedBox(height: 4.0),

                    // Mô tả sản phẩm
                    Text(
                      product.description,
                      style: const TextStyle(
                        fontSize: 14.0,
                        color: Colors.grey,
                      ),
                      maxLines: 2,
                      overflow: TextOverflow.ellipsis,
                    ),
                    const SizedBox(height: 8.0),

                    // Giá sản phẩm
                    Row(
                      children: [
                        Text(
                          formatCurrency(product.price), // Sử dụng hàm formatCurrency
                          style: const TextStyle(
                            fontSize: 16.0, // Giảm kích thước font
                            fontWeight: FontWeight.bold,
                            color: Colors.green,
                          ),
                        ),
                        const SizedBox(width: 8.0),
                        if (product.oldPrice != 0)
                          Text(
                            formatCurrency(product.oldPrice), // Sử dụng hàm formatCurrency
                            style: const TextStyle(
                              fontSize: 14.0, // Giảm kích thước font
                              color: Colors.red,
                              decoration: TextDecoration.lineThrough,
                            ),
                          ),
                      ],
                    ),
                    const SizedBox(height: 8.0),

                    // Đánh giá và số lượng bán
                    Row(
                      children: [
                        // Hiển thị sao đánh giá
                        buildRatingStars(product.rating),
                        const SizedBox(width: 8.0),
                        Text(
                          '(${product.totalRatings})', // Hiển thị số lượng đánh giá
                          style: const TextStyle(
                            fontSize: 12.0, // Giảm kích thước font
                            color: Colors.grey,
                          ),
                        ),
                        const SizedBox(width: 16.0),
                        Icon(
                          Icons.shopping_cart,
                          color: Colors.grey,
                          size: 16.0,
                        ),
                        const SizedBox(width: 4.0),
                        Text(
                          '${product.totalSold} sold',
                          style: const TextStyle(
                            fontSize: 12.0, // Giảm kích thước font
                            color: Colors.grey,
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}