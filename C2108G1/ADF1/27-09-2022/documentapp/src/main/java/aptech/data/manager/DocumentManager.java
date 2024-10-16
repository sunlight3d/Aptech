package aptech.data.manager;

import aptech.data.impl.Book;

import java.util.*;
import java.util.function.Predicate;

public class DocumentManager {
    private ArrayList<Book> books = new ArrayList<>();
    void addDocument(){
        Book book = new Book();
        book.input();
        books.add(book);
    }
    void displayAllDocument(){
        for (Book book: this.books) {
            book.show();
        }
    }
    public void showMenu(){

        int choice = 0;
        do {
            System.out.println("------------------------------------------------");
            System.out.println("1. Add new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search books by author's name");
            System.out.println("4. Exit");
            System.out.println("------------------------------------------------");
            System.out.println("Enter your choice: ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1: {
                    addDocument();
                    break;
                }
                case 2: {
                    displayAllDocument();
                    break;
                }
                case 3: {
                    searchByAuthorName();
                    break;
                }
                case 4: {
                    break;
                }
                default:
                    System.out.println("Please enter 1-4");
                    break;
            }
        }while (choice != 4);
        System.out.println("Program ended");
    }
    void searchByAuthorName(){
        System.out.println("Please enter author's name to search: ");
        String authorName = (new Scanner(System.in)).next();
        //common method
        ArrayList<Book> booksResult = new ArrayList<>();
        /*
        for(int i = 0; i < books.size(); i++) {
            Book eachBook = books.get(i);
            String eachAuthorName = eachBook.getAuthorName();
            if(eachAuthorName.toLowerCase().equals(authorName.toLowerCase())) {
                booksResult.add(eachBook);
            }
        }
        */
        /*
        for (Book eachBook: this.books) {
            if(eachBook.getAuthorName().toLowerCase().equals(authorName.toLowerCase())) {
                booksResult.add(eachBook);
            }
        }
         */
        //use stream in Java8
        /*
        booksResult = new ArrayList<>(this.books
                .stream()
                .filter(new Predicate<Book>() {
                    @Override
                    public boolean test(Book book) {
                        return book.getAuthorName().toLowerCase().equals(authorName.toLowerCase());
                    }
                })
                .toList());
         */
        //use stream + lambda expression + oneline function
        booksResult = new ArrayList<>(this.books
                .stream()
                .filter((Book book) -> book.getAuthorName()
                        .toLowerCase()
                        .equals(authorName.toLowerCase()))
                .toList());

        //show result
        System.out.println("We found "+booksResult.size()+ " books");
        for (Book book: booksResult) {
            book.show();
        }
    }
    public void analyze(){
        /*
        "Java" : 2 items
        "C#": 1 item
        * */
        Hashtable<String, Integer> hashMap = new Hashtable<String, Integer>();
        for (Book book: books) {
            /*
            String bookName = book.getBookName().toLowerCase();
            if(!hashMap.containsKey(bookName)) {
                hashMap.put(bookName, 1);
            } else {
                hashMap.put(bookName, hashMap.get(bookName) + 1);
            }
             */
            hashMap.put(book.getBookName().toLowerCase(),
                    !hashMap.containsKey(book.getBookName().toLowerCase()) ? 1
                    : hashMap.get(book.getBookName().toLowerCase()) + 1);
        }
        //iterate a hashmap in Java
        for (Map.Entry<String, Integer> set : hashMap.entrySet()) {
            System.out.println(set.getKey() + ": "
                    +set.getValue()+
                    (set.getValue() > 1 ? " items" : " item"));
        }
    }
    public void fakeData() {
        books.add(new Book(1, "java", "Andrew", 12.3f));
        books.add(new Book(2, "c#", "jaja", 12.3f));
        books.add(new Book(3, "java", "Andrew", 12.3f));
        books.add(new Book(4, "Java", "Andrew", 12.3f));
        books.add(new Book(5, "c++", "Andrew", 12.3f));
        books.add(new Book(6, "python", "Andrew", 12.3f));
        books.add(new Book(7, "winform", "Andrew", 12.3f));
        books.add(new Book(8, "swift", "Andrew", 12.3f));
        books.add(new Book(9, "python", "Andrew", 12.3f));
        books.add(new Book(10, "Go", "Andrew", 12.3f));
        books.add(new Book(11, "go", "Andrew", 12.3f));
    }
}
