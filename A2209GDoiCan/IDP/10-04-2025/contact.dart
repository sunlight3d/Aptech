import 'dart:convert';
import 'dart:io';

class Contact {
  int id;
  String name;
  String phoneNumber;
  String email;
  Contact({
    required this.id,
    required this.name,
    required this.phoneNumber,
    required this.email,
  });
  Map<String, dynamic> toJSON() {
    return {
      "id": this.id,
      "name": this.name,
      "phone_number": this.phoneNumber,
      "email": this.email,
    };
  }

  static Contact fromJSON(Map valueMap) {
    return Contact(
      id: valueMap['id'],
      name: valueMap['name'],
      phoneNumber: valueMap['phoneNumber'].toString(),
      email: valueMap['email'],
    );
  }

  static Contact input() {
    print('Enter id: ');
    int id = int.parse(stdin.readLineSync()!) ?? 0;

    print('Enter name: ');
    String name = stdin.readLineSync() ?? '';

    print("Enter phone's number: ");
    String phoneNumber = stdin.readLineSync() ?? '';

    print('Enter email: ');
    String email = stdin.readLineSync() ?? '';
    return Contact(id: id, name: name, phoneNumber: phoneNumber, email: email);
  }

  static void updateContactInList({
    required userId,
    required fileName,
    String? name,
    String? phoneNumber,
    String? email,
  }) async {
    try {
      List<Contact> contacts = await Contact.loadFromFile(fileName);
      Contact foundContact =
          contacts.where((contact) => contact.id == userId).first;
      foundContact.name = name ?? foundContact.name;
      foundContact.name = email ?? foundContact.email;
      foundContact.name = phoneNumber ?? foundContact.phoneNumber;
      Map<String, dynamic> map = Map();
      map['contacts'] = contacts.map((Contact contact) => contact.toJSON());
      await File(fileName).writeAsString(jsonEncode(map));
      //Shared Preference
    } catch (Exception) {
      print('Cannot update contact');
    }
  }

  static void deleteContactInList({required userId, required fileName}) async {
    try {
      List<Contact> contacts = await Contact.loadFromFile(fileName);
      contacts.removeWhere((contact) => contact.id == userId);
      Map<String, dynamic> map = Map();
      map['contacts'] = contacts.map((Contact contact) => contact.toJSON());
      await File(fileName).writeAsString(jsonEncode(map));
      //Shared Preference
    } catch (Exception) {
      print('Cannot delete contact');
    }
  }

  static Future<List<Contact>> loadFromFile(String fileName) async {
    var input = await File(fileName).readAsString();
    var decoded = jsonDecode(input);

    // Ensure the 'contacts' field exists and is a List
    if (decoded['contacts'] is! List) {
      throw FormatException('Expected "contacts" to be a list');
    }

    // Convert each item in the list to a Map
    List<Map<String, dynamic>> list =
        (decoded['contacts'] as List).map((item) {
          if (item is Map<String, dynamic>) {
            return item;
          } else if (item is Map) {
            return Map<String, dynamic>.from(item);
          } else {
            throw FormatException('Expected contact items to be maps');
          }
        }).toList();

    return list.map((item) => Contact.fromJSON(item)).toList();
  }

  @override
  String toString() =>
      'id: ${this.id},' +
      'name: ${this.name},' +
      'phone number: ${this.phoneNumber}, email: ${this.email}';
}
