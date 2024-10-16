package com.de02;

public class Thread1 extends Thread{
    private ThreadData threadData;
    public Thread1(ThreadData threadData) {
        this.threadData = threadData;
    }
    @Override
    public void run() {
        super.run();
        try {
            synchronized (this) {
                Thread.sleep(1000);
                threadData.generateSelectedIndex();
                System.out.println("Thread1: "+threadData.getRandomDay(Language.ENGLISH));
            }
        } catch (InterruptedException e) {
            System.err.println("Error in thread1"+e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
