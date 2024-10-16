package com.product.test;

import com.product.books.Book;
import com.product.computers.Computer;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.product.Helper.getScanner;

public class Test {
    public static void main(String [] args) {
        int choice = 0;
        List<Computer> computers = new ArrayList<Computer>();
        List<Book> books = new ArrayList<Book>();
        int numberOfComputers = 0;
        int numberOfBooks = 0;

        while (choice != 5) {
            System.out.println("Please select:");
            System.out.println("1.Input information for n Computers.");
            System.out.println("2.Input information for n Books.");
            System.out.println("3.Display information of n Computers by sorting the");
            System.out.println("price descending.");
            System.out.println("4. Display information of n Books by sorting the");
            System.out.println("publisher ascending.");
            System.out.println("5.Exit.");
            System.out.println("Your choice:");
            choice = getScanner().nextInt();

            switch (choice) {
                case 1:
                    //System.out.println("case 1");
                    System.out.println("Numbers of computers: ");
                    numberOfComputers = getScanner().nextInt();
                    for (int i = 0; i < numberOfComputers; i++) {
                        Computer computer = new Computer();
                        computer.input();
                        computers.add(computer);
                    }
                    break;
                case 2:
                    //System.out.println("case 2");
                    System.out.println("Numbers of books: ");
                    numberOfBooks = getScanner().nextInt();
                    for (int i = 0; i < numberOfBooks; i++) {
                        Book book = new Book();
                        book.input();
                        books.add(book);
                    }
                    break;
                case 3:
                    //System.out.println("case 3");
                    //sort and change computers
                    /*
                    computers.sort((Computer computer1, Computer computer2)
                            -> (int)(computer2.getPrice() - computer1.getPrice()));
                    computers.forEach(Computer::display);
                    */
                    //unchange computers, create new separated list
                    //fake data
                    computers = Arrays.asList(new Computer[] {
                            new Computer("1", "c1", 2021, 112f, "s1","Apple"),
                            new Computer("2", "c2", 2021, 200f, "s1","Apple"),
                            new Computer("3", "c3", 2021, 100f, "s1","Apple"),
                            new Computer("4", "c4", 2021, 300f, "s1","Apple")
                    });
                    computers.stream()
                            .sorted((Computer computer1, Computer computer2)
                                -> (int)(computer2.getPrice() - computer1.getPrice()))
                            .toList()
                            .forEach(Computer::display);
                    break;
                case 4:
                    books = Arrays.asList(new Book[] {
                            new Book("1", "c1", 2021, 112f, "techno","Apple"),
                            new Book("2", "c2", 2021, 200f, "techno","Dell"),
                            new Book("3", "c3", 2021, 100f, "techno","Asus"),
                            new Book("4", "c4", 2021, 300f, "techno","Intel")
                    });

                    books.stream()
                            .sorted(Comparator.comparing(Book::getPublisher))
                            .toList()
                            .forEach(Book::display);
                    break;
                case 5:
                    System.out.println("case 5");
                    break;
                default:
                    System.err.println("please select 1-5");
                    break;
            }
        }

    }
}
