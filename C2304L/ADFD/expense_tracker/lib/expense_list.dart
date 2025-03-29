import 'package:expense_tracker/update_expense.dart';
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
  String filterByAmount = 'asc';
  String filterByDate = 'asc';
  int selectedMonth = 1;//1-12

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
  void updateExpense({required String id,
    //updated values
    String? title,
    double? price,
    DateTime? date
  }) {
    if(expenses.where((expense) => expense.id == id).toList().isEmpty) {
      return;
    }
    Expense foundExpense = expenses.where((expense) => expense.id == id).toList().first;
    setState(() {
      foundExpense.title = title ?? foundExpense.title;
      foundExpense.price = price ?? foundExpense.price;
      foundExpense.date = date ?? foundExpense.date;
    });
  }
  Expense getExpenseById(String id) {
    return expenses.where((expense) => expense.id == id).first;
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
            Row(
              children: [
                Row(
                  children: [
                    ElevatedButton(onPressed: () {
                      var updateExpense = [...expenses];
                      updateExpense.sort((it1, it2) => filterByAmount == 'asc' ?
                        (it1.price - it2.price).toInt() : (it2.price - it1.price).toInt());
                      setState(() {
                        filterByAmount =  filterByAmount == 'asc' ? 'desc' : 'asc';
                        expenses = updateExpense;
                      });
                    }, child: Text('Amount')),
                    Icon(filterByAmount == 'asc' ?
                      Icons.arrow_circle_up_outlined :
                      Icons.arrow_circle_down_outlined)
                  ],
                ),
                Row(
                  children: [
                    ElevatedButton(onPressed: () {
                      var updateExpense = [...expenses];
                      updateExpense.sort((it1, it2) => filterByDate == 'asc' ?
                      it1.date.compareTo(it2.date) : it1.date.compareTo(it2.date));
                      setState(() {
                        filterByAmount =  filterByAmount == 'asc' ? 'desc' : 'asc';
                        expenses = updateExpense;
                      });
                    }, child: Text('Date')),
                    Icon(filterByDate == 'asc' ?
                    Icons.arrow_circle_up_outlined :
                    Icons.arrow_circle_down_outlined)
                  ],
                ),
              ],
            ),
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
                    ElevatedButton(onPressed: (){
                      Navigator.push(
                        context,
                        MaterialPageRoute(builder: (context) => UpdateExpense(
                          id: item.id,
                          updateExpense: updateExpense,
                          getExpenseById: getExpenseById,
                        )),
                      );
                    }, child: Text('Edit')),
                    ElevatedButton(onPressed: (){
                      deleteExpense(item.id);
                    }, child: Text('Delete', style: TextStyle(color: Colors.red, fontWeight: FontWeight.bold),))
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
