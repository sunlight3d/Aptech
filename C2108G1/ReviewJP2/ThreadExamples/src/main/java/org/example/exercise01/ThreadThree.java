package org.example.exercise01;

public class ThreadThree extends Thread{
    private ThreadData threadData;
    public ThreadThree(ThreadData threadData) {
        this.threadData = threadData;
    }
    @Override
    public void run() {
        super.run();
        int sum = threadData.getRandomX() + threadData.getRandomY();
        System.out.println("sum = "+sum);
    }
}
