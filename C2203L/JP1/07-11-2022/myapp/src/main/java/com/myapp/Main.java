package com.myapp;

import com.myapp.aptech.Employee;
import com.myapp.aptech.Manager;
import com.myapp.aptech.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Person> persons = new ArrayList<Person>();
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Manager> managers = new ArrayList<Manager>();
        for(int i = 0; i < 3; i++) {
            System.out.println("Enter person "+(i+1));
            Person person = new Person();
            person.input();
            persons.add(person);
        }
        //persons.sort((Person person1, Person person2) -> person1.getAge() - person2.getAge());
        persons.stream()
                .sorted((Person person1, Person person2) -> person1.getAge() - person2.getAge())
                .toList()
                .forEach((Person person) -> {
                    person.display();
        });
        for(int i = 0; i < 3; i++) {
            System.out.println("Enter employee "+(i+1));
            Employee employee = new Employee();
            employee.input();
            employees.add(employee);
        }
        employees.get(1).increaseSalary(10);
        employees.get(2).increaseSalary(1.5);
        employees.stream()
                .sorted((Employee e1, Employee e2) -> (int)(e1.getSalary()- e2.getSalary()))
                .toList()
                .forEach((Employee employee) -> {
                    employee.display();
                });
        for(int i = 0; i < 3; i++) {
            System.out.println("Enter manager "+(i+1));
            Manager manager = new Manager();
            manager.calculateTax();
            manager.input();
            managers.add(manager);
        }
        Manager managerWithHighestSalary = managers.stream()
                .max((Manager manager1, Manager manager2)
                        -> (int)(manager1.getSalary()-manager2.getSalary()))
                .get();
        if(managerWithHighestSalary != null) {
            managerWithHighestSalary.display();
        } else {
            System.out.println("there are no managers");
        }
    }
}
