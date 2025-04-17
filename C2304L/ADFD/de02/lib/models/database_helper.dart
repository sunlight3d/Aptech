import 'dart:developer';

import 'package:de02/models/contact.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';

class DatabaseHelper {
  //singleton pattern
  static final DatabaseHelper _databaseHelper = DatabaseHelper._internal();
  factory DatabaseHelper() => _databaseHelper;
  DatabaseHelper._internal();
  static Database? _database;
  Future<Database> get database async {
    //init one time only
    if(_database != null) {
      return _database!;
    }
    _database = await initDatabase();
    return _database!;
  }
  Future<Database> initDatabase() async {
    final getDirectory = await getApplicationDocumentsDirectory();
    String path = getDirectory.path + '/contacts.db';
    log(path);
    return await openDatabase(path, onCreate: (Database db, int version) async {
      await db.execute('CREATE TABLE IF NOT EXISTS Contacts(id INTEGER PRIMARY KEY, name TEXT, phoneNumber TEXT, email TEXT)');
    }, version: 1);
  }
  Future<void> insertContact(Contact contact) async {
    final db = await _databaseHelper.database;
    var data = await db.rawInsert('INSERT INTO Contacts(id, name, phoneNumber, email) VALUES(?,?,?,?)',
      [contact.id, contact.name, contact.phoneNumber, contact.email]);
    log('inserted data');
  }
  Future<void> editContact(Contact contact) async {
    final db = await _databaseHelper.database;
    var data = await db.rawUpdate('UPDATE Contacts SET name=?, phoneNumber=?, email=? WHERE id=?',
      [contact.name, contact.phoneNumber, contact.email, contact.id]
    );
    log('Updated user');
  }
  Future<void> deleteUser(String id) async {
    final db = await _databaseHelper.database;
    var data = await db.rawDelete('DELETE FROM Contacts WHERE id=?', [id]);
    log('deleted contact with id = $id');
  }
  Future<List<Contact>> getContacts() async {
    final db = await _databaseHelper.database;
    var data = await db.rawQuery('SELECT * FROM Contacts');
    List<Contact> contacts = List.generate(data.length, (index) => Contact.fromJson(data[index]));
    log('${contacts.length}');
    return contacts;
  }
}