import 'package:flutter/material.dart';

class Alert {
  static void showSnackbar({BuildContext this.context}) {
    final snackBar = SnackBar(
      content: const Text('You pressed red'),
      action: SnackBarAction(
        label: 'OK',
        onPressed: () {
          // Some code to undo the change.
        },
      ),
    );
    ScaffoldMessenger.of(context).showSnackBar(snackBar);
  }
}