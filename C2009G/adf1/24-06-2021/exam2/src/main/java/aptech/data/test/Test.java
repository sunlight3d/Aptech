package aptech.data.test;

import aptech.data.manager.DocumentManager;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        int choice = 0;
        DocumentManager documentManager = new DocumentManager();
        do {
            System.out.println("1.Add New Books");
            System.out.println("2.Display All Books");
            System.out.println("3.Search Books By Author Name");
            System.out.println("4.Exit");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    documentManager.addDocument();
                    break;
                case 2:
                    documentManager.displayAllDocument();
                    break;
                case 3:
                    System.out.println("Enter author's name: ");
                    String authorName = scanner.next();
                    documentManager.searchByAuthorName(authorName);
                    break;
                default:
                    System.out.println("Please choice 1 - 4");
                    break;
            }

        }while (choice >= 1 && choice <= 4);
    }
}
