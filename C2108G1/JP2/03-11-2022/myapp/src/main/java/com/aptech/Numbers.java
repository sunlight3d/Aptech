package com.aptech;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Numbers {
    private String fileName = "numbers.txt";
    public void createFile() {
        try {
            File file = new File(this.fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                file.delete();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void writeDataToFile() {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for(int i = 1; i<= 100; i++) {
                if(i %3 != 0) {
                    fileWriter.write(String.format("%d\n", i));
                }
            }

            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
