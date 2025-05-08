import 'package:flutter/material.dart';
import 'package:pet_care_reminder_app/models/pet.dart';
import 'package:pet_care_reminder_app/viewmodels/pet_view_model.dart';
import 'package:provider/provider.dart';

class PetsScreen extends StatefulWidget {
  PetsScreen({super.key});

  @override
  State<PetsScreen> createState() => _PetsScreenState();
}

class _PetsScreenState extends State<PetsScreen> {
  @override
  void initState() {
    super.initState();
    // Load pets when the screen initializes
    Provider.of<PetViewModel>(context, listen: false).getPets();
  }

  @override
  Widget build(BuildContext context) {
    final petViewModel = Provider.of<PetViewModel>(context);
    return Scaffold(
      body: Padding(
        padding: EdgeInsets.all(10),
        child: Column(
          children: [
            Text('My pets', style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),),
            Expanded(child: petViewModel.isLoading ? Center(child: CircularProgressIndicator()) : ListView.builder(
                itemCount: petViewModel.pets.length,
                itemBuilder:(BuildContext context, int index) {
                  Pet pet = petViewModel.pets[index];
                  int numberOfReminders = pet.reminders?.length ?? 0;
                  return Container(
                    child: Row(
                      children: [
                        Text('- ${pet.name}( $numberOfReminders reminders)')
                      ],
                    ),
                  );
                }
            )),
            Row(
              mainAxisAlignment: MainAxisAlignment.end,
              children: [
                TextButton(onPressed: () {

                }, child: Text('Add pet'))
              ],
            )
          ],
        ),
      ),
    );
  }
}