package aptech.data.manager;

import aptech.data.impl.Book;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class DocumentManager {
    private ArrayList<Book> books = new ArrayList<>();
    public void addDocument() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of books: ");
        int numberOfBooks = scanner.nextInt();
        for(int i = 0; i < numberOfBooks; i++) {
            Book book = new Book();//tao ra doi tuong Book trong, chua co thong tin gi
            System.out.println(String.format("Book %d", i+1));
            book.input();
            books.add(book);
        }
    }
    public void displayAllDocument() {
        //có mấy cách duyệt mảng sau đây, dung 1 trong 3 cach
        //1.cách truyền thống:
//        for(int i = 0; i < books.size() - 1; i++) {
//            Book book = books.get(i);
//            book.show();
//        }
        //2.dung "iterate" cua Java(hoi giong PHP), ko can bien i
        for(Book book: this.books) {
            book.show();
        }
        //3 dung lambda expression, nhin hoi giong forEach cua JS
//        this.books.forEach(book -> {
//            book.show();
//        });
    }
    public void searchByAuthorName(String authorName) {
        //thuat toan lam the nao ?. Moi nguoi cung suy nghi mot chut nhe
        //cach 1: duyet qua tat ca phan tu trong array => neu co thi cho vao mang ket qua
        /*
        ArrayList<Book> result = new ArrayList<>();
        for(Book book: this.books) {
            if(book.getAuthorName().equals(authorName.trim())) {
                result.add(book);
                book.show();
            }
        }
        */
        //cach 2: su dung filter, toc do nhanh hon vi tan dung ham san co cua java
        //stream co tu Java >= 8
        List<Book> result = (List<Book>) this.books
                                    .stream()
                                    .filter(book -> book.getAuthorName()
                                    .equals(authorName.trim()))
                                    .toList();

        for(Book book: result) {
            book.show();
        }
    }
}
