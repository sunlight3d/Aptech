import 'package:sqflite/sqflite.dart';
import 'package:sqlite_mvvm_app/database/db_helper.dart';
import 'package:sqlite_mvvm_app/models/contact.dart';

class ContactRepository {
  final DBHelper _dbHelper = DBHelper();

  Future<Database> get _db async => await _dbHelper.db;

  // Create
  Future<int> insertContact(Contact contact) async {
    final db = await _db;
    return await db.insert(DBHelper.TABLE_CONTACT, contact.toJson());
  }

  // Read
  Future<List<Contact>> getContacts() async {
    final db = await _db;
    final List<Map<String, dynamic>> maps =
    await db.query(DBHelper.TABLE_CONTACT);
    return maps.map((map) => Contact.fromJson(map)).toList();
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