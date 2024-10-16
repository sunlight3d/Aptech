package com.student.manangement;

public class Thread1 extends Thread{
    private Data data;
    private String threadName;
    private Thread2 thread2;
    public Thread1(String threadName, Data data) {
        this.threadName = threadName;
        this.data = data;
    }
    @Override
    public void run() {
        String upperCaseString = data.toUpperCase();
        try {
            while (true) {
                sleep(1000);
                thread2.join();
            }
        } catch (InterruptedException e) {
            System.err.println("Thread1 is interrupt: "+e.getMessage());
        }
    }

    public Thread2 getThread2() {
        return thread2;
    }

    public void setThread2(Thread2 thread2) {
        this.thread2 = thread2;
    }
}
