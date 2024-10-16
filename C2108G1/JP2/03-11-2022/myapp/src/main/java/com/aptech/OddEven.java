package com.aptech;

import java.io.*;
public class OddEven {
    public void doQuestion3() {
        try {
            String[] fileNames = {"odd.txt", "even.txt"};
            for(String fileName: fileNames) {
                File file = new File(fileName);
                if(file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                System.out.println("File created: " + file.getName());
            }
            //read data from numbers.txt
            File fileNumbers = new File("numbers.txt");
            BufferedReader bufferedReader = new BufferedReader(
                            new FileReader(fileNumbers));
            FileWriter fileWriterOdd = new FileWriter("odd.txt");
            FileWriter fileWriterEven = new FileWriter("even.txt");
            while (true) {
                String eachLine = bufferedReader.readLine();
                if(eachLine == null) {
                    break;
                }
                /*
                if(Integer.valueOf(eachLine) %2 == 0) {
                    fileWriterEven.write(String.format("%s\n", eachLine));
                } else {
                    fileWriterOdd.write(String.format("%s\n", eachLine));
                }
                */
                (Integer.valueOf(eachLine) %2 == 0 ? fileWriterEven:fileWriterOdd)
                        .write(String.format("%s\n", eachLine));

            }
            fileWriterOdd.close();
            fileWriterEven.close();
            System.out.println("Successfully wrote to files.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
