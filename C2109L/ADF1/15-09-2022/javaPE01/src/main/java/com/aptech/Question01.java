package com.aptech;

public class Question01 {
    //this is an "instance method"
    public int countWord(String s) {
        /*
        String[] names = s.split(" ");
        return names.length;
        */
        return s == null ? 0 : s.split(" ").length;
    }
}
