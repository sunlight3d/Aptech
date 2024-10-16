package com.aptech.data.manager;

import com.aptech.data.IDocument;
import com.aptech.data.impl.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DocumentManager {
    private ArrayList<Book> books = new ArrayList<Book>();
    public void addDocument(){
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.println("Enter number of books : ");
            int numberOfBooks = Integer.valueOf(bufferedReader.readLine());
            for(int i = 0; i < numberOfBooks; i++) {
                Book book = new Book();
                book.input();
                books.add(book);
            }
        }catch (IOException e) {
            System.err.println("Cannot add document, error: "+e.getMessage());
        }
    }
    public void displayAllDocument(){
//        //traditional
//        for(int i = 0; i < books.size(); i++) {
//            Book book = books.get(i);
//            book.show();
//        }
//        //better
//        for(Book book: books) {
//            book.show();
//        }
        //better
        books.forEach((Book book) -> {
            book.show();
        });
    }
    public void searchByAuthorName(String authorName) {
        books.stream()
                .filter((Book book) -> book.getAuthorName().trim()
                            .toLowerCase().equals(authorName.toLowerCase().trim()))
                .toList()
                .forEach((Book book) -> {
                    book.show();
                });
}
}
