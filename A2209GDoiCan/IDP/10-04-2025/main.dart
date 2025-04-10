import 'dart:io';

import 'contact.dart';

void main() async {
  List<Contact> contacts = [];
  //print(contacts);
  int choice = 0;
  while(choice != 6) {
    print('Enter your choice : ');
    choice = int.parse(stdin.readLineSync() ?? '') ?? 0;
    switch(choice) {
      case 1:
        print('Show list');
        contacts = await Contact.loadFromFile('./contacts.json');
        for(Contact contact in contacts) {
          print(contact);
        }
        break;
      case 2:
        print('Add new contact');
        Contact newContact = Contact.input();
        contacts.add(newContact);
        break;
      case 3:
        print('Search contact');
        print('Enter text to search: ');
        String text = stdin.readLineSync() ?? '';
        List<Contact> filteredContacts = contacts.where(
                (item) => item.name.toLowerCase().contains(text.toLowerCase())
                    || item.phoneNumber.contains(text)
                    || item.email.contains(text)
        ).toList();
        if(filteredContacts.length == 0) {
          print('No contacts found');
        } else {
          for(Contact contact in filteredContacts) {
            print(contact);
          }
        }
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
