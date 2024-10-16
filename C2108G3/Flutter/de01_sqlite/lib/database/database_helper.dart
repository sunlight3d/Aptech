import 'package:productapp/models/my_color.dart';
import 'package:productapp/models/product.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';
import 'dart:async';

class DatabaseHelper {
  //singleton pattern
  static DatabaseHelper? _databaseHelper;
  static Database? _database;

  String productTable = 'products';
  String colorTable = 'colors';
  String sqliteFile = 'products.db';

  DatabaseHelper._createInstance();

  static getInstance() {
    //init 1 time only
    if (_databaseHelper == null) {
      _databaseHelper = DatabaseHelper._createInstance();
    }
    return _databaseHelper!;
  }

  Future<Database?> get database async {
    if (_database == null) {
      _database = await initializeDatabase();
    }
    return _database;
  }

  Future<Database> initializeDatabase() async {
    String path = join(await getDatabasesPath(), sqliteFile);
    var database = await openDatabase(path, version: 1, onCreate: _createDb);
    return database;
  }

  void _createDb(Database db, int newVersion) async {
    await db.execute('''
        CREATE TABLE IF NOT EXISTS $colorTable (
          id INTEGER PRIMARY KEY AUTOINCREMENT,
          name TEXT,
          hexValue TEXT
        )
      ''');
    await db.execute('''
      CREATE TABLE IF NOT EXISTS $productTable (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT,
        code TEXT,
        price REAL,
        colorId INTEGER
      )
    ''');
    var result = await db.rawQuery('SELECT COUNT(*) FROM $colorTable');
    int count = Sqflite.firstIntValue(result) ?? 0;
    if (count == 0) {
      List<MyColor> colors = [
        MyColor(name: 'Pink', hexValue: '#FFC0CB'),
        MyColor(name: 'Yellow', hexValue: '#FFFF00'),
        MyColor(name: 'Purple', hexValue: '#800080'),
        MyColor(name: 'Blue', hexValue: '#0000FF'),
        MyColor(name: 'Green', hexValue: '#00FF00'),
        MyColor(name: 'Red', hexValue: '#FF0000'),
      ];
      Batch batch = db.batch();
      for (MyColor color in colors) {
        batch.insert(colorTable, color.toMap());
      }
      await batch.commit();
    }
  }

  Future<int> insertColor(MyColor myColor) async {
    Database? db = await database;
    var result = await db!.insert(colorTable, myColor.toMap());
    return result;
  }

  Future<List<MyColor>> getColors() async {
    Database? db = await database;
    var result = await db!.query(colorTable);
    List<MyColor> colors = [];
    for (var item in result) {
      colors.add(MyColor.fromMap(item));
    }
    return colors;
  }

  Future<int> insertProduct(Product product) async {
    Database? db = await database;
    var result = await db!.insert(productTable, product.toMap());
    return result;
  }

  Future<List<Product>> getProducts() async {
    Database? db = await database;

    var result = await db!.rawQuery('''
    SELECT ${productTable}.*, ${colorTable}.hexValue
    FROM ${productTable}
    JOIN ${colorTable} ON ${productTable}.colorId = ${colorTable}.id
  ''');

    List<Product> products = [];
    for (var item in result) {
      products.add(Product.fromMap(item));
    }
    return products;
  }

  Future<int> updateProduct(Product product) async {
    Database? db = await this.database;
    var result = await db!.update(
      productTable,
      product.toMap(),
      where: 'id = ?',
      whereArgs: [product.id],
    );
    return result;
  }

  Future<int> deleteProduct(int id) async {
    Database? db = await this.database;
    var result = await db!.delete(
      productTable,
      where: 'id = ?',
      whereArgs: [id],
    );
    return result;
  }

  Future close() async {
    Database? db = await database;
    db!.close();
  }
}