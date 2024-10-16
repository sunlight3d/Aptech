/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.MyApp.models;

import java.util.ArrayList;
import java.util.Scanner;

public class InformationDisplay {
    private Scanner scanner;
    private ArrayList<Person> persons = new ArrayList<Person>();
    public void input() {        
        int choice = 0;
        if(scanner == null) {
            scanner = new Scanner(System.in);//lazy init
        }
        while(choice != 5) {
            System.out.println("Enter your choice : ");
            choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Input a Student");                    
                    Student student = new Student();
                    student.input();
                    persons.add(student);
                    break;
                case 2:
                    System.out.println("Input a Employee");
                    Employee employee = new Employee();
                    persons.add(employee);
                    employee.input();
                    break;
                case 3:
                    System.out.println("Input a Customer");
                    Customer customer = new Customer();
                    customer.input();
                    persons.add(customer);
                    break;
                case 4:
                    System.out.println("Show all persons");
                    persons.forEach(eachPerson -> {
                        System.out.println(eachPerson.toString());
                    });
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    break;
            }
        }
    }
}
