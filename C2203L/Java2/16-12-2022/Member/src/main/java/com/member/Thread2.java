package com.member;

public class Thread2 extends Thread{
    private DayOfWeek dayOfWeek;
    public Thread2(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("Thread2 is running");
            synchronized (this) {
                System.out.println(this.dayOfWeek.getDay("english"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

