package com.aptech;

import javax.xml.crypto.Data;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        ContactForm contactForm = new ContactForm("Contact Management");
        contactForm.show();
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        System.out.println("haha");
    }
}