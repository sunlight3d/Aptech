import 'dart:convert';

import 'package:de02/models/contact.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';
import 'models/coffee.dart';
import 'dart:convert' as convert;
import 'package:http/http.dart' as http;

const baseURL = 'https://api.sampleapis.com';
//https://api.sampleapis.com/coffee/hot
class ApiCall {
  static final ApiCall _instance = ApiCall._internal();
  factory ApiCall() => _instance;
  ApiCall._internal();

  Future<List<Coffee>> getCoffees({String type = 'hot'}) async {
    try {
      var response = await http.get(Uri.parse('$baseURL/coffee/$type'));

      if (response.statusCode == 200) {
        var jsonData = jsonDecode(response.body);

        // Assuming the API returns a list of coffee objects
        if (jsonData is List) {
          return jsonData.map((coffeeJson) => Coffee.fromJson(coffeeJson)).toList();
        }
        // If the API returns a single object wrapped in a response object
        else if (jsonData['data'] is List) {
          return (jsonData['data'] as List).map((coffeeJson) => Coffee.fromJson(coffeeJson)).toList();
        }
        // If the API returns a single coffee object directly
        else if (jsonData is Map<String, dynamic>) {
          return [Coffee.fromJson(jsonData)];
        }

        throw Exception('Unexpected response format');
      } else {
        throw Exception('Failed to load coffees: ${response.statusCode}');
      }
    } catch (e) {
      throw Exception('Failed to load coffees: $e');
    }
  }
}