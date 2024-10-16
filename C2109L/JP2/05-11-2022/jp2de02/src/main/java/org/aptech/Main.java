package org.aptech;

public class Main {
    public static void main(String[] args) {
        ClubManager clubManager = new ClubManager();
        clubManager.inputMembers();
        clubManager.saveToFile();
        clubManager.readFile();
    }
}