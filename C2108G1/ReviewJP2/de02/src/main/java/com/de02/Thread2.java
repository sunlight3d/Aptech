package com.de02;

public class Thread2 extends Thread{
    private ThreadData threadData;
    public Thread2(ThreadData threadData) {
        this.threadData = threadData;
    }
    @Override
    public void run() {
        super.run();
        System.out.println("Thread2: "+threadData.getRandomDay(Language.VIETNAMESE));
    }
}
