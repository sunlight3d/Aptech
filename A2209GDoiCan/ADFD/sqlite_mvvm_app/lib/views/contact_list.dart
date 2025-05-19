import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

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
    return Scaffold(
      body: Column(
        children: [
          Expanded(child: ListView())
        ],
      ),
    );
  }
}
