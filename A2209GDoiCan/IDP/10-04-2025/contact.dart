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
