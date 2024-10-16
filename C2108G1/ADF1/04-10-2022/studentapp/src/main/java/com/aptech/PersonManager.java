package com.aptech;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManager {
    private ArrayList<Person> persons = new ArrayList<>();
    public void getPersons() {
        System.out.println("How many persons ? ");
        int numberOfPersons = (new Scanner(System.in)).nextInt();

        if(numberOfPersons <= 0) {
            System.err.println("Please enter a positive value");
        } else {
            for(int i = 0; i < numberOfPersons; i++){
                System.out.println("Enter information of person"+(i+1));
                System.out.println("1: Employee, 2: Manager");
                int personType = (new Scanner(System.in)).nextInt();
                if(personType == 1) {
                    Employee employee = new Employee();
                    employee.input();
                    persons.add(employee);
                }else if(personType == 2) {
                    Manager manager = new Manager();
                    manager.input();
                    persons.add(manager);
                }

            }
        }
    }
    public Person findPerson(int index) {
        //return this.persons.get(index);
        try {
            return this.persons.get(index);
        }catch (Exception error) {
            System.err.println("Cannot find person.Error: "+error.getMessage());
            return null;
        }
    }
    public void showAllPersons() {
        for(int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }
}
