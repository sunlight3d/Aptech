import 'package:flutter/material.dart';
import 'package:pet_care_reminder_app/models/pet.dart';
import 'package:pet_care_reminder_app/repositories/pet_repository.dart';
import 'package:pet_care_reminder_app/viewmodels/view_model.dart';

class PetViewModel extends ViewModel {
  final PetRepository repository;
  List<Pet> pets = [];

  PetViewModel(this.repository);

  /// Handles the common loading/error/notify pattern for async operations
  Future<void> _performAsyncOperation(
      Future<void> Function() operation,
      ) async {
    try {
      isLoading = true;
      notifyListeners();

      await operation();
      error = null;
    } catch (e) {
      error = e.toString();
      rethrow; // Optionally rethrow if you want calling code to handle errors
    } finally {
      isLoading = false;
      notifyListeners();
    }
  }

  /// Fetches all pets from the repository
  Future<void> getPets() async {
    await _performAsyncOperation(() async {
      pets = await repository.getPets();
    });
  }

  /// Adds a new pet and refreshes the list
  Future<void> insertPet(Pet newPet) async {
    await _performAsyncOperation(() async {
      await repository.insertPet(newPet);
      pets = await repository.getPets(); // Refresh the list
    });
  }

  /// Updates an existing pet and refreshes the list
  /*
  Future<void> updatePet(Pet updatedPet) async {
    await _performAsyncOperation(() async {
      await repository.updatePet(updatedPet);
      pets = await repository.getPets(); // Refresh the list
    });
  }

  /// Deletes a pet and refreshes the list
  Future<void> deletePet(String petId) async {
    await _performAsyncOperation(() async {
      await repository.deletePet(petId);
      pets = await repository.getPets(); // Refresh the list
    });
  }
   */
}