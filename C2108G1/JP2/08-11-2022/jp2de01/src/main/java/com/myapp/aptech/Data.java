package com.myapp.aptech;

import java.util.Random;

public class Data {
    private String[] data = {"Em oi", "Ha Noi", "pho."};
    private String selectedString;
    public String[] getData() {
        return this.data;
    }
    public String getSelectedString() {
        return selectedString;
    }
    public void setSelectedString(String item) {
        this.selectedString = item;
    }
}
