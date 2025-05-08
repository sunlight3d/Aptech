import 'package:pet_care_reminder_app/models/pet.dart';
import 'package:pet_care_reminder_app/models/reminder.dart';

class PetService {
  final List<Pet> _fakedPets = [
    Pet(name: 'Luna', reminders: [
      Reminder(title: 'Feed ', date: DateTime(2025, 5, 9)),
      Reminder(title: 'Vet Visit ', date: DateTime(2025, 5, 11)),
      Reminder(title: 'Do something ', date: DateTime(2025, 5, 12)),
    ])
  ];
  Future<List<Pet>> fetchPets() async {
    await Future.delayed(const Duration(seconds: 4));
    return _fakedPets;
  }
  Future<void> insertPet(Pet newPet) async {
    await Future.delayed(const Duration(seconds: 4));
    _fakedPets.add(newPet);
  }
}