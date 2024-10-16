class Note {
  int? id;
  String content;
  bool isImportant;
  late DateTime createdAt;
  Note({
    this.id,
    required this.content,
    required this.isImportant,
  }) : createdAt = DateTime.now(); // Gán thời gian hiện tại cho createdAt
  // Convert a Note object into a Map for database operations
  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'content': content,
      'is_important': isImportant ? 1 : 0, // Store boolean as integer
      'created_at': createdAt.toIso8601String(), // Store DateTime as ISO8601 string
    };
  }

  // Create a Note object from a Map
  factory Note.fromMap(Map<String, dynamic> map) {
    return Note(
      id: int.parse(map['id']),
      content: map['content'],
      isImportant: map['is_important'] == 1
    );
  }

}