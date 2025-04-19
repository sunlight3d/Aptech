import 'package:de02/models/coffee.dart';
import 'package:flutter/material.dart';

import 'api_call.dart';

class CoffeeList extends StatefulWidget {
  const CoffeeList({super.key});

  @override
  State<CoffeeList> createState() => _CoffeeListState();
}

class _CoffeeListState extends State<CoffeeList> {
  final ApiCall _apiCall = ApiCall();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        child: FutureBuilder<List<Coffee>>(
          future: _apiCall.getCoffees(type: 'iced'),
          builder: (BuildContext context, AsyncSnapshot<List<Coffee>> snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return const Center(child: CircularProgressIndicator());
            }
            if (snapshot.hasError) {
              return Center(child: Text('Lỗi: ${snapshot.error}'));
            }

            final coffees = snapshot.data ?? [];
            return ListView.builder(
              itemCount: coffees.length,
              itemBuilder: (BuildContext context, int index) {
                final coffee = coffees[index];
                return Card(
                  margin: const EdgeInsets.all(8.0),
                  child: ListTile(
                    leading: coffee.image.isEmpty ? Container() : Image.network(coffee.image, width: 100, height: 100),
                    title: Text(coffee.title),
                    subtitle: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text('Price: ${coffee.price}'),
                        Text('Total sales: ${coffee.totalSales}'),
                      ],
                    ),
                    onTap: () {

                    },
                  ),
                );
              },
            );
          },
        ),
      ),
    );
  }
}
