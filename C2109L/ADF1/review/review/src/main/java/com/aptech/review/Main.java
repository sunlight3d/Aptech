package com.aptech.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //this is an array(with fixed length)
        Person[] persons = {
                new Person(1, "nguyen", "van A", 18),
                new Person(2, "thomson", "van A", 25),
                new Person(3, "john", "van A", 17),
                new Person(4, "johny", "van A", 38)
        };
        //this is an ArrayList
        /*
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(persons[0]);
        personArrayList.add(persons[1]); //NO !
         */
        //convert array to arraylist
        ArrayList<Person> personArrayList = new ArrayList<>(Arrays.asList(persons));
        //find the oldest person
        //traditional method
        /*
        int maxAge = Integer.MIN_VALUE;
        for(Person person: personArrayList) {
            if(person.getAge() > maxAge) {
                maxAge = person.getAge();
            }
        }
        for(Person person: personArrayList) {
            if(person.getAge() == maxAge) {
                System.out.println(person);
            }
        }
        */
        //use Java built-in functions
        int maxAge = Collections.max(personArrayList
                .stream()
                //.mapToInt((Person person) -> person.getAge())
                .mapToInt(Person::getAge)
                .boxed().collect(Collectors.toList()));
        int minAge = Collections.min(personArrayList
                .stream()
                //.mapToInt((Person person) -> person.getAge())
                .mapToInt(Person::getAge)
                .boxed().collect(Collectors.toList()));
        Arrays.stream(persons)
                .filter((Person person) -> person.getAge() == maxAge)
                .forEach((Person person) -> {
                    System.out.println(person);
        });
        System.out.println("min age = "+minAge);
        Collections.sort(personArrayList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        System.out.println("after sort");
        personArrayList.forEach((Person person) -> {
            System.out.println(person);
        });
        personArrayList.add(new Person(55, "dd", "xxx", 80));
        System.out.println("add more person");
        personArrayList.forEach((Person person) -> {
            System.out.println(person);
        });
        System.out.println("persons who has names which contains 'john' : ");
        personArrayList.stream().filter((Person person) -> {
            return person.getFullName().toLowerCase().contains("john");
        }).forEach((Person person) -> {
            System.out.println(person);
        });
        System.out.println("Delete person who has age = 25");
        personArrayList.removeIf((Person person) -> person.getAge() == 25);
        personArrayList.get(3).setAge(90);
        personArrayList.forEach((Person person) -> {
            System.out.println(person);
        });

    }
}