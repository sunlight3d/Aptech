package org.example.exercise02;

public class ThreadTwo extends Thread{
    private ThreadData threadData;
    public ThreadTwo(ThreadData threadData) {
        this.threadData = threadData;
    }
    @Override
    public void run() {
        super.run();
        synchronized (threadData) {
            String currentValue = threadData.getData()[threadData.getCurrentIndex()];
            currentValue = currentValue.toUpperCase();
            System.out.println("Thread 2 - "+currentValue);
        }

    }
}
