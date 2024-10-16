package com.aptech.learning;
import com.aptech.models.Film;

import java.math.*;
import java.util.Locale;

public class Main {
    public static void saySomething(String sentence) {
        //instance(non-static) method
        System.out.println(sentence);
    }
    public static void main(String[] args) {
	    int x = 100;
	    float y = x;//ok, implicit casting(automatic)
        float a = 100.0f;
        //int b = a;//error
        int b = (int)a;//ok, explicit casting
        //kieu Long
        long creditCardNumber = 2561_7520_1122_4455L;//de nhin
        //kieu du lieu liet ke = enumeration
        //enum = chi nhan 1 vai gia tri nao do
        Quality quality = Quality.PERFECT;
        System.out.println("Quality is : "+quality);
        Main.saySomething("This is my pet");
        System.out.println("so pi = "+Math.PI);
        //absolute a number
        System.out.println("absolute of -3.25 is : "+Math.abs(-3.25));
        //new = malloc in C
        Film film1 = new Film("Huong duong nguoc nang", 2020, 45.0);
        Film film4 = new Film("Huong duong nguoc nang", 2020, 45.0);
        Film film2 = new Film("Ke huy diet newest", 2019, 120.0);
        Film film3 = film1;//film3 tham chieu den film1,
        System.out.println("hashcode of film1 = "+film1.hashCode());
        System.out.println("hashcode of film3 = "+film3.hashCode());
        if(film1 == film3) {
            System.out.println("2 objects are the same");
        }
        //film1 va film4 giong nhau ve noi dung, khac nhau ve "memory address"
        if(film1.getName().equals(film4.getName()) &&
                film1.getYear().equals(film4.getYear()) &&
                film1.getDuration().equals(film4.getDuration())
        ) {
            //co cach nao so sanh tot hon ? Yes
            System.out.println("2 objects are the same content");
        }
        //film3 references to film1
        //film1.name = "Huong duongnguwoc nang 123";//ko dc vi thuoc tinh name la private
        film1.setName("Huong duongnguwoc nang 123");
        //Hien ra thong tin cua doi tuong film1 ?
        System.out.println("thong tin cua film1: "+film1.toString());
        //can phai viet lai ham toString
        //doi tuong film1 co 2 bien tham chieu den: film1, film3
        film3 = null;
        film1 = null;
        //Garbage collection => don rac noi chua dia chi cu cua film1
        System.out.println("xem xong film");
        String name = "      Hoang   ";
        System.out.println("First character is : "+name.charAt(0));
        System.out.println("Last character is : "+name.charAt(name.length() - 1));
        System.out.println("uppercase is : "+name.toUpperCase());
        String modifiedName = name.trim();
        System.out.println("modifiedName is : "+modifiedName);
    }

}
