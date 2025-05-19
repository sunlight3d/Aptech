import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sqlite_mvvm_app/models/contact.dart';
import 'package:sqlite_mvvm_app/utils/string_utils.dart';

import '../viewmodels/contact_view_model.dart';

class ContactList extends StatefulWidget {
  const ContactList({super.key});

  @override
  State<ContactList> createState() => _ContactListState();
}

class _ContactListState extends State<ContactList> {
  @override
  void initState() {
    // TODO: implement initState
    super.initState();

    Provider.of<ContactViewModel>(context, listen: false).getContacts();
  }
  @override
  Widget build(BuildContext context) {
    final contactViewModel = Provider.of<ContactViewModel>(context);
    return Scaffold(
      body: Column(
        children: [
          if (contactViewModel.isLoading)
            Expanded(
              child: Center(
                child: CircularProgressIndicator(), // Or your custom loading widget
              ),
            )
          else
            Expanded(
              child: ListView.builder(
                itemCount: contactViewModel.contacts.length,
                itemBuilder: (BuildContext context, int index) {
                  Contact contact = contactViewModel.contacts[index];
                  return ListTile(
                    leading: CircleAvatar(
                      child: Text(
                        getInitials(contact.name),
                        style: TextStyle(
                          fontSize: 20,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ),
                    title: Text(
                      contact.name,
                      style: TextStyle(
                        fontSize: 16,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    subtitle: Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(contact.phoneNumber),
                        Text(
                          contact.email,
                          style: TextStyle(color: Colors.orange),
                        ),
                      ],
                    ),
                    trailing: Column(
                      children: [
                        IconButton(onPressed: () {

                        }, icon: Icon(Icons.add)),
                        IconButton(onPressed: () {

                        }, icon: Icon(Icons.delete))
                      ],
                    ),
                  );
                },
              ),
            ),
        ],
      ),
    );
  }
}
