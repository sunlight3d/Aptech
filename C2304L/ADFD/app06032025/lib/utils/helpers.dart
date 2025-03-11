import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void alert({required BuildContext context, required String content, VoidCallback? onPressed}) {
  showDialog(
      context: context,
      builder: (_) {
        return AlertDialog(
          title: Text('Alert'),
          content: Text(content),
          actions: [
            TextButton(onPressed: onPressed, child: Text('OK'))
          ],
        );
      }
  );
}