package com.aptech.nguyenvana;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Helper {
    public static BufferedReader getBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }
    public static void println(String message) {
        System.out.println(message);
    }
}
