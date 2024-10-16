import 'dart:convert';

import 'package:shared_preferences/shared_preferences.dart';
class CartRepository {
  SharedPreferences? _prefs;

  Future<void> getPreference() async {
    if(_prefs == null) {
      _prefs = await SharedPreferences.getInstance();
    }
  }

  Future<void> addToCart ({
    required int id
  }) async {
    await getPreference();
    if(_prefs?.getKeys().contains('$id') == true) {
      _prefs!.setInt('$id', _prefs!.getInt('$id')! + 1);
    } else {
      _prefs!.setInt('$id',1);
    }
  }
  /*
  Future<void> removeFromCart({
    required int id
  }) async {
    String key = '$id';
    if(_prefs?.getKeys().contains(key) == true) {
      int quantity = _prefs!.getInt(key) ?? 0;
      quantity = quantity - 1;
      if(quantity <= 0) {
        _prefs!.remove(key);
      } else {
        _prefs!.setInt(key, quantity);
      }
    }
   */
  Future<int> getQuantity({required int id}) async {
    await getPreference();
    String key = '$id';
    return _prefs!.getInt(key) ?? 0;
  }

/*
  Future<void> removeFromCart(Map<String, dynamic> item) async {
    final cartItems = getCartItems();
    cartItems.removeWhere((cartItem) => cartItem['id'] == item['id']);
    await _prefs!.setStringList('cart_items', cartItems.map((item) => jsonEncode(item)).toList());
  }

  Future<void> clearCart() async {
    await _prefs!.remove('cart_items');
  }
 */
}