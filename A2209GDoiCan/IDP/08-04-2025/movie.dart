import 'dart:convert';
import 'dart:ffi';

class Movie {
  String title;
  String director;
  int? durationInMinute;
  double get getDurationInHours => (durationInMinute ?? 0) / 60;
  String getRatingCategory(double rating) {
    if (rating >= 8) {
      return "Exellent";
    } else if (rating >= 5 && rating < 8) {
      return "Good";
    } else if (rating < 5) {
      return "Poor";
    }
    return "Unknown";
  }

  String toJson() {
    return {
      title: this.title,
      director: this.director,
      durationInMinute: this.durationInMinute ?? 0,
    }.toString();
  }

  Map fromJson(String jsonData) {
    Map map = json.decode(jsonData);
    map["title"] = map[title] as String;
    map["director"] = map[director] as String;
    map["durationInMinute"] =
        (map[durationInMinute] as int) < 0
            ? throw Exception("Invalid value")
            : (map[durationInMinute] as int);
    return map;
  }

  Movie({required this.title, required this.director, this.durationInMinute});
}
