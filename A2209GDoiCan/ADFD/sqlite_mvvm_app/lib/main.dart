import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sqlite_mvvm_app/repositories/contact_repository.dart';
import 'package:sqlite_mvvm_app/viewmodels/contact_view_model.dart';
import 'package:sqlite_mvvm_app/views/contact_list.dart';
/*
flutter pub add provider sqflite path_provider
* */
void main() {
  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => ContactViewModel(ContactRepository())),
      ],
      child: MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget with ChangeNotifier, DiagnosticableTreeMixin {
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: ContactList(),

    );
  }
}