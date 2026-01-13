package com.aptech.project02;

import com.aptech.project02.models.Employee;
import com.aptech.project02.models.FullTimeEmployee;
import com.aptech.project02.models.ParttimeEmployee;

import java.util.ArrayList;
import java.util.function.Consumer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //Employee e1 = new Employee(); //cannot init an object, from abstract class
        //FullTimeEmployee mrX = new FullTimeEmployee(); //ok
        Employee mrX = new FullTimeEmployee(
                    "nguyen van x",
                1_000_000,
                    100_000);
        Employee mrY = new ParttimeEmployee("Nguyen Van Y",
                1_000_000,
                3,
                200_000
        );

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(mrX);
        employees.add(mrY);
        //employees.remove(mrX);
        /*
        ruom ra, nhung de hieu ban chat ben trong
        Consumer consumer11 = new Consumer() {
            @Override
            public void accept(Object o) {
                Employee eachEmployee = (Employee) o;
                System.out.println("name : "+eachEmployee.getName());
            }
        };
        employees.forEach(consumer11);
         */
        /*
        ...more simple
        employees.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                Employee eachEmployee = (Employee) o;
                System.out.println("name : "+eachEmployee.getName());
            }
        });
        */
        /*
        employees.forEach((Object o) -> {
            Employee eachEmployee = (Employee) o;
            System.out.println("name : "+eachEmployee.getName());
        });
        */
        employees.forEach((Object o) -> {
            System.out.println("name : "+((Employee) o).getName());
        });
        /*
        Employee mrZ = new ParttimeEmployee("Nguyen Van Z",
                3,
                200_000
        );
         */
        //Builder pattern
        /*
        ParttimeEmployee.name("nguyerur")
                .hourWorked(3)
                .hourlyRate(100_000)
                .build();
         */
    }
}