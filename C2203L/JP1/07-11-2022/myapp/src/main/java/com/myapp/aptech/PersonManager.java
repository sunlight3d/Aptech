package com.myapp.aptech;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class PersonManager {
    private ArrayList<Person> persons = new ArrayList<Person>();
    public void setPersons() {
        System.out.println("How many persons ? ");
        int numberOfPersons = (new Scanner(System.in)).nextInt();
        try {
            for(int i = 0; i < numberOfPersons; i++) {
                System.out.println(String.format("Enter person [%d]", (i+1)));
                Person person = new Person();
                person.input();
                persons.add(person);
            }
        }catch (Exception e) {
            System.err.println("Cannot insert new person: "+e.getMessage());
        }
    }
    public void getPersons() {
        //traditional method
        /*
        for(int i = 0; i < this.persons.size(); i++) {
            Person person = this.persons.get(i);
            person.display();
        }
        //use for
        for (Person person: this.persons) {
            person.display();
        }
        */
        this.persons.forEach((Person person) -> person.display());
    }
    public void findPerson() throws IndexOutOfBoundsException {
        System.out.println("Enter index(eg: 0, 1, 2...)");
        int index = (new Scanner(System.in)).nextInt();
        if(index < 0 || index >= this.persons.size()) {
            throw new IndexOutOfBoundsException("out of range");
        }
        this.persons.get(index).display();
    }
}
