package com.aptech;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Manager> managers = new ArrayList<>();
        System.out.println("Input 3 persons");
        for(int i = 0; i < 3; i++) {
            Person person = new Person();
            person.input();
            persons.add(person);
        }
        /*
        persons.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getAge() - person2.getAge();
            }
        });
         */
        persons.sort((Person person1, Person person2)
                -> person1.getAge() - person2.getAge());
        persons.forEach((Person person) -> {
            person.display();
        });
        System.out.println("Input 3 employees");
        for(int i = 0; i < 3; i++) {
            Employee employee = new Employee();
            employee.input();
            employees.add(employee);
        }
        employees.get(1).increaseSalary(10);
        employees.get(2).increaseSalary(1.5);

        employees.sort((Employee employee1, Employee employee2)
                -> employee1.getSalary() - employee2.getSalary());
        employees.forEach((Employee employee) -> {
            employee.display();
        });

        System.out.println("Input 3 managers");
        for(int i = 0; i < 3; i++) {
            Manager manager = new Manager();
            manager.input();
            manager.calculateTax();
            managers.add(manager);
        }
        //map: input: List of managers, output: list of salary
        List<Integer> salaries = managers
                .stream()
                .map(Employee::getSalary)
                .toList();
        int maxSalary = Collections.max(salaries);
        List<Manager> result = (List<Manager>)managers
                .stream()
                .filter((Manager manager) -> manager.getSalary() == maxSalary)
                .toList();
        if (result.size() > 0){
            System.out.println("Manager with max salary");
            managers.forEach((Manager manager) -> {
                manager.display();
            });
        }

    }
}