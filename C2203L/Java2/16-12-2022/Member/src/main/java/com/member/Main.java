package com.member;

public class Main {
    public static void main(String[] args) throws Exception{
        ClubManager clubManager = new ClubManager();
        clubManager.input();
        clubManager.writeToFile();
        clubManager.readFromFile();
    }
}