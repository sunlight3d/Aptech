import 'package:de01/models/my_color.dart';
import 'package:de01/models/product.dart';
import 'package:de01/repositories/color_repository.dart';
import 'package:de01/repositories/product_repository.dart';
import 'package:de01/utilities/utilities.dart';
import 'package:de01/widgets/my_scaffold.dart';
import 'package:flutter/material.dart';
import 'package:get_it/get_it.dart';

class AddProductScreen extends StatefulWidget {
  const AddProductScreen({super.key});

  @override
  State<AddProductScreen> createState() => _AddProductScreenState();
}

class _AddProductScreenState extends State<AddProductScreen> {
  TextEditingController _colorTextEditingController = TextEditingController();
  TextEditingController _nameTextEditingController = TextEditingController();
  TextEditingController _priceTextEditingController = TextEditingController();

  //this is a state
  MyColor? selectedColor;

  @override
  Widget build(BuildContext context) {
    final productRepository = GetIt.instance<ProductRepository>();
    final colorRepository = GetIt.instance<ColorRepository>();
    return MyScaffold(child: FutureBuilder<List<MyColor>>(
      future: colorRepository.fetchColors(),
      builder: (BuildContext context, AsyncSnapshot<List<MyColor>> snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) {
          return CircularProgressIndicator(); // Show a progress indicator while loading
        } else if (snapshot.hasError) {
          return Text('Error: ${snapshot.error}'); // Show an error message if an error occurred
        } else {
          List<MyColor> colors = snapshot.data!;
          var menuItems = colors.map<DropdownMenuItem<MyColor>>((MyColor myColor) {
            return DropdownMenuItem<MyColor>(
              value: myColor,
              child: Text(myColor.name),
            );
          }).toList();
          selectedColor = selectedColor ?? colors.first;
          print('haha');
          return Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              Container(
                  padding: EdgeInsets.symmetric(horizontal: 20),
                  child: TextField(
                    decoration: InputDecoration(
                      hintText: 'Code',
                      hintStyle: TextStyle(color: Colors.grey),
                      border: InputBorder.none,
                      enabledBorder: UnderlineInputBorder(
                        borderSide: BorderSide(color: Colors.cyan),
                      ),
                    ),
                    controller: _colorTextEditingController,
                  )
              ),
              Container(
                  padding: EdgeInsets.symmetric(horizontal: 20),
                  child: TextField(
                    decoration: InputDecoration(
                      hintText: 'Name',
                      hintStyle: TextStyle(color: Colors.grey),
                      border: InputBorder.none,
                      enabledBorder: UnderlineInputBorder(
                        borderSide: BorderSide(color: Colors.cyan),
                      ),
                    ),
                    controller: _nameTextEditingController,
                  )
              ),
              Container(
                padding: EdgeInsets.symmetric(horizontal: 20),
                height: 100,
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text('Color', style: TextStyle(fontSize: 18),),
                    SizedBox(width: 80,),
                    Expanded(
                      child: DropdownButton<MyColor>(
                        value: selectedColor,
                        onChanged: (MyColor? newColor) {
                          setState(() {
                            selectedColor = newColor ?? colors.first;
                          });
                        },
                        items: menuItems,
                      ),
                    ),
                  ],
                ),
              ),
              Container(
                  padding: EdgeInsets.symmetric(horizontal: 20),
                  child: TextField(
                    decoration: InputDecoration(
                      hintText: 'Price',
                      hintStyle: TextStyle(color: Colors.grey),
                      border: InputBorder.none,
                      enabledBorder: UnderlineInputBorder(
                        borderSide: BorderSide(color: Colors.cyan),
                      ),
                    ),
                    controller: _priceTextEditingController,
                  )
              ),
              GestureDetector(
                child: Container(
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5),
                    color: Colors.purple,
                  ),
                  child: Text('Save', style: TextStyle(fontSize: 20, color: Colors.white),),
                  padding: EdgeInsets.symmetric(vertical: 10, horizontal: 50),
                ),
                onTap: () {
                  print('Save');
                  String productName = _nameTextEditingController.text ?? "";
                  String color = _colorTextEditingController.text ?? "";
                  double price = double.parse(_priceTextEditingController.text);
                  if(productName.isEmpty || color.isEmpty || price < 0) {
                    Utilities.alert(context, "You must enter product's name, price, color");
                    return;
                  }
                  Product product = Product(
                      code: color,
                      name: productName,
                      hexValue: selectedColor!.hexValue,
                      price: price
                  );
                  productRepository.addProduct(product);
                  Navigator.of(context).pop();
                },
              ),
            ],
          );
        }
      },
    ));
  }
}
/*

*/