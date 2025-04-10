import 'dart:html_common';

import 'contact.dart';

void main() async {
  List<Contact> contacts = [];
  //print(contacts);
  int choice = 0;
  while(choice != 6) {
    switch(choice) {
      case 1:
        print('Show list');
        contacts = await Contact.loadFromFile('./contacts.json');
        break;
      case 2:
        print('Add new contact');
        break;
      case 3:
        print('Search contact');
        break;
      case 4:
        print('Update contact');
        break;
      case 5:
        print('Delete contact');
        break;
      case 6:
        break;
      default:
        print('Please choose from 1 to 6');
    }
  }
}
