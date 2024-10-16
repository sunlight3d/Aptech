/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.MyApp.models;

import java.util.Scanner;
import learninterface.ILearning;
import learninterface.IPlayable;
//Mot class co the implements nhieu interface ? YES
public class Person implements IPlayable, ILearning, Comparable {
    //Comparable la interface co san cua java
    private String name;
    private String address;    
    public Person() {        
    }
    protected Person(String name, String address) {
        this.name = name;
        this.address = address;
    }    
    protected void input(){        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = scanner.next();
        System.out.println("Enter address: ");
        this.address = scanner.next();        
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name = "+this.name+
                "name = "+this.address; 
    }
    //implements interface

    @Override
    public void playFootball() {
        System.out.println("Person play football");
    }

    @Override
    public void playGame(String gameName) {
        System.out.println("Person play game: "+gameName);
    }

    @Override
    public void gotoSchool() {
        System.out.println("Person go to school");
    }

    @Override
    public void borrowBook(String bookName) {
        System.out.println("Person borrows book: "+bookName);
    }
    //thuc thi Comparable

    @Override
    public int compareTo(Object anotherObject) {
        return this.name.compareTo(((Person)anotherObject).getName()); //-1, 0, 1
    }
}
