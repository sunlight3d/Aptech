package com.member;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Helper {
    private static BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
    public static String inputString(String message) throws Exception {
        try {
            System.out.println(message);
            return bufferedReader.readLine();
        }catch (Exception e) {
            throw new Exception("Cannot input string"+e.getMessage());
        }
    }
    public static int inputInt(String message) throws Exception {
        try {
            System.out.println(message);
            return Integer.parseInt(bufferedReader.readLine());
        }catch (Exception e) {
            throw new Exception("Cannot input string"+e.getMessage());
        }
    }
}