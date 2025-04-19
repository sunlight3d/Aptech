import 'package:de02/api_call.dart';
import 'package:de02/models/contact.dart';
import 'package:de02/models/database_helper.dart';
import 'package:flutter/material.dart';

import 'contact_detail.dart';

class ContactList extends StatefulWidget {

  ContactList({super.key});
  @override
  State<ContactList> createState() => _ContactListState();
}

class _ContactListState extends State<ContactList> {
  final DatabaseHelper _db = DatabaseHelper();
  final TextEditingController _firstNameController = TextEditingController();
  final TextEditingController _lastNameController = TextEditingController();
  final TextEditingController _phoneNumberController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();
  int? _editingContactId;

  @override
  void dispose() {
    _firstNameController.dispose();
    _lastNameController.dispose();
    _phoneNumberController.dispose();
    _emailController.dispose();
    super.dispose();
  }
  @override
  void initState() {
    // TODO: implement initState
    super.initState();

  }
  Future<void> _refreshContacts() async {
    setState(() {});
  }

  Future<void> _addOrUpdateContact() async {
    final firstName = _firstNameController.text.trim();
    final lastName = _lastNameController.text.trim();
    final phoneNumber = _phoneNumberController.text.trim();
    final email = _emailController.text.trim();

    if (firstName.isEmpty || lastName.isEmpty || phoneNumber.isEmpty || email.isEmpty) {
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Vui lòng điền đầy đủ thông tin')),
      );
      return;
    }

    final contact = Contact(
      id: _editingContactId ?? DateTime.now().millisecondsSinceEpoch,
      name: '$firstName $lastName',
      phoneNumber: phoneNumber,
      email: email,
    );

    if (_editingContactId == null) {
      await _db.insertContact(contact);
    } else {
      await _db.updateContact(contact);
    }

    _clearFields();
    Navigator.of(context).pop();
    await _refreshContacts(); //goi lai list 1 lan nữa
  }

  void _clearFields() {
    _firstNameController.clear();
    _lastNameController.clear();
    _phoneNumberController.clear();
    _emailController.clear();
    _editingContactId = null;
  }

  void _showEditDialog(Contact contact) {
    final names = contact.name.split(' ');
    _firstNameController.text = names.isNotEmpty ? names[0] : '';
    _lastNameController.text = names.length > 1 ? names.sublist(1).join(' ') : '';
    _phoneNumberController.text = contact.phoneNumber;
    _emailController.text = contact.email;
    _editingContactId = contact.id;

    showDialog(
      context: context,
      builder: (BuildContext context) {
        return _buildContactDialog('Chỉnh sửa liên hệ');
      },
    );
  }

  AlertDialog _buildContactDialog(String title) {
    return AlertDialog(
      scrollable: true,
      title: Text(title),
      content: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Form(
          child: Column(
            children: <Widget>[
              TextFormField(
                decoration: const InputDecoration(
                  labelText: 'First name',
                ),
                controller: _firstNameController,
              ),
              TextFormField(
                decoration: const InputDecoration(
                  labelText: 'Lastname',
                ),
                controller: _lastNameController,
              ),
              TextFormField(
                keyboardType: TextInputType.phone,
                decoration: const InputDecoration(
                  labelText: 'Phone number',
                ),
                controller: _phoneNumberController,
              ),
              TextFormField(
                keyboardType: TextInputType.emailAddress,
                decoration: const InputDecoration(
                  labelText: 'Email',
                ),
                controller: _emailController,
              ),
            ],
          ),
        ),
      ),
      actions: [
        TextButton(
          child: const Text("Hủy"),
          onPressed: () {
            _clearFields();
            Navigator.of(context).pop();
          },
        ),
        ElevatedButton(
          child: Text(_editingContactId == null ? "Thêm" : "Cập nhật"),
          onPressed: _addOrUpdateContact,
        ),
      ],
    );
  }
  Future<void> _showDeleteDialog(int contactId) async {
    return showDialog<void>(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: const Text('Xác nhận xóa'),
          content: const Text('Bạn có chắc muốn xóa liên hệ này?'),
          actions: <Widget>[
            TextButton(
              child: const Text('Hủy'),
              onPressed: () => Navigator.of(context).pop(),
            ),
            TextButton(
              child: const Text('Xóa', style: TextStyle(color: Colors.red)),
              onPressed: () async {
                await _db.deleteContact(contactId);
                Navigator.of(context).pop();
                await _refreshContacts();
              },
            ),
          ],
        );
      },
    );
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Danh bạ"),
        actions: <Widget>[
          IconButton(
            icon: const Icon(Icons.add),
            tooltip: 'Thêm mới',
            onPressed: () {
              _clearFields();
              showDialog(
                context: context,
                builder: (BuildContext context) {
                  return _buildContactDialog('Thêm liên hệ mới');

                },
              );
            },
          ),
        ],
      ),
      body: FutureBuilder<List<Contact>>(
        future: _db.getContacts(),
        builder: (BuildContext context, AsyncSnapshot<List<Contact>> snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator());
          }
          if (snapshot.hasError) {
            return Center(child: Text('Lỗi: ${snapshot.error}'));
          }

          final contacts = snapshot.data ?? [];
          return ListView.builder(
            itemCount: contacts.length,
            itemBuilder: (BuildContext context, int index) {
              final contact = contacts[index];
              return Card(
                margin: const EdgeInsets.all(8.0),
                child: ListTile(
                  leading: CircleAvatar(
                    child: Text(
                      contact.name
                          .split(' ')
                          .map((s) => s.isNotEmpty ? s[0] : '')
                          .take(2)
                          .join()
                          .toUpperCase(),
                    ),
                  ),
                  title: Text(contact.name),
                  subtitle: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(contact.phoneNumber),
                      Text(contact.email),
                    ],
                  ),
                  trailing: Row(
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      IconButton(
                        icon: Icon(Icons.edit, color: Colors.blue),
                        onPressed: () => _showEditDialog(contact),
                      ),
                      IconButton(
                        icon: Icon(Icons.delete, color: Colors.red),
                        onPressed: () => _showDeleteDialog(contact.id),
                      ),
                    ],
                  ),
                  onTap: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => ContactDetailScreen(contact: contact),
                      ),
                    );
                  },
                ),
              );
            },
          );
        },
      ),
    );
  }
}