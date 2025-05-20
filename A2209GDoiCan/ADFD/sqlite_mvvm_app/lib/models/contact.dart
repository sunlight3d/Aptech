class Contact {
  int? id;
  String name;
  String phoneNumber;
  String email;

  Contact({
    this.id,
    required this.name,
    required this.phoneNumber,
    required this.email
  });
  Map<String, dynamic> toJson() {
    return {
      'id': id,
      'name': name,
      'phoneNumber': phoneNumber,  // Changed from 'phone_number' to 'phoneNumber'
      'email': email
    };
  }
  factory Contact.fromJson(Map<String, dynamic> map) {
    return Contact(
        id: map['id'] as int? ?? int.tryParse(map['id'].toString()),
        name: map['name'] as String,
        phoneNumber: map['phoneNumber'] as String,  // Changed from 'phone_number'
        email: map['email'] as String
    );
  }
}