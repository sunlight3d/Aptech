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
      'phone_number': phoneNumber,
      'email': email
    };
  }
  factory Contact.fromJson(Map<String, dynamic> map) {
    return Contact(
        id: int.parse(map['id']),
        name: map['name'] as String,
        phoneNumber: map['phone_number'],
        email: map['email']
    );
  }
}