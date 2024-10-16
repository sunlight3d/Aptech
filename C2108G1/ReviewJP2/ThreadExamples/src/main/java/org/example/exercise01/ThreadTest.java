package org.example.exercise01;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadData threadData = new ThreadData();
        ThreadOne threadOne = new ThreadOne(threadData);
        ThreadTwo threadTwo = new ThreadTwo(threadData);
        ThreadThree threadThree = new ThreadThree(threadData);
        threadOne.start();
        threadOne.join();

        threadTwo.start();
        threadTwo.join();

        threadThree.start();
    }
}
