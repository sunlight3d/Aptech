package org.example;

import org.example.models.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    private String fileName = "output.csv";
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
    public void save() {
        //fake data
//        this.employees.add(new Employee(1, "aa", 10, 13f));
//        this.employees.add(new Employee(2, "zz", 12, 12f));
//        this.employees.add(new Employee(2, "bb", 10, 13f));
//        this.employees.add(new Employee(2, "tt", 3, 12f));
        try {
            FileWriter fileWriter = new FileWriter(this.fileName);
            fileWriter.write("Id;Name;Working Days;Daily Salary\n");
            for(Employee employee: this.employees) {
                fileWriter.write(String.format("%d;%s;%d;%f\n",
                                            employee.getId(),
                                            employee.getName(),
                                            employee.getWorkingDays(),
                                            employee.getDailySalary()
                ));
            }
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void open() {
        try {
            File file = new File(this.fileName);
            Scanner scanner = new Scanner(file);
            int i = 0;
            this.employees.clear();
            while (scanner.hasNextLine()) {
                String eachLine = scanner.nextLine();
                if(i == 0) {
                    i++;
                    continue;
                }
                String[] eachLines = eachLine.split(";");
                Employee employee = new Employee(
                        Integer.valueOf(eachLines[0]),
                        eachLines[1],
                        Integer.valueOf(eachLines[2]),
                        Float.valueOf(eachLines[3].replaceAll("\\.","")));
                this.employees.add(employee);
                i++;
            }
            scanner.close();
            this.employees.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
