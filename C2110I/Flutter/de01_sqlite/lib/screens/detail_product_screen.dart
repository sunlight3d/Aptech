import 'package:flutter/material.dart';
import 'package:productapp/database/database_helper.dart';
import 'package:productapp/models/my_color.dart';
import 'package:productapp/models/product.dart';
class DetailProductScreen extends StatefulWidget {
  const DetailProductScreen({super.key});

  @override
  State<DetailProductScreen> createState() => _DetailProductScreenState();
}

class _DetailProductScreenState extends State<DetailProductScreen> {
  late TextEditingController _textEditingCodeController;
  late TextEditingController _textEditingNameController;
  late TextEditingController _textEditingPriceController;
  //This is a state
  List<MyColor> colors = <MyColor>[];
  late MyColor selectedColor;
  Product? selectedProduct;
  late DatabaseHelper _databaseHelper;
  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _textEditingCodeController = TextEditingController();
    _textEditingNameController = TextEditingController();
    _textEditingPriceController = TextEditingController();
    _databaseHelper = DatabaseHelper.getInstance();
    _databaseHelper.getColors().then((value) {
      setState(() {
        colors = value;//reload UI
        selectedColor = colors.first ?? MyColor(name: 'white', hexValue: "#FFFFFF");
      });
    });
  }
  @override
  void dispose() {
    _textEditingCodeController.dispose();
    _textEditingNameController.dispose();
    _textEditingPriceController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('EXAM'),
        backgroundColor: Colors.purple,
      ),
      body: SafeArea(
        child: colors.length == 0 ?
        const Center(child: CircularProgressIndicator(),)
        :Container(
          padding: EdgeInsets.symmetric(horizontal: 30),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              TextField(
                controller: _textEditingCodeController,
                decoration: InputDecoration(
                  hintText: 'Code',
                ),
              ),
              TextField(
                controller: _textEditingNameController,
                decoration: InputDecoration(
                  hintText: 'Name',
                ),
              ),
              Container(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text('Color: ', style: TextStyle(fontSize: 17),),
                    DropdownMenu<MyColor>(
                      initialSelection: colors.first!,
                      onSelected: (MyColor? value) {
                        // This is called when the user selects an item.
                        setState(() {
                          selectedColor = value!;
                        });
                      },
                      dropdownMenuEntries: colors.map<DropdownMenuEntry<MyColor>>((MyColor value) {
                        return DropdownMenuEntry<MyColor>(
                            value: value,
                            label: value.name
                        );
                      }).toList(),
                    ),
                  ],
                ),
                padding: EdgeInsets.symmetric(vertical: 10),
              ),
              TextField(
                controller: _textEditingPriceController,
                decoration: InputDecoration(
                  hintText: 'price',
                ),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  ElevatedButton(onPressed: () async {
                    try {
                      selectedProduct = Product(
                        code: _textEditingCodeController.text,
                        name: _textEditingCodeController.text,
                        price: double.parse(_textEditingPriceController.text ?? '0'),
                        colorId: this.selectedColor.id ?? 0,
                        //hexValue: this.selectedColor.hexValue
                      );
                      int productId = await _databaseHelper.insertProduct(selectedProduct!);
                      if(productId > 0) {
                        print('Insert successfully');
                        Navigator.pop(context);
                      }
                    } catch (e) {
                      print('Cannot insert, error: $e'); // Use e.toString() to get the error message
                    }
                  },
                      child: Text('Save', style: TextStyle(fontSize: 18),)
                  )
                ],
              )
            ],
          ),
        ),
      ),
    );
  }
}
