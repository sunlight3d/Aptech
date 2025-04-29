import 'dart:ui';

class ColorOption {
  final String name;
  final String hexColor;

  ColorOption({required this.name, required this.hexColor});

  Color get color {
    // Convert hex color to Color object
    String hex = hexColor.replaceAll("#", "");
    if (hex.length == 6) {
      hex = "FF$hex"; // Add opacity if missing
    }
    return Color(int.parse(hex, radix: 16));
  }
}