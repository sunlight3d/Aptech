import 'package:de03/models/product.dart';
import 'package:de03/repositories/cart_repository.dart';
import 'package:de03/repositories/color_repository.dart';
import 'package:de03/widgets/color_button.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

class DetailScreen extends StatefulWidget {
  final Product product;
  DetailScreen({super.key, required this.product});

  @override
  State<DetailScreen> createState() => _DetailScreenState();
}

class _DetailScreenState extends State<DetailScreen> {
  List<Color> _colors = <Color>[];
  List<bool> _isSelectedList = <bool>[];
  Color _selectedColor = Colors.white;
  int _quantity = 0;
  final _cartRepository = GetIt.instance<CartRepository>();
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    final _colorRepository = GetIt.instance<ColorRepository>();
    setState(() {
      _colors = _colorRepository.colors;
      _isSelectedList = List.filled(_colors.length, false);
      _isSelectedList[0] = true;
    });
    _cartRepository.getQuantity(id: widget.product.id).then((value) {
      setState(() {
        _quantity = value;
      });
    });
  }
  @override
  Widget build(BuildContext context) {

    return Scaffold(
      body: SafeArea(
        child: Container(
          padding: EdgeInsets.symmetric(horizontal: 10),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Container(
                height: 80,
                child: Row(
                  children: [
                    GestureDetector(
                      child: Padding(
                        padding: EdgeInsets.all(10),
                        child: Icon(Icons.arrow_back),
                      ),
                      onTap: () {
                        Navigator.of(context).pop();
                      },
                    ),
                    Expanded(
                        child: Text(
                          this.widget.product.name,
                          style: TextStyle(fontWeight: FontWeight.bold, fontSize: 17),
                          textAlign: TextAlign.center,)
                    ),
                    GestureDetector(
                      child: Padding(
                        padding: EdgeInsets.all(10),
                        child: Icon(Icons.heart_broken),
                      ),
                    )
                  ],
                ),
              ),
              Image.network(
                this.widget.product.url,
                width: MediaQuery.of(context).size.width - 20,
                fit: BoxFit.cover,
              ),
              Container(
                padding: EdgeInsets.only(left: 20, top: 20),
                width: 200,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: _colors.asMap().entries.map((entry) {
                    final index = entry.key;
                    Color color = entry.value;
                    return ColorButton(
                      color: color,
                      isSelected: _isSelectedList[index],
                      onTap: (isSelected) {
                        setState(() {
                          _isSelectedList = List.filled(_colors.length, false);
                          _isSelectedList[index] = true;
                          _selectedColor = _colors[index];
                        });
                      },
                    );
                  }).toList(),
                ),
              ),
              SizedBox(height: 10,),
              Text(
                widget.product.description ?? '',
                style: TextStyle(fontSize: 18),
                maxLines: 5,
                overflow: TextOverflow.ellipsis,
              ),
              SizedBox(height: 10,),
              Text(
                'Number of products: ${_quantity}',
                style: TextStyle(fontSize: 18),
              ),
              SizedBox(height: 10,),
              GestureDetector(
                child: Container(
                  padding: EdgeInsets.symmetric(vertical: 20),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center
                    ,
                    children: [
                      Icon(Icons.add_shopping_cart, size: 60,),
                    ],
                  )
                ),
                onTap: () {
                  _cartRepository.addToCart(id: widget.product.id);
                  _cartRepository.getQuantity(id: widget.product.id).then((value) {
                    setState(() {
                      _quantity = value;
                    });
                  });
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}
