package com.aptech;

import com.aptech.models.Opportunity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.aptech.Helper.getBufferReader;

public class Main {
    public static void main(String[] args) {
        OppotunityManager oppotunityManager = new OppotunityManager();
        oppotunityManager.inputOppotunities();
        System.out.println("After input");
        oppotunityManager.showAllOppotunities();
        oppotunityManager.saveToFile();
        oppotunityManager.readFromFile();
        System.out.println("After read from file");
        oppotunityManager.showAllOppotunities();
    }
}