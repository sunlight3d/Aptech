package com.student.manangement;

import static java.lang.Thread.sleep;

public class Question02 {
    public static void main(String[] args) {
        Data data = new Data();
        Thread1 thread1 = new Thread1("Thread1", data);
        Thread2 thread2 = new Thread2("Thread2", data);
        thread1.setThread2(thread2);
        thread2.setThread1(thread1);
        thread1.start();
        thread2.start();
    }
}
