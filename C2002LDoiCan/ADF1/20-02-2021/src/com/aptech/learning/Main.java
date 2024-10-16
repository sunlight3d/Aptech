package com.aptech.learning;

import com.aptech.learning.models.Author;
import com.aptech.learning.models.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = 15;
        int index = 0;
        /*
        while (index <= size) {
            for(int j = 0; j < index; j++){
                System.out.print("*");
            }
            System.out.println("");
            index++;
        }

        //Thu nghiem voi switch case
        System.out.println("Enter your choice(1-3)");
        int choice = new Scanner(System.in).nextInt();
        switch (choice) {
            case 1:
                System.out.println("Do task 1");
                break;
            case 2:
                System.out.println("Do task 2");
                break;
            default:
                break;
        }
*/
        //Tao doi tuong
        Author mrHoang = new Author("Nguyen Duc Hoang", "hoang@gmail.com", 'M');
        Book bookC = new Book("lap trinh C trong 24h", mrHoang, 120.0, 3);
        Book bookPHP = new Book("php 21 days", mrHoang, 110.2, 2);
        Author mrA = new Author("Nguyen Van A", "nva@gmail.com", 'M');
        //quyen PHP cua ong A viet ??
        bookC.setAuthor(mrA);
        Author mrAAA = bookC.getAuthor();

        System.out.println("haha");
        //Nhap du lieu tu ban phim(giong scanf, cin trong C)
        System.out.println("Enter number of books : ");
        Integer numberOfBooks = new Scanner(System.in).nextInt();
        //duyet danh sach, yeu cau nguoi dung nhap du lieu tung quyen sach vao ?
        ArrayList<Book> books = new ArrayList<>();
        for(Integer i = 0; i < numberOfBooks; i++) {
            System.out.println("Enter book's name : ");
            String bookName = new Scanner(System.in).nextLine();
            System.out.println("Enter book's price : ");
            double bookPrice = new Scanner(System.in).nextDouble();
            System.out.println("Enter book's quantity : ");
            int quantity = new Scanner(System.in).nextInt();
            Book newBook = new Book(bookName, null,bookPrice, quantity);
            books.add(newBook);
            //System.out.println(newBook);
        }
        System.out.println("List of books : ");
        //sau khi qua vong lap, newBook => cho cac newBook vao 1 array/list
        for(int i = 0; i < books.size(); i++) {//traditional
            System.out.println(books.get(i));
        }
        //duyet cach khac ?
        System.out.println("List of books(way 2) : ");
        for(Book eachBook: books) {
            System.out.println(eachBook);
        }
    }
}
