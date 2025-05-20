import 'package:sqflite/sqflite.dart';
import 'package:sqlite_mvvm_app/database/db_helper.dart';
import 'package:sqlite_mvvm_app/models/contact.dart';

class ContactRepository {
  final DBHelper _dbHelper = DBHelper();

  Future<Database> get _db async => await _dbHelper.db;

  // In ContactRepository
  Future<int> insertContact(Contact contact) async {
    final db = await _db;
    print('Inserting contact: ${contact.toJson()}');  // Debug print
    return await db.insert(DBHelper.TABLE_CONTACT, contact.toJson());
  }

  // Read
  Future<List<Contact>> getContacts() async {
    try {
      final db = await _db;
      final List<Map<String, dynamic>> maps = await db.query(DBHelper.TABLE_CONTACT);
      print('Retrieved ${maps.length} contacts');  // Debug print
      return maps.map((map) => Contact.fromJson(map)).toList();
    } catch(e) {
      print('Error getting contacts: $e');  // Debug print
      return [];
    }
  }

  Future<Contact?> getContactById(int id) async {
    final db = await _db;
    final List<Map<String, dynamic>> maps = await db.query(
      DBHelper.TABLE_CONTACT,
      where: 'id = ?',
      whereArgs: [id],
      limit: 1,
    );

    if (maps.isNotEmpty) {
      return Contact.fromJson(maps.first);
    }
    return null;
  }

  // Update
  Future<int> updateContact(Contact contact) async {
    final db = await _db;
    return await db.update(
      DBHelper.TABLE_CONTACT,
      contact.toJson(),
      where: 'id = ?',
      whereArgs: [contact.id],
    );
  }

  // Delete
  Future<int> deleteContact(int id) async {
    final db = await _db;
    return await db.delete(
      DBHelper.TABLE_CONTACT,
      where: 'id = ?',
      whereArgs: [id],
    );
  }

  // Additional useful operations
  Future<int> getContactCount() async {
    final db = await _db;
    final count = Sqflite.firstIntValue(
        await db.rawQuery('SELECT COUNT(*) FROM ${DBHelper.TABLE_CONTACT}')
    );
    return count ?? 0;
  }

  Future<void> close() async {
    final db = await _db;
    await db.close();
  }
}