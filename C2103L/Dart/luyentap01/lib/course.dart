import 'dart:convert';
import 'dart:io';

class Course {
  late String authorName;
  late String courseName;
  late int price;
  late String address;
  late String description;
  late String startedDate;
  Course();
  void input(int index) {
    print('Input detail information of course (${index}): ');
    print('Input author name :');
    this.authorName = stdin.readLineSync()!;

    print('Input course name :');
    this.courseName = stdin.readLineSync()!;

    print('Input price :');
    this.price = int.parse(stdin.readLineSync()!);

    print('Input course’s address:');
    this.address = stdin.readLineSync()!;

    print('Input description :');
    this.description = stdin.readLineSync()!;

    print('Input started date(yyyy-mm-dd):');
    this.startedDate = stdin.readLineSync()!;
  }
  @override
  //This is a one-line/arrow function
  /*
  String toString() =>
      "author's name: ${authorName},\n"+
      "course's name: ${courseName},\n"+
      "address: ${address},\n"+
      "price: ${price},\n"+
      "description: ${description},\n"+
      "startedDate: ${startedDate},\n";
   */
  String toString() => '${authorName}('
                        '${courseName}, '
                        '${price}, '
                        '${address}, '
                        '${description}, '
                        '${startedDate})';
  Map<String, dynamic> toMap() {
    return {
      'authorName': authorName,
      'courseName': courseName,
      'price': price,
      'address': address,
      'description': description,
      'startedDate': startedDate,
    };
  }
}