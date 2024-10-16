package com.aptech.learning;

import com.product.Person;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Hello");
	    System.out.println("World");
	    Person p1 = new Person("Hoang");
	    Person p2 = new Person("John");
	    Person p3 = new Person("Hennry");
        System.out.println("hshs");
        System.out.println("number of persons ="+Person.currentId);
    }
}
