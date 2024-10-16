package org.example.exercise02;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadData threadData = new ThreadData();
        for(int i = 0; i < threadData.getData().length; i++) {
            ThreadOne t1 = new ThreadOne(threadData);
            ThreadTwo t2 = new ThreadTwo(threadData);
            threadData.setCurrentIndex(i);
            t1.start();
            t1.join();
            t2.start();
        }

    }
}
