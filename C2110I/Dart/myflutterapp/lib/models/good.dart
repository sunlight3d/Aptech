import 'package:myflutterapp/utilities/utility.dart';

abstract class Good {
  int id = 0;
  String? _name = "No name";
  Good(this.id, String name) {
    _name = name;
  }
  set name(String newName) {
    if(newName.length < 3) {
      throw Exception("Name must be at least 3 characters");
    }
    _name = newName;
  }
  String get name => _name ?? "";
  //get String name => _name ?? "";
  void showInfo() {
    Utility.print('id = $id, name = $_name');
  }
}
