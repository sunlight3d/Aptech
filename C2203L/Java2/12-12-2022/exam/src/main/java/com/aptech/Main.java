package com.aptech;

import com.aptech.database.Database;
import com.aptech.models.Exam;

import java.util.Scanner;
import java.util.function.Consumer;

import static com.aptech.Helper.inputInt;
import static com.aptech.Helper.inputString;

public class Main {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        try {
            while (true) {
                System.out.println("1. View all Exams");
                System.out.println("2. Add new exam");
                System.out.println("3. Remove exam");
                System.out.println("4. Exit");
                int choice = inputInt("Enter your choice: ");
                if(choice == 1) {
                    for(Exam exam: database.getExams()) {
                        System.out.println(exam.toString());
                    }
                }else if(choice == 2) {
                    String examName = inputString("Enter exam's name: ");
                    String examDate = inputString("Enter exam's date(yyyy-MM-dd): ");
                    int examDuration = inputInt("Enter exam's duration : ");
                    String examRoom = inputString("Enter exam's room: ");
                    database.insertExam(examName, Helper.stringToDate(examDate), examDuration, examRoom);
                }else if(choice == 3) {
                    int id = inputInt("Enter exam's id to delete ?");
                    if(database.getExamByID(id) == null) {
                        System.err.println("Cannot find exam to delete");
                    } else {
                        database.deleteExam(id);
                        System.out.println("Delete exam successfully");
                    }
                }else if(choice == 4) {
                    break;
                } else {
                    System.out.println("Please choose 1-4");
                }
            }
        }catch (Exception e) {

        }

    }
}
