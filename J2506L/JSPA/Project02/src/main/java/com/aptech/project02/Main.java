package com.aptech.project02;

import com.aptech.project02.models.*;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Car myCar = new Car();
//        Car myCar2 = new Car();
//        //myCar.name = "name 1111";
//        myCar.display();
//        System.out.println();
//        //Hàm main gọi hàm khác trong cùng class Main
//        Car myCar3 = new Car("Vinfast", "red");
//        Car myCar4 = new Car("Mazda", "white", 2025);
//        Student mrHoang = new Student("Hoang", "nguyenvana@gmail.com", 20);
//        System.out.println("name is "+mrHoang.getName());
//        mrHoang.setName("Hoang123");
//        System.out.println("name is "+mrHoang.getName());
//        Dog myPet1 = new Dog();
//        myPet1.say();
//        Cat myPet2 = new Cat();
//        myPet2.say();
        System.out.println("base salary is: "+Employee.BASE_SALARY);
        /*
        Employee mrA = new Employee();
        mrA.setName("Hoang");
        mrA.setSalary(6_000_000.0f);
        System.out.println("haha");
        */
        Employee mrA = new Employee("Hoang", 6_000_000.0f);
        Employee mrB = new Employee("John", 7_000_000.0f);
        Employee.BASE_SALARY = 5_100_000.0f;
        System.out.println(mrA);
        System.out.println(mrB);
        System.out.println("haha");
        //Utilities utilities = new Utilities();
        System.out.println(Utilities.sum(2, 3));
        Employee.haha();//call static
        Dog dogA = new Dog("Milku", 4);
        Dog dogB = new Dog("Milku", 4);
        Cat catA = new Cat("Mimi");

        ArrayList<Animal> somePets = new ArrayList<>();//dynamic array
        somePets.add(dogB);
        somePets.add(dogA);
        somePets.add(catA);
        //iterate an array list
        //mutable / immutable
        /*
        for(int i = 0; i < somePets.size(); i++) {
            Animal eachPet = somePets.get(i);
            System.out.println(eachPet);
        }
         */
        for(Animal eachPet: somePets) {
            System.out.println(eachPet);
        }
        Animal[] someAnimals = {dogA, dogB, catA};
        Animal firstPet = someAnimals[0];
    }
}