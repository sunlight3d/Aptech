import 'package:flutter/material.dart';
import 'package:noteapp/database/sqlite_helper.dart';
import 'package:noteapp/repositories/note_repository.dart';
import 'package:noteapp/screens/main_screen.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
      MultiProvider(
        providers: [
          ChangeNotifierProvider<NoteRepository>(
            create: (context) => NoteRepository(),
          ),
          ChangeNotifierProvider<SQLiteHelper>(
            create: (context) => SQLiteHelper(),
          ),
        ],
        child: MyApp(),
      )
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: MainScreen(),
    );
  }
}
