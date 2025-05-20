import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:sqlite_mvvm_app/models/contact.dart';
import 'package:sqlite_mvvm_app/utils.dart';
import 'package:sqlite_mvvm_app/utils/string_utils.dart';
import '../viewmodels/contact_view_model.dart';

class ContactList extends StatefulWidget {
  const ContactList({super.key});

  @override
  State<ContactList> createState() => _ContactListState();
}

class _ContactListState extends State<ContactList> {
  final TextEditingController _firstNameController = TextEditingController();
  final TextEditingController _lastNameController = TextEditingController();
  final TextEditingController _phoneNumberController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();

  // Controllers for edit dialog
  final TextEditingController _editFirstNameController = TextEditingController();
  final TextEditingController _editLastNameController = TextEditingController();
  final TextEditingController _editPhoneNumberController = TextEditingController();
  final TextEditingController _editEmailController = TextEditingController();

  @override
  void initState() {
    super.initState();
    Provider.of<ContactViewModel>(context, listen: false).getContacts();
  }

  @override
  void dispose() {
    _firstNameController.dispose();
    _lastNameController.dispose();
    _phoneNumberController.dispose();
    _emailController.dispose();
    _editFirstNameController.dispose();
    _editLastNameController.dispose();
    _editPhoneNumberController.dispose();
    _editEmailController.dispose();
    super.dispose();
  }

  void _clearAddDialogFields() {
    _firstNameController.clear();
    _lastNameController.clear();
    _phoneNumberController.clear();
    _emailController.clear();
  }

  void _clearEditDialogFields() {
    _editFirstNameController.clear();
    _editLastNameController.clear();
    _editPhoneNumberController.clear();
    _editEmailController.clear();
  }

