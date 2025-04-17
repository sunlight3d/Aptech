//Contact class with id, name, phoneNumber, and email.
class Contact {
  int id;
  String name;
  String phoneNumber;
  String email;
  Contact({required this.id, required this.name, required this.phoneNumber, required this.email});
  factory Contact.fromJson(Map<String, dynamic> data) =>
      Contact(id: data['id'] ?? 0,
          name: data['name'],
          phoneNumber: data['phoneNumber'],
          email: data['email']
      );
  Map<String, dynamic> toMap() => {
    'id': id,
    'name': name,
    'phoneNumber': phoneNumber,
    'email': email
  };
}
