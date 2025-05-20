import 'package:flutter/material.dart';
import 'package:sqlite_mvvm_app/models/contact.dart';
import 'package:sqlite_mvvm_app/repositories/contact_repository.dart';

import 'view_model.dart';


class ContactViewModel extends ViewModel {
  final ContactRepository repository;
  List<Contact> contacts = [];

  ContactViewModel(this.repository);

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
  Future<void> getContacts() async {
    await _performAsyncOperation(() async {
      contacts = await repository.getContacts();
    });
  }

  /// Adds a new pet and refreshes the list
  Future<void> insertContact(Contact newContact) async {
    await _performAsyncOperation(() async {
      await repository.insertContact(newContact);
      contacts = await repository.getContacts(); // Refresh the list
    });
  }

/// Updates an existing pet and refreshes the list

  Future<void> updateContact(Contact updatedContact) async {
    await _performAsyncOperation(() async {
      await repository.updateContact(updatedContact);
      contacts = await repository.getContacts(); // Refresh the list
    });
  }

  /// Deletes a pet and refreshes the list
  Future<void> deleteContact(int contactId) async {
    await _performAsyncOperation(() async {
      await repository.deleteContact(contactId);
      contacts = await repository.getContacts(); // Refresh the list
    });
  }
}