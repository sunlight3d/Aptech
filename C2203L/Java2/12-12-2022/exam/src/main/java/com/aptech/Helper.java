package com.aptech;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Helper {
    public static String inputString(String message) {
        System.out.println(message);
        return  (new Scanner(System.in)).next();
    }
    public static int inputInt(String message) {
        System.out.println(message);
        return  (new Scanner(System.in)).nextInt();
    }
    public static String dateToString(Date date) {
        return "";
    }
    public static Date stringToDate(String strDate) {
        try {
            return new java.sql.Date((new SimpleDateFormat("yyyy-MM-dd"))
                    .parse(strDate).getTime());
        }catch (Exception e) {
            return null;
        }
    }
}
