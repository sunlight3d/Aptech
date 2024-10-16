package main.aptech;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

public class PersonManager {
    //private ArrayList<Person> persons;//lazy
    private ArrayList<Person> persons = new ArrayList<>();//eager
    /*
    public ArrayList<Person> getPersonList() {
        if(persons == null) {
            persons = new ArrayList<>();//lazy init
        }
        return persons;
    }
    */
    public void setPersons(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number of persons: ");
            int numberOfPersons = scanner.nextInt();
            /*
            if(numberOfPersons < 0) {
                throw new Exception("No negative");
            }
            */
            for(int i = 0; i < numberOfPersons; i++){
                Person person = new Person();
                person.input();
                this.persons.add(person);
            }
            System.out.println("haha");
        } catch (Exception exception) {
            System.err.println("error = "+exception.getMessage());
        } finally {

        }
    }
    public void getPersons(){
        System.out.println("cach 1");
        this.persons.forEach(person -> {
            System.out.println(person.toString());
        });
        System.out.println("cach 2");
        for(int i = 0; i < this.persons.size(); i++){
            Person person = this.persons.get(i);
            System.out.println(person.toString());
        }
    }
}
