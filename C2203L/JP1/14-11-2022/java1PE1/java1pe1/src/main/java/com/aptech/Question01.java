package com.aptech;

public class Question01 {
    public int countWord(String s) {
        return s.trim().split("\\s+").length;
    }
}
