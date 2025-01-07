import 'package:flutter/material.dart';

class ProductItem extends StatelessWidget {
  const ProductItem({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      height: 110,
      child: Row(
        children: [
          Container(
            width: 100,
            height: 100,
            child: Image.network('https://media.gettyimages.com/id/184276818/photo/red-apple.jpg?s=1024x1024&w=gi&k=20&c=A4t3PjOv3tM41LebBXXRFIB7liIazUNO-QlAQPHaugI='),
          ),
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text('This is title', style: TextStyle(fontWeight: FontWeight.bold, fontSize:  18,)),
              Text('paid on..', style: TextStyle(fontSize:  14,)),
            ],
          ),
          Expanded(child: Container(),),
          Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.end,
            children: [
              Text('\$500', style: TextStyle(fontSize:  16,)),
              Container(
                padding: EdgeInsets.all(8), // Khoảng cách giữa Text và border
                decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(5), // Góc bo tròn
                  border: Border.all(
                    color: Colors.orange, // Màu viền
                    width: 2, // Độ dày viền
                  ),
                ),
                child: Center(
                  child: Text(
                    'Overdue',
                    style: TextStyle(
                      fontSize: 16, // Cỡ chữ
                      fontWeight: FontWeight.bold, // Đậm chữ
                    ),
                  ),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
