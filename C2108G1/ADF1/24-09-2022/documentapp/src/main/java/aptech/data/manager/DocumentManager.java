package aptech.data.manager;

import aptech.data.impl.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.function.Predicate;

public class DocumentManager {
    private ArrayList<Book> books = new ArrayList<>();
    void addDocument(){

    }
    void displayAllDocument(){

    }
    void searchByAuthorName(String authorName){
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
        for (Book eachBook: this.books) {
            if(eachBook.getAuthorName().toLowerCase().equals(authorName.toLowerCase())) {
                booksResult.add(eachBook);
            }
        }
        //use stream in Java8
        booksResult = (ArrayList<Book>) this.books
                .stream()
                .filter(new Predicate<Book>() {
                    @Override
                    public boolean test(Book book) {
                        return book.getAuthorName().toLowerCase().equals(authorName.toLowerCase());
                    }
                })
                .toList();
        //use stream + lambda expression + oneline function
        booksResult = (ArrayList<Book>) this.books
                .stream()
                .filter((Book book) -> book.getAuthorName()
                        .toLowerCase()
                        .equals(authorName.toLowerCase()))
                .toList();
        //show result
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
        books.add(new Book(2, "c#", "Afdijfi", 12.3f));
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
