import 'dart:convert';

import 'package:call_api_mvvm/constants/api_constants.dart';
import 'package:http/http.dart' as http;

import '../models/fruit.dart';

class FruitService {
  final client = http.Client();

  Future<List<Fruit>> getFruits() async {
    final response = await client.get(Uri.parse('$baseUrl/api/fruit/all'));
    if (response.statusCode == 200) {
      final List data = json.decode(response.body);
      return data.map((json) => Fruit.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load fruits');
    }
  }

}
