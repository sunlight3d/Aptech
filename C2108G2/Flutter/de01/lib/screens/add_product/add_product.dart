
import 'package:flutter/material.dart';

class AddProductScreen extends StatefulWidget
{
  const AddProductScreen({super.key});

  @override
  State<AddProductScreen> createState() => _AddProductScreenState();
}

class _AddProductScreenState extends State<AddProductScreen> {
  final TextEditingController _codeTextEditingController = TextEditingController();
  final TextEditingController _nameTextEditingController = TextEditingController();
  List<String> _fakeColors = ['FF0000', '00FF00', '0000FF', 'FFFF00', '800080'];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.purple,
        centerTitle: false,
        title: Text(
          'Exam',
          textAlign: TextAlign.start,
          style: TextStyle(color: Colors.white),
        ),
      ),
      body: Container(
        padding: EdgeInsets.symmetric(horizontal: 15),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            TextField(
              controller: _codeTextEditingController,
              decoration: InputDecoration(
                labelText: 'Code',
                hintText: 'Code',
                focusedBorder: UnderlineInputBorder(
                  borderSide: BorderSide(color: Colors.green),
                ),
              ),
            ),

            TextField(
              controller: _nameTextEditingController,
              decoration: InputDecoration(
                labelText: 'Name',
                hintText: 'Name',
                focusedBorder: UnderlineInputBorder(
                  borderSide: BorderSide(color: Colors.green),
                ),
              ),
            ),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                Text('Code'),
                DropdownButton<String>(
                  items: _fakeColors.map((String color) {
                    return DropdownMenuItem<String>(
                      value: color,
                      child: Text(color),
                    );
                  }).toList(),
                  onChanged: (String? value) {
                    print('Selected color: $value');
                  },
                  value: null,
                ),
              ],
            )
          ],
        ),
      ),
    );
  }
}
