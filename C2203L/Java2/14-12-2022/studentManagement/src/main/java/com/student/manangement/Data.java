package com.student.manangement;

public class Data {
    private int currentIndex = 0;
    private String[] data = {"Em oi", "Ha Noi", "pho."};
    public String toUpperCase() {
        return data[currentIndex].toUpperCase();
    }
    public void increase(){
        currentIndex = currentIndex >= data.length - 1 ? 0 : currentIndex+1;
    }

}
