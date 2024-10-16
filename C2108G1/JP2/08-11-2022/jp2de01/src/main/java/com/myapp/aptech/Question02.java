package com.myapp.aptech;

public class Question02 {
    public static void main(String[] args) {
        Data data = new Data();
        ThreadOne threadOne = new ThreadOne(data);
        ThreadTwo threadTwo = new ThreadTwo(data);
        threadOne.start();
        threadTwo.start();
        System.out.println("2 threads ended");
    }
}
