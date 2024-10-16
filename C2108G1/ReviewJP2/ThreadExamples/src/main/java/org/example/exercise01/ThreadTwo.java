package org.example.exercise01;

public class ThreadTwo extends Thread{
    private ThreadData threadData;
    public ThreadTwo(ThreadData threadData) {
        this.threadData = threadData;
    }
    @Override
    public void run() {
        super.run();
        synchronized (this) {
            int randomY = threadData.generateRandomNumber(100, 200);
            threadData.setRandomY(randomY);
            System.out.println("y = "+randomY);
        }
    }
}

