import 'package:flutter/material.dart';
import 'package:myapp/models/product.dart';
import 'package:myapp/services/utils.dart'; // Import file utils.dart

class ProductItem extends StatelessWidget {
  const ProductItem({super.key, required this.product});

  final Product product;

  // Hàm hiển thị sao dựa trên rating
  Widget buildRatingStars(double rating) {
    int fullStars = rating.floor();
    double remainder = rating - fullStars;
    bool hasHalfStar = remainder >= 0.5;

    return Row(
      mainAxisSize: MainAxisSize.min, // Không cho phép chiếm toàn bộ hàng ngang
      children: [
        for (int i = 0; i < fullStars; i++)
          const Icon(Icons.star, color: Colors.amber, size: 16.0),
        if (hasHalfStar)
          const Icon(Icons.star_half, color: Colors.amber, size: 16.0),
        for (int i = 0; i < 5 - fullStars - (hasHalfStar ? 1 : 0); i++)
          const Icon(Icons.star_border, color: Colors.amber, size: 16.0),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Padding(
          padding: const EdgeInsets.symmetric(vertical: 8.0, horizontal: 12.0),
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // Hình ảnh sản phẩm
              ClipRRect(
                borderRadius: BorderRadius.circular(8.0),
                child: Image.network(
                  product.image.trim().isEmpty
                      ? 'https://bizflyportal.mediacdn.vn/bizflyportal/459/347/2020/06/02/17/37/70515910726734841.jpg'
                      : product.image,
                  width: 100,
                  height: 100,
                  fit: BoxFit.cover,
                ),
              ),
              const SizedBox(width: 12.0),

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
                        color: Colors.black87,
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
                          formatCurrency(product.price),
                          style: const TextStyle(
                            fontSize: 16.0,
                            fontWeight: FontWeight.bold,
                            color: Colors.green,
                          ),
                        ),
                        const SizedBox(width: 8.0),
                        if (product.oldPrice != 0)
                          Text(
                            formatCurrency(product.oldPrice),
                            style: const TextStyle(
                              fontSize: 14.0,
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

                        // Thêm `Expanded` để tránh lỗi tràn
                        Expanded(
                          child: Text(
                            '(${product.totalRatings}) đánh giá',
                            style: const TextStyle(
                              fontSize: 12.0,
                              color: Colors.grey,
                            ),
                            overflow: TextOverflow.ellipsis, // Ngăn tràn dòng
                          ),
                        ),

                        const SizedBox(width: 10.0),

                        const Icon(Icons.shopping_cart, color: Colors.grey, size: 16.0),
                        const SizedBox(width: 4.0),

                        // Thêm `Expanded` để tránh lỗi tràn
                        Expanded(
                          child: Text(
                            '${product.totalSold} đã bán',
                            style: const TextStyle(
                              fontSize: 12.0,
                              color: Colors.grey,
                            ),
                            overflow: TextOverflow.ellipsis, // Ngăn tràn dòng
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

        // Gạch ngang phân cách sản phẩm
        const Divider(
          color: Colors.grey, // Màu nhẹ nhàng
          thickness: 0.5, // Độ dày
          indent: 12.0, // Cách lề trái
          endIndent: 12.0, // Cách lề phải
        ),
      ],
    );
  }
}
