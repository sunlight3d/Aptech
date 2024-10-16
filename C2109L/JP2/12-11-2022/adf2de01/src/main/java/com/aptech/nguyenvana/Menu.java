package com.aptech.nguyenvana;

import com.aptech.nguyenvana.database.Database;
import com.aptech.nguyenvana.models.Exam;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Consumer;

import static com.aptech.nguyenvana.Helper.getBufferedReader;

public class Menu {
    private Database database = Database.getInstance();
    public void showMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("1. View all Exams");
            System.out.println("2. Add new exam");
            System.out.println("3. Remove exam");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.valueOf(getBufferedReader().readLine());
                switch (choice) {
                    case 1:
                        //System.out.println("You choose 1");
                        database.getExams().forEach(System.out::println);//method reference
                        break;
                    case 2:
                        System.out.println("Enter a new exam information");
                        System.out.println("Exam's name: ");
                        String name = getBufferedReader().readLine();

                        System.out.println("Exam's date(eg:31/12/1998): ");
                        String strDate = getBufferedReader().readLine();
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);

                        System.out.println("Exam's duration: ");
                        int duration = Integer.valueOf(getBufferedReader().readLine());

                        System.out.println("Exam's room: ");
                        String room = getBufferedReader().readLine();
                        database.insertExam(name, date, duration, room);
                        break;
                    case 3:
                        System.out.println("Exam's id to delete: ");
                        int id = Integer.valueOf(getBufferedReader().readLine());
                        database.deleteBook(id);
                        break;
                    default:
                        break;
                }
            } catch (IOException e) {
                System.err.println("Cannot input, error: "+e.getMessage());
            } catch (Exception e) {
                System.err.println("error in DB: "+e.getMessage());
            }

        }

    }
}
