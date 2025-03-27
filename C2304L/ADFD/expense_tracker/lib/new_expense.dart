import 'package:expense_tracker/helpers.dart';
import 'package:expense_tracker/models/expense.dart';
import 'package:flutter/material.dart';
import 'package:uuid/uuid.dart';

class NewExpense extends StatefulWidget {
  Function? insertExpense;
  NewExpense({super.key, this.insertExpense});

  @override
  State<NewExpense> createState() => _NewExpenseState();
}

class _NewExpenseState extends State<NewExpense> {
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();
  DateTime? selectedDate;
  Future<void> _selectDate() async {
    final DateTime? pickedDate = await showDatePicker(
      context: context,
      initialDate: DateTime(2024, 7, 25),
      firstDate: DateTime(2024),
      lastDate: DateTime(2026),
    );

    setState(() {
      selectedDate = pickedDate;
    });
  }
  // not a GlobalKey<MyCustomFormState>.
  final _formKey = GlobalKey<FormState>();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Form(
          key: _formKey,
          child: Container(
            padding: EdgeInsets.all(10),
            child: Column(
              children: [
                Text('Add new Expense'),
                Row(
                  children: [
                    Text('Title'),
                    SizedBox(
                      width: MediaQuery.of(context).size.width * 0.8,
                      child: TextFormField(
                        controller: _titleController,
                        validator: (value) {
                          if (value == null || value.isEmpty) {
                            return 'Enter your title';
                          }
                          return null;
                        },
                      ),
                    ),
                  ],
                ),
                Row(
                  children: [
                    Text('Price'),
                    SizedBox(
                      width: MediaQuery.of(context).size.width * 0.8,
                      child: TextFormField(
                        controller: _priceController,
                        // The validator receives the text that the user has entered.
                        validator: (value) {
                          if (value == null || value.isEmpty) {
                            return 'Enter your price';
                          }
                          return null;
                        },
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 20,),
                Text(
                  selectedDate != null
                      ? formatDate(selectedDate!)
                      : 'No date selected',
                ),
                SizedBox(height: 20,),
                Row(
                  children: [
                    OutlinedButton(onPressed: _selectDate, child: Text('Select Date')),
                    ElevatedButton(onPressed: () {
                      if (_formKey.currentState!.validate()) {
                        widget.insertExpense!(
                            Expense(id: Uuid().v1(), title: _titleController.text,
                            price: double.parse(_priceController.text) ,date: selectedDate!)
                        );
                        Navigator.of(context).pop();
                      }
                    },
                        child: Text('Save')
                    )
                  ],
                ),
              ],
            )),
          ),
    );
  }
}
