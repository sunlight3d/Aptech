package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookStore {
    private List<Book> inventory = new ArrayList<>();
    public void addBook(Book book){
        inventory.add(book);
    }

    public void displayAllBooks() {
        for (Book eachBook: inventory) {
            eachBook.displayInfo();
        }
    }
    public static Book createBookFromInput() throws InvalidBookDataException {
        Scanner scanner = new Scanner(System.in);
        Book book;
        System.out.println("Enter title: ");
        String title = scanner.nextLine();

        System.out.println("Enter author: ");
        String author = scanner.nextLine();

        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        if(year < 1900) {
            throw new InvalidBookDataException("Year must be > 1900");
        }
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        if(price < 0) {
            throw new InvalidBookDataException("Price must be > 0");
        }
        System.out.println("Novel(1) or TextBook(2)");
        int type = scanner.nextInt();
        if(type == 1) {
            System.out.println("Enter genre: ");
            String genre = scanner.nextLine();
            book = new Novel(title, author, year, price, genre);
        } else if(type == 2) {
            System.out.println("Enter subject: ");
            String subject = scanner.nextLine();
            book = new Textbook(title, author, year, price, subject);
        } else {
            throw new InvalidBookDataException("You must type 1 or 2");
        }
        return book;
    }
}
