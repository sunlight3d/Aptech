package com.de02;

public class Exercise02 {
    public static void main(String[] args) throws InterruptedException {
        ThreadData threadData = new ThreadData();
        Thread1 thread1 = new Thread1(threadData);
        Thread2 thread2 = new Thread2(threadData);
        thread1.start();
        thread1.join();
        thread2.start();

    }
}
