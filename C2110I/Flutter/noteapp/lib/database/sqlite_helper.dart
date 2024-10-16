import 'package:flutter/material.dart';
import 'package:noteapp/models/note.dart';
import 'package:path/path.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path_provider/path_provider.dart';

class SQLiteHelper extends ChangeNotifier {
  static final _databaseName = 'notes_database.db';
  static final _databaseVersion = 1;

  static final table = 'notes';

  static final columnId = 'id';
  static final columnContent = 'content';
  static final columnIsImportant = 'is_important';
  static final columnCreatedAt = 'created_at';

  // Database object
  late Database _database;

  Future<Database> get database async {
    if (_database != null) return _database;

    // If _database is null, initialize it
    _database = await _initDatabase();
    return _database;
  }

  // Open the database (create if it doesn't exist)
  _initDatabase() async {
    final documentsDirectory = await getApplicationDocumentsDirectory();
    final path = join(documentsDirectory.path, _databaseName);
    return await openDatabase(
      path,
      version: _databaseVersion,
      onCreate: _onCreate,
    );
  }
  List<Note> get _fakeNotes => <Note>[
    Note(content: 'Di choi', isImportant: true),
    Note(content: 'Di choi', isImportant: true),
    Note(content: 'LKam bt javas', isImportant: false),
    Note(content: 'Code C#', isImportant: true),
    Note(content: 'Lam android', isImportant: false),
    Note(content: 'Viet CV', isImportant: true),
    Note(content: 'Di xin viec', isImportant: false),
    Note(content: 'Tu hat mot minh', isImportant: true),
    Note(content: 'Dancing', isImportant: true),
    Note(content: 'Go out', isImportant: true),
    Note(content: 'Len thu vien', isImportant: false),
  ];
  // Create the database table
  Future<void> _onCreate(Database db, int version) async {
    // Check if the table exists
    var tableExists = await db.rawQuery(
        "SELECT name FROM sqlite_master WHERE type='table' AND name='$table'");
    if (tableExists.isEmpty) {
      await db.execute('''
      CREATE TABLE $table (
        $columnId INTEGER PRIMARY KEY AUTOINCREMENT,
        $columnContent TEXT NOT NULL,
        $columnIsImportant INTEGER NOT NULL,
        $columnCreatedAt TEXT NOT NULL
      )
      ''');
      final count = Sqflite.firstIntValue(
        await db.rawQuery('SELECT COUNT(*) FROM $table'),
      );
      if(count == 0) {
        for(int i = 0; i < _fakeNotes.length; i++) {
          insert(_fakeNotes[i]);
        }
      }
    }
  }


  // Insert a Note into the database
  Future<int> insert(Note note) async {
    Database db = await database;
    return await db.insert(table, note.toMap());
  }

  // Retrieve all Notes from the database
  Future<List<Note>> getAllNotes() async {
    Database db = await database;
    final List<Map<String, dynamic>> maps = await db.query(table);
    return List.generate(maps.length, (i) {
      return Note.fromMap(maps[i]);
    });
  }

  // Update a Note in the database
  Future<int> update(Note note) async {
    Database db = await database;
    return await db.update(
      table,
      note.toMap(),
      where: '$columnId = ?',
      whereArgs: [note.id],
    );
  }

  // Delete a Note from the database
  Future<int> delete(int id) async {
    Database db = await database;
    return await db.delete(
      table,
      where: '$columnId = ?',
      whereArgs: [id],
    );
  }

  // Close the database
  Future<void> close() async {
    Database db = await database;
    db.close();
  }
}
