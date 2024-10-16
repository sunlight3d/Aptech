package com.oppotunity;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.inputOpportunities();
        test.saveToFile();
        test.readFile();
        test.showAllOpportunities();
        test.findOpportunities();

    }
}