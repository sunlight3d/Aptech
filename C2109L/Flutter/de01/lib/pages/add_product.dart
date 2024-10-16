import 'package:de01/models/my_color.dart';
import 'package:de01/models/product.dart';
import 'package:de01/repositories/product_repository.dart';
import 'package:flutter/material.dart';

class AddNewProduct extends StatefulWidget {
  const AddNewProduct({super.key});

  @override
  State<AddNewProduct> createState() => _AddNewProductState();
}

class _AddNewProductState extends State<AddNewProduct> {
  final TextEditingController _codeTextEditing = TextEditingController();
  final TextEditingController _nameTextEditing = TextEditingController();
  final TextEditingController _priceTextEditing = TextEditingController();
  List<MyColor> _colors = [

  ];
  MyColor _selectedColor = MyColor(name: "Blue", color: Colors.blue);
  ProductRepository _productRepository = ProductRepository();
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _colors = [
      MyColor(name: "Blue", color: Colors.blue),
      MyColor(name: "Red", color: Colors.redAccent),
      MyColor(name: "Green", color: Colors.greenAccent),
      MyColor(name: "Yellow", color: Colors.yellow)
    ];
    _selectedColor = _colors.first;
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        padding: const EdgeInsets.symmetric(horizontal: 10),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            TextField(
              controller: _codeTextEditing,
              decoration: const InputDecoration(
              hintText: 'Code',
                hintStyle: TextStyle(color: Colors.grey),
                enabledBorder: UnderlineInputBorder(
                  borderSide: BorderSide(color: Colors.green),
                ),
              )
            ),
            TextField(
                controller: _nameTextEditing,
                decoration: const InputDecoration(
                  hintText: 'Name',
                  hintStyle: TextStyle(color: Colors.grey),
                  enabledBorder: UnderlineInputBorder(
                    borderSide: BorderSide(color: Colors.green),
                  ),
                )
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                  Text('Color'),
                  DropdownButtonFormField<MyColor>(
                    value: _selectedColor,
                    items: _colors.map((color) => DropdownMenuItem(
                      value: color,
                      child: Text(color.name),
                    )).toList(),
                    onChanged: (myColor) {
                      setState(() {
                        _selectedColor = myColor ?? _colors.first;
                      });
                    },
                    hint: Text("Select a color"),
                  )
              ],
            ),
            TextField(
                controller: _priceTextEditing,
                keyboardType: TextInputType.number, // Display numeric keyboard
                decoration: const InputDecoration(
                  hintText: 'Price',
                  hintStyle: TextStyle(color: Colors.grey),
                  enabledBorder: UnderlineInputBorder(
                    borderSide: BorderSide(color: Colors.green),
                  ),
                )
            ),
            InkWell(
              child: Container(
                width: 100,
                height: 50,
                child: Text('Save'),
              ),
              onTap: () {
                String code = _codeTextEditing.text;
                String name = _nameTextEditing.text;
                double price = double.parse(_priceTextEditing.text);
                //_productRepository.insert(Product(title: name, cid))
              },
            )
          ],
        ),
      )
    );
  }
}
