package com.aptech;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class OddEven {
    private String numbersFile = "numbers.txt";
    private String oddFile = "odd.txt";
    private String evenFile = "even.txt";
    public void readAndFillData() {
        try {
            Scanner scanner = new Scanner(new File(this.numbersFile));
            FileWriter fileWriterOdd = new FileWriter(this.oddFile);
            FileWriter fileWriterEven = new FileWriter(this.evenFile);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                Integer number = Integer.parseInt(data);
                if(number % 2 == 0) {
                    fileWriterEven.write(String.format("%d\n", number));
                } else {
                    fileWriterOdd.write(String.format("%d\n", number));
                }
            }
            scanner.close();
            fileWriterOdd.close();
            fileWriterEven.close();
            System.out.println("Successfully wrote to the file.");

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        OddEven oddEven = new OddEven();
        oddEven.readAndFillData();
    }
}
