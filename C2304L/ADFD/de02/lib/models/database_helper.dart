import 'package:de02/models/contact.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';

class DatabaseHelper {
  // Singleton pattern - giữ nguyên cách bạn đang làm
  static final DatabaseHelper _instance = DatabaseHelper._internal();
  factory DatabaseHelper() => _instance;
  DatabaseHelper._internal();

  static Database? _database;

  Future<Database> get database async {
    if (_database != null) return _database!;
    _database = await _initDatabase();
    return _database!;
  }

  Future<Database> _initDatabase() async {
    final databasesPath = await getDatabasesPath();
    final path = join(databasesPath, 'contacts.db'); //db path

    return await openDatabase(
      path,
      version: 1,
      onCreate: (db, version) async {
        await db.execute('''
          CREATE TABLE Contacts(
            id INTEGER PRIMARY KEY,
            name TEXT NOT NULL,
            phoneNumber TEXT NOT NULL,
            email TEXT NOT NULL
          )
        ''');
      },
    );
  }

  // Thêm contact và trả về id của contact vừa thêm
  Future<int> insertContact(Contact contact) async {
    final db = await database;
    return await db.insert('Contacts', contact.toMap());
  }

  // Lấy tất cả contacts
  Future<List<Contact>> getContacts() async {
    final db = await database;
    final List<Map<String, dynamic>> maps = await db.query('Contacts');
    return List.generate(maps.length, (i) => Contact.fromJson(maps[i]));
  }

  // Cập nhật contact
  Future<int> updateContact(Contact contact) async {
    final db = await database;
    return await db.update(
      'Contacts',
      contact.toMap(),
      where: 'id = ?',
      whereArgs: [contact.id],
    );
  }

  // Xóa contact
  Future<int> deleteContact(int id) async {
    final db = await database;
    return await db.delete(
      'Contacts',
      where: 'id = ?',
      whereArgs: [id],
    );
  }

  // Đóng database khi không dùng (optional)
  Future<void> close() async {
    final db = await database;
    db.close();
  }
}