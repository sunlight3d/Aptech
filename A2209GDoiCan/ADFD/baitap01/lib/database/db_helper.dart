import 'package:baitap01/models/product.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path_provider/path_provider.dart';
import 'package:path_provider/path_provider.dart';
import 'package:path/path.dart';

class DBHelper {
  //singleton pattern
  static final DBHelper _instance = DBHelper._internal();

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
          CREATE TABLE products(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            code TEXT NOT NULL,
            color_hex TEXT NOT NULL,
            name TEXT NOT NULL,
            price REAL DEFAULT 0 NOT NULL
          )
        ''');
      },
    );
  }
  Future<int> insertProduct(Product product) async {
    final dbClient = await db;
    return await dbClient.insert('products', product.toJson());
  }
  Future<int> deleteProduct(String code) async {
    final dbClient = await db;
    return await dbClient.delete(
      'products',
      where: 'code = ?',
      whereArgs: [code],
    );
  }
  Future<List<Product>> getProducts() async {
    final dbClient = await db;
    final List<Map<String, dynamic>> maps = await dbClient.query('products');
    return maps.map((map) => Product.fromJson(map)).toList();
  }

}