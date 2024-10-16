import 'dart:io';

import 'book.dart';
List<Book> books =  [];
void addDocument() {
  print('number of books: ');
  int n = int.parse(stdin.readLineSync() ?? '0');  
  for(int i = 0; i < n; i++) {
    print('Enter information of book : ${i+1}');
    Book book = Book.input();
    books.add(book);
  }
}
void displayAllDocuments() {
  books.forEach((book) {
    print(book);
  });
}
void searchByAuthorName(String authorName) {
  List<Book> filteredBooks = books
            .where((book) => book.authorName == authorName)
            .toList();
  filteredBooks.forEach((book) {
    print(book);
  });
}
void showMenu() {
  int choice = 0;
  while(choice != 4) {
    print('Add New Books');
    print('Display All Books');
    print('Search Books By Author Name');
    print('Exit');
    print('Enter your choice(1-4):');
    choice = int.parse(stdin.readLineSync() ?? '0');
    switch(choice) {
      case 1: 
        addDocument();
        break;
      case 2:
        displayAllDocuments();
        break;
      case 3:
        print('Enter author name to search: ');
        String _authorName = stdin.readLineSync() ?? '';
        searchByAuthorName(_authorName);
        break;
      case 4:
        break;
      default:
        print('Invalid choice, please select 1-4');  
    }
  }
  
}
void main() {
  String firstName = 'Nguyen';
  String lastName = 'Duc Hoang';
  String fullName = '${firstName} ${lastName}';
  print('Your full name is : '+fullName);
  final Book book1 = Book(name: 'C++ programming', authorName: 'Nguyen Van A', price: 12.3);
  book1.name = 'Java Programmmmig';  
  print(book1);  
  showMenu();
}