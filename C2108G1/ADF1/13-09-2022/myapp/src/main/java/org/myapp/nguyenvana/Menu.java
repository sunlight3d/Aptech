package org.myapp.nguyenvana;

import org.myapp.nguyenvana.models.Result;
import org.myapp.nguyenvana.models.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Menu {
    private ArrayList<Student> students = new ArrayList<Student>();
    private Scanner getScanner() {
        return new Scanner(System.in);
    }
    public void showMenu(){
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("| STUDENT EXAM RESULT MANAGEMENT PROGRAM |");
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("|1. Input |2. Sort |3. Analyze |4. Find |5. Save |6. Open |7. Exit |");
        System.out.println("+------------------------------------------------------------------+");
        Integer choice = 0;
        //System.out.println("max int is :"+Integer.MAX_VALUE+"min Int is: "+Integer.MIN_VALUE);
        while(choice != 7) {
            System.out.println("Enter your choice(1-7): ");
            choice = (getScanner()).nextInt();
            if(choice == 1) {
                System.out.println("You choose input");
                System.out.println("Enter number of students: ");
                Integer numberOfStudents = (getScanner()).nextInt();
                for(int i = 0; i < numberOfStudents; i++) {
                    System.out.println(String.format("Input student %d", i+1));
                    Student student = new Student();
                    System.out.println("Enter student's name: ");
                    student.setName(getScanner().next().trim());

                    System.out.println("Enter student's province: ");
                    student.setProvince(getScanner().next().trim());

                    Integer age = -1;
                    while (age <= 18 || age >= 45) {
                        System.out.println("Enter student's birthYear: ");
                        Integer birthYear = getScanner().nextInt();
                        student.setBirthYear(birthYear);
                        age = student.getAge();
                        if(age > 18 && age < 45) {

                        } else {
                            System.err.println("Please enter correct age");
                        }
                    }

                    System.out.println("Now please enter Mark");
                    Result mark = new Result();

                    Float math = -1.0f;
                    while (math < 0 || math > 10) {
                        //check data anomalies
                        System.out.println("Enter math:");
                        math = getScanner().nextFloat();
                        if(math >= 0 && math <= 10) {
                            mark.setMath(math);
                        } else {
                            System.err.println("Incorrect value, please input again");
                        }
                    }
                    Float physics = -1.0f;
                    while (physics < 0 || physics > 10) {
                        //check data anomalies
                        System.out.println("Enter physics: ");
                        physics = getScanner().nextFloat();
                        if(physics >= 0 && physics <= 10) {
                            mark.setPhysics(physics);
                            //mark.physics = physics;
                        }else {
                            System.err.println("Incorrect value, please input again");
                        }
                    }
                    Float chemistry = -1.0f;
                    while (chemistry < 0 || chemistry > 10) {
                        //check data anomalies
                        System.out.println("Enter chemistry:");
                        chemistry = getScanner().nextFloat();
                        if(chemistry >= 0 && chemistry <= 10) {
                            mark.setChemistry(chemistry);
                        } else {
                            System.err.println("Incorrect value, please input again");
                        }
                    }
                    student.setMark(mark);
                    this.students.add(student);
                }
                this.showAllStudents();
            } else if(choice == 2) {
                System.out.println("You choose sort");
            } else if(choice == 3) {
                System.out.println("You choose Analyze");
            } else if(choice == 4) {
                System.out.println("You choose Find");
            }else if(choice == 5) {
                System.out.println("You choose save");
            } else if(choice == 6) {
                System.out.println("You choose Open");
            }
            System.out.println("");
            System.out.println("Do you want to continue ?");
            System.out.println("- Yes, I do. (press ‘y’, ‘Y’)");
            System.out.println("- No, I don’t. (press ‘n’, ‘N’)");
            System.out.println("- Please clear the screen ! (press ‘c’, ‘C’)");
            System.out.println("Your choice:");
            String yourChoice = (getScanner()).next();
            //if(yourChoice.equals("y") || yourChoice.equals("Y")) {
            if(yourChoice.trim().toLowerCase().equals("y")) {

            } else if(yourChoice.trim().toLowerCase().equals("n")) {
                break;
            } else if(yourChoice.trim().toLowerCase().equals("c")) {

            } else {
                System.out.println("You must choose y, n, c");
            }
        }

        System.out.println("Program ended");
    }
    private void showAllStudents(){
        /*
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
        }
        */
        for (Student eachStudent: students) {
            System.out.println(eachStudent.toString());
        }
    }
}
