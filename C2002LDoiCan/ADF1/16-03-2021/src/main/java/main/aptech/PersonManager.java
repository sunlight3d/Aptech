package main.aptech;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManager {
    private ArrayList<Person> persons;//lazy
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
            this.persons = new ArrayList<>(numberOfPersons);
        } catch (Exception exception) {
            System.err.println("error = "+exception.getMessage());
        }
    }
}
