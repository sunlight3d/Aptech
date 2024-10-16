package com.oppotunity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Helper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static String inputString(String message) {
        try {
            System.out.println(message);
            return bufferedReader.readLine().trim();
        }catch (IOException e) {
            return "";
        }
    }
    public static int inputInteger(String message) {
        try {
            System.out.println(message);
            return Integer.parseInt(bufferedReader.readLine());
        }catch (IOException e) {
            return 0;
        }
    }
    public static float inputFloat(String message) {
        try {
            System.out.println(message);
            return Float.parseFloat(bufferedReader.readLine());
        }catch (IOException e) {
            return 0;
        }
    }
}
