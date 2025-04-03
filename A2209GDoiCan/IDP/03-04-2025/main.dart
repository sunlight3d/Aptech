import 'dart:io';

void question1a() {
  String s = '';
  print('Enter a string: ');
  s = stdin.readLineSync() ?? '';
  List<String> words = s.toLowerCase().split(RegExp(r"\s+"));
  words =
      words.map((item) {
        return '${item[0].toUpperCase()}${item.substring(1)}';
      }).toList();
  String result = words.join(' ');
  print('result is ${result}');
}

void question1b() {
  int currentYear = DateTime.now().year;
  int year;
  print('Enter a year: ');
  year = int.tryParse(stdin.readLineSync() ?? '1970') ?? 1970;
  if (year < 1888 || year > currentYear) {
    print('Invalid year, year must be from 1888 to now');
  }
}

void question1c() {
  String strGenres = '';
  print('input a comma-separated list of movie genres');
  strGenres = stdin.readLineSync() ?? '';
  Map<String, int> map = Map();
  List<String> genres = strGenres.toLowerCase().split(RegExp(r"\s+"));
  for (String genre in genres) {
    map[genre] = map.containsKey(genre) ? map[genre]! + 1 : 1;
  }
  map.forEach((key, value) {
    print('Genre with name: ${key} occurs ${value} times');
  });
}

void main() {
  //question1a();
}
