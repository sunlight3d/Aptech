package com.aptech.data.test;

import com.aptech.data.manager.DocumentManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        DocumentManager documentManager = new DocumentManager();

        int choice = 0;
        try {
            while (choice != 4) {
                System.out.println("1.Add New Books");
                System.out.println("2.Display All Books");
                System.out.println("3.Search Books By Author Name");
                System.out.println("4.Exit");
                System.out.println("Enter your choice(1-4): ");
                choice = Integer.valueOf(bufferedReader.readLine());
                switch (choice) {
                    case 1:
                        //System.out.println("you choose 1");
                        documentManager.addDocument();
                        break;
                    case 2:
                        //System.out.println("you choose 2");
                        documentManager.displayAllDocument();
                        break;
                    case 3:
                        //System.out.println("you choose 3");
                        System.out.println("Enter author name to search: ");
                        String authorName = bufferedReader.readLine();
                        documentManager.searchByAuthorName(authorName);
                        break;
                    default:
                        System.out.println("Please choose 1-4");
                }
            }
        }catch (IOException e) {
            System.err.println("Error input: "+e.getMessage());
        }
        System.out.println("Program ended");

    }
}
