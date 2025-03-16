package org.university.app;

import org.university.app.services.DegreeService;
import org.university.app.services.GradeService;
import org.university.app.services.ModuleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== University Grading System =====");
            System.out.println("1. Get student grade for an assignment");
            System.out.println("2. Get weighted average grade for a module");
            System.out.println("3. Get final degree classification");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter Module ID: ");
                    int moduleID = scanner.nextInt();
                    System.out.print("Enter Assignment ID: ");
                    int assessmentID = scanner.nextInt();
                    GradeService.getStudentGrade(studentID, moduleID, assessmentID);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter Module ID: ");
                    moduleID = scanner.nextInt();
                    ModuleService.getWeightedAverage(studentID, moduleID);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    DegreeService.getFinalDegreeClassification(studentID);
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
