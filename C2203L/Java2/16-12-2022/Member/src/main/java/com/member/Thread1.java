package com.member;

public class Thread1 extends Thread{
    private DayOfWeek dayOfWeek;
//    private Thread2 thread2;
    public Thread1(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("Thread1 is running");
            sleep(1000);
            synchronized (this) {
                this.dayOfWeek.randomIndex();
                System.out.println(this.dayOfWeek.getDay("vietnamese"));
            }
            //thread2.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public Thread2 getThread2() {
//        return thread2;
//    }
//
//    public void setThread2(Thread2 thread2) {
//        this.thread2 = thread2;
//    }
}
