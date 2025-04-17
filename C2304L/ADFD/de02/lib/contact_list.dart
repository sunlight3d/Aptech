import 'package:de02/models/contact.dart';
import 'package:de02/models/database_helper.dart';
import 'package:flutter/material.dart';

class ContactList extends StatefulWidget {
  ContactList({super.key});
  @override
  State<ContactList> createState() => _ContactListState();
}

class _ContactListState extends State<ContactList> {
  final DatabaseHelper _db = DatabaseHelper(); //inject
  final TextEditingController _firstNameController = TextEditingController();
  final TextEditingController _lastNameController = TextEditingController();
  final TextEditingController _phoneNumberController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Contacts"),
        actions: <Widget>[
          IconButton(
            icon: const Icon(Icons.add),
            tooltip: 'Add',
            onPressed: () {
              showDialog(
                  context: context,
                  builder: (BuildContext context) {
                    return AlertDialog(
                      scrollable: true,
                      title: Text('Add new contact'),
                      content: Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Form(
                          child: Column(
                            children: <Widget>[
                              TextFormField(
                                decoration: InputDecoration(
                                  labelText: 'Enter first name',
                                ),
                                controller: _firstNameController,
                              ),
                              TextFormField(
                                decoration: InputDecoration(
                                  labelText: 'Enter last name',
                                ),
                                controller: _lastNameController,
                              ),
                              TextFormField(
                                keyboardType: TextInputType.phone,
                                decoration: InputDecoration(
                                  labelText: 'Enter phone number',
                                ),
                                controller: _phoneNumberController,
                              ),
                              TextFormField(
                                keyboardType: TextInputType.emailAddress,
                                decoration: InputDecoration(
                                  labelText: 'Enter email',
                                ),
                                controller: _emailController
                              ),
                            ],
                          ),
                        ),
                      ),
                      actions: [
                        ElevatedButton(
                            child: Text("add"),
                            onPressed: () {
                              String _firstName = _firstNameController.text ?? '';
                              String _lastName = _lastNameController.text ?? '';
                              String _phoneNumber = _phoneNumberController.text ?? '';
                              String _email = _emailController.text ?? '';
                            })
                      ],
                    );
                  });
            },
          ),
        ],
      ),
      body: Container(
        child: FutureBuilder<List<Contact>>(future: _db.getContacts(),
            builder: (BuildContext context, AsyncSnapshot<List<Contact>> snapshot) {
          switch (snapshot.connectionState) {
            case ConnectionState.waiting: return Text('Loading....');
            default:
              if (snapshot.hasError) {
                return Text('Error: ${snapshot.error}');
              }               
              else {
                List<Contact> contacts = snapshot.data as List<Contact>;
                return ListView.builder(itemBuilder: (BuildContext context, int index) {
                  Contact contact = contacts[index];
                  return Container(
                    child: Row(
                      children: [
                        Container(
                          decoration: BoxDecoration(
                            color: Colors.black45,
                          ),
                          child: Text(
                            contact.name.split(' ').map((item) => item[0]).toList().join(".").toUpperCase(),
                            style: TextStyle(fontWeight: FontWeight.bold),),
                        ),
                        Column(
                          mainAxisAlignment: MainAxisAlignment.spaceAround,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(contact.name, style: TextStyle(fontWeight: FontWeight.bold, color: Colors.black),),
                            Text(contact.phoneNumber, style: TextStyle(color: Colors.green),),
                            Text(contact.email, style: TextStyle(color: Colors.orange),),
                          ],
                        ),
                        Column(
                          mainAxisAlignment: MainAxisAlignment.spaceAround,
                          crossAxisAlignment: CrossAxisAlignment.center,
                          children: [
                            GestureDetector(child: Icon(
                              Icons.edit,
                              color: Colors.green,
                              size: 30.0,
                            ), onTap: () {

                            },),
                            GestureDetector(child: Icon(
                              Icons.delete,
                              color: Colors.green,
                              size: 30.0,
                            ), onTap: () {

                            },),
                          ],
                        )
                      ],
                    ),
                  );
                });
              }
          }
        }),
      ),
    );
  }
}
