package com.product.test;

import com.product.ProductManagement;
import com.product.ProductType;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
		System.out.println("1.Input information for n Computers.");
		System.out.println("2.Input information for n Books.");
		System.out.println("3.Display information of n Computers by sorting the");
		System.out.println("price descending.");
		System.out.println("4. Display information of n Books by sorting the");
		System.out.println("5.Exit.");
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
        ProductManagement productManagement = new ProductManagement();
		while(choice != 5) {
		    System.out.println("Enter your choice");
		    choice = scanner.nextInt();
		    switch (choice){
                case 1:
                    System.out.println("1");
                    productManagement.inputProducts(ProductType.COMPUTER);
                    break;
                case 2:
                    System.out.println("2");
                    productManagement.inputProducts(ProductType.BOOK);
                    break;
                case 3:
                    System.out.println("3");
                    productManagement.displayComputers();
                    break;
                case 4:
                    System.out.println("4");
                    productManagement.displayBooks();
                    break;
                default:
                    break;
            }
            System.out.println("Program end.");
        }
    }
}
