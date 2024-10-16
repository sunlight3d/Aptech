package com.aptech;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestApplication {
    public static void main(String[] args) {
        ArrayList<TestResult> testResults = new ArrayList<TestResult>();
        while (true) {
            System.out.println("1. Input Test result list");
            System.out.println("2. Store TestResult");
            System.out.println("3. Exit");
            int choice = Helper.inputInt("Enter your choice: ");
            if (choice == 1) {
                for(int i = 0; i < 5; i++) {
                    System.out.println(String.format("Enter test's result [%d]", i+1));
                    TestResult testResult = new TestResult();
                    testResult.input();
                    testResults.add(testResult);
                }
            }else if (choice == 2) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("test_result.obj");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    // write object to file
                    objectOutputStream.writeObject(testResults);
                    System.out.println("Done");
                    // closing resources
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if (choice == 3) {
                break;
            }
        }
    }
}
