package org.example.exercise01;

public class ThreadOne extends Thread{
    private ThreadData threadData;
    public ThreadOne(ThreadData threadData) {
        this.threadData = threadData;
    }
    @Override
    public void run() {
        super.run();
        synchronized (this) {
            int randomX = threadData.generateRandomNumber(0, 100);
            threadData.setRandomX(randomX);
            System.out.println("x = "+randomX);
        }
    }
}
