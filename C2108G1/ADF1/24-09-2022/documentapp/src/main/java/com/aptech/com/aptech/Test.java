package com.aptech.com.aptech;

import aptech.data.manager.DocumentManager;

import javax.swing.text.Document;

public class Test {
     public static void main(String[] args) {
          DocumentManager documentManager = new DocumentManager();
          //fake data
          documentManager.fakeData();
          documentManager.analyze();
     }
}
