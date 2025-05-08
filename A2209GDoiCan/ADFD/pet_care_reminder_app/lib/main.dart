import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:pet_care_reminder_app/services/pet_service.dart';
import 'package:pet_care_reminder_app/views/pets_screen.dart';
import 'package:provider/provider.dart';
import 'package:pet_care_reminder_app/repositories/pet_repository.dart';
import 'package:pet_care_reminder_app/viewmodels/pet_view_model.dart';

void main() {
  runApp(
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => MyApp()),
        ChangeNotifierProvider(create: (_) => PetViewModel(PetRepository(PetService()))),
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
      home: PetsScreen(),
    );
  }
}