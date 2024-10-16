package com.aptech.bankaccount;

import com.aptech.bankaccount.models.Bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath =
                            "/Users/hoangnd/Documents/" +
                            "code/Aptech/C2109L/ADF1/29-09-2022/" +
                            "bankAccount/BankAccount/src/main/java/" +
                            "com/aptech/bankaccount/bankAccount.txt";
            InputStream inputStream = new FileInputStream(new File(filePath));
            Bank bank = new Bank("home bank");
            bank.readCustomerList(inputStream);
        }catch (Exception e) {
            System.err.println("Cannot read data : "+e.getMessage());
        }

        System.out.println("Hello world!");
    }
}