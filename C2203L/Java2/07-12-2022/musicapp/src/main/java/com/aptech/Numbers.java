package com.aptech;

import java.io.FileWriter;

public class Numbers {
    private String fileName = "numbers.txt";
    public void writeToFile() {
        try {
            FileWriter fileWriter = new FileWriter(this.fileName);
            for(int i = 0; i < 100; i++) {
                if(i % 3 != 0) {
                    fileWriter.write(String.format("%d\n", i));
                }
            }
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        numbers.writeToFile();
    }
}
