import 'dart:convert';
import 'package:apiapp/configuration.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

class UserRepository {
  final String apiUrl = '${Configuration.baseUrl}users/login';
  final Map<String, String> headers = {'Content-Type': 'application/json'};

  Future<String> login(String phoneNumber, String password) async {
    final Map<String, String> body = {
      'phone_number': phoneNumber,
      'password': password,
    };

    try {
      final http.Response response = await http.post(
        Uri.parse(apiUrl),
        headers: headers,
        body: jsonEncode(body),
      );

      if (response.statusCode == 200) {
        final Map<String, dynamic> data = jsonDecode(response.body);
        final String token = data['token'];
        return token;
      } else {
        throw 'Error: ${response.statusCode}';
      }
    } catch (e) {
      throw 'Error: $e';
    }
  }
}