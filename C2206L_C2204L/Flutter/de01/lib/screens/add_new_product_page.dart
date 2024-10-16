import 'package:de01/widgets/header.dart';
import 'package:flutter/material.dart';

class AddNewProductPage extends StatefulWidget {
  AddNewProductPage({super.key});

  @override
  State<AddNewProductPage> createState() => _AddNewProductPageState();
}

class _AddNewProductPageState extends State<AddNewProductPage> {
  final TextEditingController codeController = TextEditingController();
  final TextEditingController nameController = TextEditingController();
  final List<Map<String, MaterialColor>> colors = [
    {'yellow': Colors.yellow},
    {'blue': Colors.blue},
    {'red': Colors.red},
    {'purple': Colors.purple},
  ];
  Map<String, MaterialColor> selectedColor = {'yellow': Colors.yellow};
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Container(
          child: Column(
            children: [
              Header(title: 'Exam'),
              Padding(
                  padding: EdgeInsets.symmetric(horizontal: 15),
                  child: TextField(
                    controller: codeController,
                    decoration: InputDecoration(
                      hintText: 'Enter code', // Placeholder text
                      hintStyle: TextStyle(color: Colors.grey), // Placeholder style
                    ),
                    maxLines: 1,
                  ),
              ),
              Padding(
                padding: EdgeInsets.symmetric(horizontal: 15),
                child: TextField(
                  controller: nameController,
                  decoration: InputDecoration(
                    hintText: 'Enter name', // Placeholder text
                    hintStyle: TextStyle(color: Colors.grey), // Placeholder style
                  ),
                  maxLines: 1,
                ),
              ),
              Padding(
                padding: EdgeInsets.symmetric(horizontal: 15),
                child: Row(
                  children: [
                    Text('Code: '),
                    DropdownButton<Map<String, MaterialColor>>(
                      value: selectedColor,
                      icon: Icon(Icons.arrow_downward),
                      iconSize: 24,
                      elevation: 16,
                      style: TextStyle(color: Colors.deepPurple),
                      underline: Container(
                        height: 2,
                        color: Colors.deepPurpleAccent,
                      ),
                      onChanged: (Map<String, MaterialColor>? newValue) {
                        setState(() {
                          selectedColor = newValue!;
                        });
                      },
                      items: colors.map<DropdownMenuItem<Map<String, MaterialColor>>>((Map<String, MaterialColor> value) {
                        String colorName = value.keys.first;
                        MaterialColor colorValue = value[colorName]!;
                        return DropdownMenuItem<Map<String, MaterialColor>>(
                          value: value,
                          child: Container(
                            width: 100, // Fixed width for alignment
                            height: 24, // Fixed height for visual consistency
                            color: colorValue,
                            alignment: Alignment.center,
                            child: Text(colorName, style: TextStyle(color: Colors.white)),
                          ),
                        );
                      }).toList(),
                    ),
                  ],
                ),
              )
            ],

          ),
        ),
      ),
    );
  }
}
