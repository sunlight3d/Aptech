String getInitials(String fullName) {
  if (fullName.isEmpty) return '';

  // Split into words and remove empty strings
  List<String> words = fullName.split(' ').where((word) => word.isNotEmpty).toList();

  // Handle case where there are no valid words
  if (words.isEmpty) return '';

  // Take first letter of each word and join with dots
  return words.map((word) => word[0].toUpperCase()).join('.');
}