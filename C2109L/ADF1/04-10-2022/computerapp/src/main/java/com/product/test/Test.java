package com.product.test;

import com.product.Product;
import com.product.books.Book;
import com.product.computers.Computer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        int choice = 0;
        ArrayList<Computer> computers = new ArrayList<Computer>();
        ArrayList<Book> books = new ArrayList<Book>();
        //fake data
//        String prodId, String prodName, int year, float price,
//        String speed, String producer
//        computers.add(new Computer("c111", "cc1111", 1980,
//                12.3f, "spp", "dell"));
//        computers.add(new Computer("c222", "cc1111", 1980,
//                33.3f, "spp", "dell"));
//        computers.add(new Computer("c333", "cc1111", 1980,
//                10.3f, "spp", "dell"));
//        computers.add(new Computer("c444", "cc1111", 1980,
//                55.3f, "spp", "dell"));
//        books.add(new Book("b11", "b11", 2000,
//                11.2f, "novel","aptech"));
//        books.add(new Book("b11", "b11", 2000,
//                11.2f, "novel","zoooo"));
//        books.add(new Book("b11", "b11", 2000,
//                11.2f, "novel","bokajdj"));
        while(choice != 5) {
            System.out.println("Please select:");
            System.out.println("1.Input information for n Computers.");
            System.out.println("2.Input information for n Books.");
            System.out.println("3.Display information of n Computers by sorting the");
            System.out.println("price descending.");
            System.out.println("4. Display information of n Books by sorting the");
            System.out.println("publisher ascending.");
            System.out.println("5.Exit.");
            System.out.println("Your choice:");
            choice = (new Scanner(System.in)).nextInt();
            if(choice == 1) {
                int numberOfComputers = 0;
                System.out.println("Number of computers: ");
                numberOfComputers = (new Scanner(System.in)).nextInt();
                for (int i = 0; i < numberOfComputers; i++) {
                    System.out.println("Enter information of computer : "+(i+1));
                    Computer computer = new Computer();
                    computer.input();
                    computers.add(computer);
                }

            } else if(choice == 2){
                int numberOfBooks = 0;
                System.out.println("Number of books: ");
                numberOfBooks = (new Scanner(System.in)).nextInt();
                for (int i = 0; i < numberOfBooks; i++) {
                    System.out.println("Enter information of book : "+(i+1));
                    Book book = new Book();
                    book.input();
                    books.add(book);
                }
            } else if(choice == 3){
                computers.sort((Computer computer1, Computer computer2)
                        -> (int)(computer1.getPrice() - computer2.getPrice()));
                for(Computer computer: computers) {
                    computer.display();
                }
            } else if(choice == 4){
                books.sort(new Comparator<Book>() {
                    @Override
                    public int compare(Book book1, Book book2) {
                        return book1.getPublisher().compareTo(book2.getPublisher());
                    }
                });
                books.forEach((Book book) -> {
                    book.display();
                });
            } else {
                System.out.println("Please choose 1-5");
            }
        }
    }
}
