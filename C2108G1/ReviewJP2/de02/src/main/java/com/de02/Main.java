package com.de02;

public class Main {
    public static void main(String[] args) {
        ClubManager clubManager = new ClubManager();
        try {
            clubManager.input();
            clubManager.writeToFile();
            clubManager.readFromFile();
        }catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }
}