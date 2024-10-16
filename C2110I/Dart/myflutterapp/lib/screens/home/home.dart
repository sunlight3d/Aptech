import 'package:flutter/material.dart';
import 'package:myflutterapp/screens/home/carousel_slider.dart';
import 'package:myflutterapp/widgets/text_icon.dart';
import 'package:cached_network_image/cached_network_image.dart';

class Home extends StatefulWidget {
  const Home({super.key});

  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  late List<Widget> _slides;
  List<String> fakeUrls = [
    "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/640px-Image_created_with_a_mobile_phone.png",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Rhododentron_anamalai_shola_national_park1.JPG/320px-Rhododentron_anamalai_shola_national_park1.JPG",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Shiitake_mushroom.jpg/320px-Shiitake_mushroom.jpg",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Componentes.JPG/640px-Componentes.JPG",
    "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/MOS6581_chtaube061229.jpg/640px-MOS6581_chtaube061229.jpg"
  ];
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _slides = fakeUrls.map((imageUrl) => Container(
      padding: EdgeInsets.symmetric(vertical: 10),
      child: Center(
        child: AspectRatio(
          aspectRatio: 16 / 9, // Tỉ lệ 16:9
          child: ClipRRect(
            borderRadius: BorderRadius.circular(10.0), // Bo góc
            child: CachedNetworkImage(
              imageUrl: imageUrl,
              placeholder: (context, url) => Center(
                child: CircularProgressIndicator(), // Hiển thị loading
              ),
              errorWidget: (context, url, error) => Icon(Icons.error), // Xử lý khi có lỗi
              fit: BoxFit.fitWidth, // Để ảnh nằm vừa kích thước của AspectRatio
            ),
          ),
        ),
      ),
    )).toList();
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Column(
          children: [
            Container(
              height: 60,
              color: Colors.blue,
              child: Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  SizedBox(width: 10,),
                  Expanded(
                    child: Container(
                      child: TextField(
                        decoration: InputDecoration(
                          hintText: 'Tìm kiếm...',
                          contentPadding: EdgeInsets.symmetric(vertical: 10.0, horizontal: 10.0),
                          border: InputBorder.none, // Loại bỏ border dưới
                        ),
                      ),
                      decoration: BoxDecoration(
                        borderRadius: BorderRadius.circular(7.0), // Thêm border radius
                        color: Colors.white, // Màu nền trắng
                      ),
                    ),
                  ),
                  Row(
                    mainAxisSize: MainAxisSize.min,
                    children: <Widget>[
                      TextIcon(onPressed: () {
                        print("Press notification");
                      },
                          iconData: Icons.notifications,
                          title: '10'
                      ),
                      TextIcon(onPressed: () {
                        print("Press shopping_cart");
                      },
                          iconData: Icons.shopping_cart,
                          title: '20'
                      ),
                    ],
                  ),
                  SizedBox(width: 10,),
                ],
              ),
            ),
            CarouselSlider(slides: _slides)
          ],
        ),
      ),
    );
  }
}

