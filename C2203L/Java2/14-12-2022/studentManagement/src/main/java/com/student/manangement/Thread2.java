package com.student.manangement;

public class Thread2 extends Thread{
    private Data data;
    private String threadName;
    private Thread1 thread1;
    public Thread2(String threadName, Data data) {
        this.threadName = threadName;
        this.data = data;
    }
    @Override
    public void run() {
        try {
            System.out.println("Thread2 received: "+this.data.toUpperCase());
            thread1.join();
        } catch (Exception e) {
            System.err.println("Thread2 is interrupt: "+e.getMessage());
        }
    }

    public Thread1 getThread1() {
        return thread1;
    }

    public void setThread1(Thread1 thread1) {
        this.thread1 = thread1;
    }
}
