package com.aptech.myapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        System.out.println("chao ban");
        System.out.println("===== MENU =====");
        System.out.println("1. Thêm sách mới");
        System.out.println("2. Hiển thị danh sách sách");
        System.out.println("3. Tìm kiếm sách theo tên");
        System.out.println("4. Thoát");
        System.out.println("================");
        System.out.println("Nhập lựa chọn (1-4):");
        int choice = 0;
        while(choice != 4) {
            System.out.println("Enter your choice(1-4): ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1:
                    System.out.println("you choose 1");
                    Book newBook = new Book();
                    newBook.input();
                    books.add(newBook);
                    System.out.println("haha");
                    break;
                case 2:
                    System.out.println("you choose 2");
                    for(Book book: books) {
                        System.out.println(book);
                    }
                    break;                
                case 3:
                    System.out.println("you choose 3");
                    System.out.println("Enter text to search: ");
                    String keyword = (new Scanner(System.in)).next();
                    List<Book> filteredBooks = new ArrayList<>();
                    for(Book book: books) {
                        if(book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                            filteredBooks.add(book);
                        }
                    }

                    if(!filteredBooks.isEmpty()) {
                        System.out.println("We found "+filteredBooks.size()+" items");
                        for(int i = 0 ; i < filteredBooks.size(); i++) {
                            System.out.println(filteredBooks.get(i));
                        }
                    } else {
                        System.err.println("Cannot find any books");
                    }
                    break;
                default:
                    if(choice != 4){
                        System.err.println("You must choose 1-4");
                    }                    
                    break;
            }
        }        
    }
}