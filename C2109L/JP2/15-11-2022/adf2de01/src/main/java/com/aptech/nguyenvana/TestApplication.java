package com.aptech.nguyenvana;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static com.aptech.nguyenvana.Helper.getBufferedReader;
import static com.aptech.nguyenvana.Helper.println;

public class TestApplication {
    public static void main(String[] args) {
        int numberOfResults = 2;
        String fileName = "test_result.obj";
        ArrayList<TestResult> testResults = new ArrayList<TestResult>();
        try {
            while (true) {
                println("1. Input Test result list");
                println("2. Store TestResult");
                println("3. Exit");
                println("Enter your choice");
                int choice = Integer.parseInt(getBufferedReader().readLine());
                if(choice == 1) {
                    for(int i = 0; i < numberOfResults; i++) {
                        TestResult testResult = new TestResult();
                        testResult.input();
                        testResults.add(testResult);
                    }
                }else if(choice == 2) {
                    if(testResults.size() == 0) {
                        println("Blank array, donot save");
                    } else {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                        // Write objects to file
                        objectOutputStream.writeObject(testResults);
                        objectOutputStream.close();
                        fileOutputStream.close();
                    }
                } else if (choice == 3) {
                    break;
                } else {
                    println("Please choose 1-3");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
