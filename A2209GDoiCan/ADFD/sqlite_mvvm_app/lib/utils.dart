import 'package:flutter/material.dart';

bool isValidEmail(String email) =>
      RegExp(r"^[a-zA-Z0-9.a-zA-Z0-9.!#$%&'*+-/=?^_`{|}~]+@[a-zA-Z0-9]+\.[a-zA-Z]+")
        .hasMatch(email);
void alert(BuildContext context, content) => ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text(content)));