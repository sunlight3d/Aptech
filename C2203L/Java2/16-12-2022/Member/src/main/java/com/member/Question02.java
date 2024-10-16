package com.member;

public class Question02 {
    public static void main(String[] args) throws Exception{
        DayOfWeek dayOfWeek = new DayOfWeek();
        Thread1 thread1 = new Thread1(dayOfWeek);
        Thread2 thread2 = new Thread2(dayOfWeek);
//        thread1.setThread2(thread2);
        thread1.start();
        thread1.join();
        thread2.start();
    }
}
