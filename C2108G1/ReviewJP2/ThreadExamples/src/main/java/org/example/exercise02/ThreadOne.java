package org.example.exercise02;


public class ThreadOne extends Thread{
    private ThreadData threadData;
    public ThreadOne(ThreadData threadData) {
        this.threadData = threadData;
    }
    @Override
    public void run() {
        super.run();
        synchronized (threadData) {
            System.out.println("Thread1 - "+threadData.getData()[threadData.getCurrentIndex()]);
        }

    }
}
