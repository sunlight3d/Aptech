import 'package:flutter/material.dart';
import 'package:flutter_carousel_widget/flutter_carousel_widget.dart';

class CarouselSlider extends StatelessWidget {
  final List<Widget> slides;
  CarouselSlider({Key? key, required this.slides}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      child: FlutterCarousel(
        options: CarouselOptions(
          height: 200,
          viewportFraction: 1.0,
          enlargeCenterPage: false,
          autoPlay: true,
          enableInfiniteScroll: true,
          autoPlayInterval: const Duration(seconds: 2),
          slideIndicator: CircularWaveSlideIndicator(),
        ),
        items: slides,
      ),
      color: Colors.red,
    );
  }
}