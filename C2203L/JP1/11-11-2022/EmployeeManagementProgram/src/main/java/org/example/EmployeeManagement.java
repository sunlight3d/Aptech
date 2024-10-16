package org.example;

import org.example.models.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

import static org.example.Utilities.getScanner;

public class EmployeeManagement {
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    public void inputEmployees() {
        System.out.println("Number of employees: ");
        int numberOfEmployees = getScanner().nextInt();
        for(int i = 0; i < numberOfEmployees; i++) {
            Employee employee = new Employee();
            employee.input();
            employees.add(employee);
        }
    }
    public void sort() {

        this.employees.sort((Employee employee1, Employee employee2)
                -> employee1.getName().compareTo(employee2.getName()));
//        this.employees.stream()
//                .sorted((Employee employee1, Employee employee2)
//                        -> employee1.getName().compareTo(employee2.getName()))
//                .toList()
//                .forEach((Employee employee) -> {
//                    System.out.println(employee);
//                });
        this.employees.forEach((Employee employee) -> {
            System.out.println(employee);
        });
    }
    public void analyze() {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for(Employee employee: employees) {
            Integer workingDays = employee.getWorkingDays();
//            if(hashMap.get(workingDays) == null) {
//                hashMap.put(workingDays, 1);
//            } else {
//                hashMap.put(workingDays, 1 + hashMap.get(workingDays));
//            }
            hashMap.put(workingDays, hashMap.get(workingDays) == null
                                        ? 1 : 1 + hashMap.get(workingDays));
        }
        hashMap.forEach((Integer key, Integer value) -> {
            System.out.println(String.format("+ There are %d Employees that have %d working days.", key, value));
        });
    }
    public void findHighestSalary() {
        //fake data
        this.employees.add(new Employee(1, "aa", 10, 13f));
        this.employees.add(new Employee(2, "zz", 12, 12f));
        this.employees.add(new Employee(2, "bb", 10, 13f));
        this.employees.add(new Employee(2, "tt", 3, 12f));
        Double maxSalary = employees.stream()
                .mapToDouble((Employee item)
                        -> item.getMonthlySalary())
                .max().getAsDouble();
        employees.stream().filter((Employee employee)
                -> (double) employee.getMonthlySalary() == maxSalary)
                .toList()
                .forEach((Employee employee) -> {
                    System.out.println(employee);
                });
        ;
    }
}
