import 'package:de03/models/my_color.dart';
import 'package:de03/models/product.dart';
import 'package:de03/widgets/circle_container.dart';
import 'package:flutter/material.dart';

class DetailScreen extends StatefulWidget {
  final Product product;
  DetailScreen({
    super.key,
    required this.product
  });

  @override
  State<DetailScreen> createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  int _selectedColorIndex = 0;
  List<MyColor> fakedColors = [
    MyColor(color: Color(0xffb74093),isSelected: true),
    MyColor(color: Color(0xFF00FFFA),isSelected: false),
    MyColor(color: Color(0xFFF8485E),isSelected: false)
  ];
  @override
  Widget build(BuildContext context) {
    return SafeArea(child: Scaffold(
      body: Container(
        padding: EdgeInsets.symmetric(horizontal: 10),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            //Header
            Container(
              height: 70,
              width: double.infinity,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  GestureDetector(
                    child: Container(
                      child: Icon(
                        Icons.arrow_back_ios_new,
                        color: Colors.black,
                        size: 24.0,
                      ),
                      padding: EdgeInsets.all(10),
                    ),
                    onTap: () {
                      Navigator.pop(context);
                    },
                  ),
                  Text('Detail product'),
                  GestureDetector(
                    child: Container(
                      child: Icon(
                        Icons.heart_broken_rounded,
                        color: Colors.black,
                        size: 24.0,
                      ),
                      padding: EdgeInsets.all(10),
                    ),
                    onTap: () {

                    },
                  ),
                ],
              ),
            ),
            Image(
              image: AssetImage(widget.product.imageName), // Assuming image path is correct
              width: 200,
              height: 200,
              fit: BoxFit.cover,
            ),
            SizedBox(height: 10,),
            Row(
              children: [
                Text(widget.product.title, style: TextStyle(fontSize: 14, fontWeight: FontWeight.bold),),
                Expanded(child: Container()),
                Text('\$${widget.product.price}', style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),),
              ],
            ),
            Text(widget.product?.subTitle ?? ''),
            Row(
              children: fakedColors.map((e) {
                return CircleContainer(isSelected: e.isSelected, color: e.color);
              }).toList(),
            )
          ],

        ),
      ),
    ));
  }
}
