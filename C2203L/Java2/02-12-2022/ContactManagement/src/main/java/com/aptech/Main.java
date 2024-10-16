package com.aptech;

import com.aptech.models.Contact;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        ContactRepository contactRepository = new ContactRepository();
//        contactRepository.insertContact(new Contact("11", "nguyen",
//                "van a", "0121544545", "street A, roadB", "male"));
        //ArrayList<Contact> contacts = contactRepository.getContacts();
//        contactRepository.updateContact("11", new Contact("11", "nguyen1",
//                "van axx", "0991544545", "street B, roadB", "famele"));
        //contactRepository.deleteContact("11");
        ContactForm contactForm = new ContactForm("Contact Management");
        contactForm.show();
    }
}