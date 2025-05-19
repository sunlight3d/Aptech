import 'package:sqflite/sqflite.dart';
import 'package:path_provider/path_provider.dart';
import 'package:path_provider/path_provider.dart';
import 'package:path/path.dart';
import 'package:sqlite_mvvm_app/models/contact.dart';

class DBHelper {
  //singleton pattern
  static final DBHelper _instance = DBHelper._internal();
  static final String TABLE_CONTACT = "contacts";
  factory DBHelper() => _instance;
  DBHelper._internal();
  static Database? _db;
  Future<Database> get db async {
    if (_db != null) return _db!;
    _db = await _initDb();
    return _db!;
  }
  Future<Database> _initDb() async {
    final path = join(await getDatabasesPath(), 'mydb.db');
    return await openDatabase(
      path,
      version: 1,
      onCreate: (Database db, int version) async {
        await db.execute('''
          CREATE TABLE $TABLE_CONTACT(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            phoneNumber TEXT NOT NULL,
            email TEXT NOT NULL            
          )
        ''');
      },
    );
  }
  Future<int> insertContact(Contact contact) async {
    final dbClient = await db;
    return await dbClient.insert(TABLE_CONTACT, contact.toJson());
  }
  Future<int> deleteContact(String code) async {
    final dbClient = await db;
    return await dbClient.delete(
      'contacts',
      where: 'code = ?',
      whereArgs: [code],
    );
  }
  Future<List<Contact>> getContacts() async {
    final dbClient = await db;
    final List<Map<String, dynamic>> maps = await dbClient.query(TABLE_CONTACT);
    return maps.map((map) => Contact.fromJson(map)).toList();
  }

}