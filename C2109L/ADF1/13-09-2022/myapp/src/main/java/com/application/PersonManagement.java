package com.application;

import com.application.models.Person;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.util.*;

public class PersonManagement {
    private ArrayList<Person> persons = new ArrayList<>();
    private String filePath = "person_list.csv";
    private void saveToCsvFile() {
        try {
            FileWriter out = new FileWriter(filePath);
            String[] headers = { "name", "nationality", "birthYear", "netWorth"};
            CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                    .withHeader(headers));
            for (Person eachPerson: persons) {
                printer.printRecord(eachPerson.getName(),
                                    eachPerson.getNationality(),
                                    eachPerson.getBirthYear(),
                                    eachPerson.getNetWorth()
                        );
            }
            out.close();
        }catch (Exception e) {
            System.err.println("Cannot save file, error: "+e.toString());
        }
    }
    private void generateFakeData(){
        persons.add(new Person("nguyenv an a", "vietnam", 1980, 11.0f));
        persons.add(new Person("nguydsdsenv an a", "uk", 1993, 32));
        persons.add(new Person("nguy wsreenv an a", "us", 1981, 22.0f));persons.add(new Person("nguyenv an a", "lao", 1980, 11.0f));
        persons.add(new Person("nguy rewreenv an a", "pakistan", 1977, 32.0f));
        persons.add(new Person("ng33duyenv an a", "vietnam", 1996, 36.0f));


    }
    public void showMenu() {
        //System.out.println("ddd");
        System.out.println("+---------------------------------------------------------+");
        System.out.println("+--------Milisionaraby dad--------+");
        System.out.println("+1-Input, 2-Sort, 3-Analyze, 4-Find, 5-Open, 6-Save, 7-Exit+");
        System.out.println("+---------------------------------------------------------+");
        int choice = 0;
        this.generateFakeData();
        while (choice != 7){
            System.out.println("Enter your choice: ");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("You choose 1");
                    inputPersons();
                    break;
                }
                case 2: {
                    System.out.println("You choose 2");
                    break;
                }
                case 3: {
                    System.out.println("You choose 3");
                    this.analyzeStatistics();
                    break;
                }
                case 4: {
                    System.out.println("You choose 4");
                    filterPersons();
                    break;
                }
                case 5: {
                    System.out.println("You choose 5");
                    break;
                }
                case 6: {
                    System.out.println("You choose 6");
                    this.saveToCsvFile();
                    break;
                }
                case 7: {
                    System.out.println("You choose 7");
                    break;
                }
                default:
                    System.out.println("Invalid, please select(1 - 7)");
            }
            System.out.println("Do you want to continue(y, n, c) ?");
            String decision = (new Scanner(System.in)).next();
            if(decision.trim().toLowerCase().equals("y")) {
                //do nothing
            } else if(decision.trim().toLowerCase().equals("n")) {
                break;
            }
        }
    }
    private Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void inputPersons() {
        System.out.println("Enter numbers of persons: ");
        int numberOfPersons = getScanner().nextInt();
        for(int i = 0; i < numberOfPersons; i++) {
            System.out.println(String.format("Information of person %d : ", i+1));
            System.out.println("Enter name: ");
            String name = getScanner().next();

            System.out.println("Enter nationality: ");
            String nationality = getScanner().next();

            int age = 0;
            int birthYear = 0;
            boolean isNotValidAge = true;
            while (isNotValidAge) {
                System.out.println("Enter birthYear: ");
                birthYear = getScanner().nextInt();
                age = Calendar.getInstance().get(Calendar.YEAR) - birthYear;
                isNotValidAge = age <= 30;
                if(isNotValidAge) {
                    System.err.println("Person age must be greater than 30 in the current\n" +
                            "year");
                }
            }
            float netWorth = 0.0f;
//            double pi = 3.14;
//            float x = 123.45f;
            boolean isNotValidNetworth = true;
            while (isNotValidNetworth) {
                System.out.println("Enter netWorth: ");
                netWorth = getScanner().nextFloat();
                isNotValidNetworth = netWorth < 1 || netWorth > 100;
                if(isNotValidNetworth) {
                    System.err.println("Networth must be between 1(billion $) and\n" +
                            "100(billion $).");
                }
            }

            Person person = new Person(name.trim(), nationality.trim(), birthYear, netWorth);
            this.persons.add(person);
        }
        System.out.println("haha");
    }
    public void analyzeStatistics() {
        Hashtable<String, Integer> result = new Hashtable<>();
        for(Person person: this.persons) {
            String key = person.getNationality();
            result.put(key, result.get(key) == null ?
                                1 : Integer.valueOf(result.get(key)) + 1);
        }
        //print result
        for(String key: result.keySet()){
            int numberOfPersons = Integer.valueOf(result.get(key));
            /*
            System.out.println(String.format(
                    "There are %d person%s with nationality: %s",
                        numberOfPersons,numberOfPersons > 1 ? "s":"",key));

             */
            System.out.println( "There are " +
                                numberOfPersons+" person" +
                                (numberOfPersons > 1 ? "s":"") +
                                " with nationality: "+key);
        }
    }
    public void filterPersons() {
        System.out.println("Enter nationality :");
        String nationality = this.getScanner().next();
        System.out.println("Enter min :");
        float min = this.getScanner().nextFloat();
        //traditional method
        ArrayList<Person> result = new ArrayList<>();
        for(Person person: this.persons) {
            boolean hasTheSameNationality = person.getNationality().trim().toLowerCase()
                                        .equals(nationality.toLowerCase().trim());
            boolean biggerThanMin = person.getNetWorth() > min;
            if(hasTheSameNationality && biggerThanMin) {
                result.add(person);
            }
        }
        this.showPersons(result);
    }
    public void showPersons(ArrayList<Person> persons) {
        persons.forEach(person -> {
            System.out.println(
                    "name: "        +person.getName() +
                    "Nationality: " +person.getNationality() +
                    "birthYear: "   +person.getBirthYear() +
                    "NetWorth: "    +person.getNetWorth()

            );
        });
    }
}
