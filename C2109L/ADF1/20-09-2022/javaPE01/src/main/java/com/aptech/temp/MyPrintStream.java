package com.aptech.temp;

import java.io.PrintStream;

public class MyPrintStream {

    public static void println(String message, boolean isShow) {
        if(isShow) {
            System.out.println(message);
        }
    }
    //overloading...
    public static void println(String message) {
        //System.out.println(message);
    }
}