  void _showEditDialog(BuildContext context, Contact contact) {
    // Split name into first and last names if possible
    final nameParts = contact.name.split(' ');
    _editFirstNameController.text = nameParts.isNotEmpty ? nameParts[0] : '';
    _editLastNameController.text = nameParts.length > 1 ? nameParts.sublist(1).join(' ') : '';
    _editPhoneNumberController.text = contact.phoneNumber;
    _editEmailController.text = contact.email;

    showDialog<String>(
      context: context,
      builder: (BuildContext context) => AlertDialog(
        title: const Text('Edit contact'),
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              controller: _editFirstNameController,
              decoration: const InputDecoration(hintText: "Enter first name"),
            ),
            TextField(
              controller: _editLastNameController,
              decoration: const InputDecoration(hintText: "Enter last name"),
            ),
            TextField(
              controller: _editPhoneNumberController,
              keyboardType: TextInputType.phone,
              decoration: const InputDecoration(hintText: "Enter phone"),
            ),
            TextField(
              controller: _editEmailController,
              keyboardType: TextInputType.emailAddress,
              decoration: const InputDecoration(hintText: "Enter email"),
            )
          ],
        ),
        actions: <Widget>[
          TextButton(
            onPressed: () {
              _clearEditDialogFields();
              Navigator.pop(context, 'Cancel');
            },
            child: const Text('Cancel'),
          ),
          TextButton(
            onPressed: () {
              // Validation
              String phone = _editPhoneNumberController.text;
              String email = _editEmailController.text;

              if (phone.isEmpty || email.isEmpty || !isValidEmail(email)) {
                alert(context, 'Input information is invalid');
                return;
              }

              Contact updatedContact = Contact(
                id: contact.id,
                name: '${_editFirstNameController.text} ${_editLastNameController.text}',
                phoneNumber: phone,
                email: email,
              );

              Provider.of<ContactViewModel>(context, listen: false)
                  .updateContact(updatedContact)
                  .then((_) {
                _clearEditDialogFields();
                Navigator.pop(context, 'OK');
              });
            },
            child: const Text('Save'),
          ),
        ],
      ),
    );
  }

  void _confirmDelete(BuildContext context, int contactId) {
    showDialog(
      context: context,
      builder: (BuildContext context) => AlertDialog(
        title: const Text('Delete Contact'),
        content: const Text('Are you sure you want to delete this contact?'),
        actions: <Widget>[
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: const Text('Cancel'),
          ),
          TextButton(
            onPressed: () {
              Provider.of<ContactViewModel>(context, listen: false)
                  .deleteContact(contactId)
                  .then((_) => Navigator.pop(context));
            },
            child: const Text('Delete', style: TextStyle(color: Colors.red)),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    final contactViewModel = Provider.of<ContactViewModel>(context);
    return Scaffold(
      appBar: AppBar(
        title: const Text('Contact'),
        actions: [
          IconButton(
            icon: const Icon(Icons.add),
            tooltip: 'Add contact',
            onPressed: () => showDialog<String>(
              context: context,
              builder: (BuildContext context) => AlertDialog(
                title: const Text('Insert new contact'),
                content: Column(
                  mainAxisSize: MainAxisSize.min,
                  children: [
                    TextField(
                      controller: _firstNameController,
                      decoration: const InputDecoration(hintText: "Enter first name"),
                    ),
                    TextField(
                      controller: _lastNameController,
                      decoration: const InputDecoration(hintText: "Enter last name"),
                    ),
                    TextField(
                      controller: _phoneNumberController,
                      keyboardType: TextInputType.phone,
                      decoration: const InputDecoration(hintText: "Enter phone"),
                    ),
                    TextField(
                      controller: _emailController,
                      keyboardType: TextInputType.emailAddress,
                      decoration: const InputDecoration(hintText: "Enter email"),
                    )
                  ],
                ),
                actions: <Widget>[
                  TextButton(
                    onPressed: () {
                      _clearAddDialogFields();
                      Navigator.pop(context, 'Cancel');
                    },
                    child: const Text('Cancel'),
                  ),
                  TextButton(
                    onPressed: () {
                      // Validation
                      String phone = _phoneNumberController.text;
                      String email = _emailController.text;

                      if (phone.isEmpty || email.isEmpty || !isValidEmail(email)) {
                        alert(context, 'Input information is invalid');
                        return;
                      }

                      Contact contact = Contact(
                        name: '${_firstNameController.text} ${_lastNameController.text}',
                        phoneNumber: phone,
                        email: email,
                      );

                      contactViewModel.insertContact(contact).then((_) {
                        _clearAddDialogFields();
                        Navigator.pop(context, 'OK');
                      });
                    },
                    child: const Text('Save'),
                  ),
                ],
              ),
            ),
          ),
        ],
      ),
      body: Column(
        children: [
          if (contactViewModel.isLoading)
            Expanded(
              child: Center(
                child: CircularProgressIndicator(),
              ),
            )
          else if (contactViewModel.contacts.isEmpty)
            Expanded(
              child: Center(
                child: Text(
                    'No contacts found',
                    style: Theme.of(context).textTheme.titleLarge),
              ),
            )
          else
            Expanded(
              child: ListView.builder(
                itemCount: contactViewModel.contacts.length,
                itemBuilder: (BuildContext context, int index) {
                  Contact contact = contactViewModel.contacts[index];
                  return Container(
                    padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 10),
                    child: Row(
                      children: [
                        CircleAvatar(
                          child: Text(
                            getInitials(contact.name),
                            textAlign: TextAlign.center,
                          ),
                        ),
                        const SizedBox(width: 16),
                        Expanded(
                          child: Column(
                            crossAxisAlignment: CrossAxisAlignment.start,
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              Text(
                                contact.name,
                                style: const TextStyle(fontWeight: FontWeight.bold),
                              ),
                              Text(contact.phoneNumber),
                              Text(
                                contact.email,
                                style: const TextStyle(color: Colors.orange),
                              ),
                            ],
                          ),
                        ),
                        Column(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            IconButton(
                              onPressed: () => _showEditDialog(context, contact),
                              icon: const Icon(Icons.edit, size: 20),
                            ),
                            IconButton(
                              onPressed: () => _confirmDelete(context, contact.id!),
                              icon: const Icon(Icons.delete, size: 20),
                            ),
                          ],
                        ),
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