package aptech;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonManager {
    private ArrayList<Person> persons = new ArrayList<>();
    Scanner getScanner() {
        return new Scanner(System.in);
    }
    public void setPersons() throws Exception{
        System.out.println("Enter number of persons: ");
        int numberOfPersons = getScanner().nextInt();
        if(numberOfPersons < 0) {
            throw new Exception("number must be > 0");
        }
        for(int i = 0; i < numberOfPersons; i++) {
            Person person = new Person();
            person.input();
            persons.add(person);
        }
    }
    public void getPersons() {
        for (Person person: this.persons) {
            person.display();
        }
    }
    public void findPerson() {
        int index = 0;
        System.out.println("Enter index to search: ");
        //cach 1: duyet thuan tuy
        index = getScanner().nextInt();
        for(int i = 0; i < this.persons.size(); i++) {
            if(index == i) {
                this.persons.get(i).display();
            }
        }
        //filter trong truong hop muon tim theo tieu chi nao do lien quan den property cua object
        //VD: sinh vien co age > 18 && age < 30
        //lam menu => mn xem vi du cua buoi 2(lam menu), su dung switch-case
    }
}
