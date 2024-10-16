package com.aptech;

import com.aptech.models.Opportunity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class OppotunityManager {
    private String fileName = "data_file.bat";
    private List<Opportunity> opportunities = new ArrayList<Opportunity>();
    public static int NUMBER_OF_STUDENTS = 2;
    public void inputOppotunities() {
        for(int i = 0; i < NUMBER_OF_STUDENTS; i++) {
            System.out.println("Enter information : "+(i+1));
            Opportunity opportunity = new Opportunity();
            opportunity.input();
            opportunities.add(opportunity);
        }
    }
    public void saveToFile(){
        try {
            FileWriter fileWriter = new FileWriter(this.fileName);
            for(Opportunity opportunity: opportunities) {
                fileWriter.write(String.format("%s;%s;%f;%s;%s\n",
                        opportunity.getId(),
                        opportunity.getJobTitle(),
                        opportunity.getExpectedSalary(),
                        String.join(",", opportunity.getSkills()),
                        String.join(",", opportunity.getEducation())));
            }
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void readFromFile(){
        try {
            opportunities.clear();
            File file = new File(this.fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lines = line.split(";\\s*");
                Opportunity opportunity = new Opportunity(
                  lines[0],
                        lines[1],
                        Float.valueOf(lines[2]),
                        Arrays.asList(lines[3].split(",\\s*")),
                        Arrays.asList(lines[4].split(",\\s*"))
                );
                opportunities.add(opportunity);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void showAllOppotunities() {
        for(Opportunity opportunity: opportunities) {
            System.out.println(opportunity);
        }
    }
}
