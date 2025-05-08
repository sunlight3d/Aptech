import 'package:pet_care_reminder_app/models/pet.dart';
import 'package:pet_care_reminder_app/services/pet_service.dart';

class PetRepository {
  final PetService petService;
  PetRepository(this.petService);
  Future<List<Pet>> getPets() => petService.fetchPets();
  Future<void> insertPet(Pet newPet) => petService.insertPet(newPet);
}