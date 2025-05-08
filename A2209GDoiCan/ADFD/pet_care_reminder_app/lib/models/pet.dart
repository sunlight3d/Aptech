import 'package:pet_care_reminder_app/models/reminder.dart';

class Pet {
  String name;
  Pet({required this.name, this.reminders});
  late List<Reminder>? reminders;
  factory Pet.fromJson(Map<String, dynamic> json) {
    return Pet(name: json['name']);
  }
  Map<String, dynamic> toJson() {
    return {
      'name': name
    };
  }
}