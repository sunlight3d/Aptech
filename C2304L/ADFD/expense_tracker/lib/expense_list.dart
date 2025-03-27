import 'package:flutter/material.dart';
import 'package:uuid/uuid.dart';

import 'helpers.dart';
import 'models/expense.dart';
import 'new_expense.dart';

class ExpenseList extends StatefulWidget {
  const ExpenseList({super.key});

  @override
  State<ExpenseList> createState() => _ExpenseListState();
}

class _ExpenseListState extends State<ExpenseList> {
  List<Expense> expenses = [
    Expense(id: Uuid().v1(),title: 'Mua gạo', date: DateTime(2024, 9, 28), price: 123),
    Expense(id: Uuid().v1(),title: 'Buy some cake', date: DateTime(2024, 9, 29), price: 23),
    Expense(id: Uuid().v1(),title: 'Buy Java books', date: DateTime(2025, 1, 23), price: 111),
  ];
  double get totalPrice {
    double result = 0.0;
    for (var item in expenses) {
      result = result + item.price ?? 0;
    }
    return result;
  }
  void insertExpense(Expense expense) {
    setState(() {
      expenses.add(expense);
    });
  }
  void updateExpense(String id, Expense expense) {
    if(expenses.where((expense) => expense.id == id).toList().isEmpty) {
      return;
    }
    Expense foundExpense = expenses.where((expense) => expense.id == id).toList().first;
    setState(() {
      foundExpense.title = expense.title;
      foundExpense.price = expense.price;
      foundExpense.date = expense.date;
    });
  }
  void deleteExpense(String id) {
    Expense foundExpense = expenses.where((expense) => expense.id == id).toList().first;
    //expenses.remove(foundExpense);
    setState(() {
      expenses = expenses.where((expense) => expense.id != id).toList();
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.all(10),
        child: Column(
          children: [
            Text('Total Expense: \$$totalPrice', textAlign: TextAlign.center,),
            SizedBox(height: 10,),
            Text('Expense List'),
            SizedBox(height: 10,),
            Expanded(child: ListView.builder(itemBuilder: (BuildContext context, int i){
              if(i == expenses.length) {
                return Row(
                  mainAxisAlignment: MainAxisAlignment.end,
                  children: [
                    ElevatedButton(onPressed: () {
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => NewExpense(insertExpense: insertExpense)),
                      );
                    }, child: Text('Add Expense'))
                  ],
                );
              } else {
                Expense item = expenses[i];
                return Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    // Text('${item.id}, '),
                    Text(item.title),
                    Text('\$${item.price}'),
                    Text(formatDate(item.date)),
                  ],
                );
              }
            },
                itemCount: expenses.length + 1),
            ),
          ],
        ),
      ),
    );
  }
}
