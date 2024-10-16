package com.oppotunity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static com.oppotunity.Helper.inputString;

public class Test {
    private List<Oppotunity> oppotunities = new ArrayList<Oppotunity>();
    private int numberOfOppotunities = 0;
    private String fileName = "data_file.bat";

    public void inputOpportunities() {
        //fake
        this.oppotunities.add(new Oppotunity("11", "java DEveloper", 12.3f,
                new ArrayList<String>(Arrays.asList(new String[] {"sk1", "sk2"})),
                new ArrayList<String>(Arrays.asList(new String[] {"uni1", "uni2"})))
        );
        this.oppotunities.add(new Oppotunity("22", "C# programmer", 22.3f,
                new ArrayList<String>(Arrays.asList(new String[] {"skxx1", "skxx2"})),
                new ArrayList<String>(Arrays.asList(new String[] {"xxuni1", "xxuni2"})))
        );
        this.oppotunities.add(new Oppotunity("22", "JAVA Developer", 22.3f,
                new ArrayList<String>(Arrays.asList(new String[] {"skxx1", "skxx2"})),
                new ArrayList<String>(Arrays.asList(new String[] {"xxuni1", "xxuni2"})))
        );
        for(int i = 0; i < this.numberOfOppotunities; i++) {
            System.out.println(String.format("Enter oppotunity: %d", i+1));
            Oppotunity oppotunity = new Oppotunity();
            oppotunity.input();
            oppotunities.add(oppotunity);
        }
    }
    public void saveToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream(this.fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(oppotunities);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            System.err.println("Cannot save data to file");
            ex.printStackTrace();
        }
    }
    public void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.oppotunities = (ArrayList<Oppotunity>)objectInputStream.readObject();
            System.out.println("The Object has been read from the file");
            objectInputStream.close();
        } catch (Exception ex) {
            System.err.println("Cannot read from file");
            ex.printStackTrace();
        }
    }
    public void findOpportunities() {
        String jobTitle = inputString("Enter job title to search:");
        if(this.oppotunities
                .stream()
                .filter((Oppotunity oppotunity) ->
                        oppotunity.getJobTitle().trim().equalsIgnoreCase(jobTitle)).toList().size() == 0) {
            System.err.println("Cannot find items");
            return;
        }
        this.oppotunities
                .stream()
                .filter((Oppotunity oppotunity) ->
                        oppotunity.getJobTitle().trim().equalsIgnoreCase(jobTitle))
                .forEach((Oppotunity oppotunity) -> {
                    System.out.println(oppotunity.toString());
                });
    }
    public void showAllOpportunities() {
        this.oppotunities.forEach((Oppotunity oppotunity) -> {
            System.out.println(oppotunity.toString());
        });
    }
}
