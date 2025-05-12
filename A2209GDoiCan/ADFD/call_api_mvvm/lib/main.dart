import 'package:call_api_mvvm/repositories/fruit_repository.dart';
import 'package:call_api_mvvm/services/fruit_service.dart';
import 'package:call_api_mvvm/viewmodels/fruit_view_model.dart';
import 'package:call_api_mvvm/views/FruitList.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => MyApp()),
        ChangeNotifierProvider(create: (_) => FruitViewModel(FruitRepository(FruitService()))),
      ],
      child: MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget with ChangeNotifier, DiagnosticableTreeMixin {
  MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(

        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: FruitList(),
    );
  }
}

