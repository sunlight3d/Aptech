package com.aptech;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.aptech.aprotrain.Helper.inputString;

public class Excercise1 {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();
        String url = "http://aptech.com.vn";
        //189 reqs 1 minute, 2 threads
        //326 reqs 1 minute, 5 threads
        //853 reqs 1 minute, 20 threads
        int numberOfThreads = 8000;
        ArrayList<MyThread> threads = new ArrayList<>();
        for(int i = 0; i < numberOfThreads; i++) {
            System.out.println("numberOfThreads : "+i);
            MyThread thread = new MyThread(sharedObject, url, String.format("t%d", i+1));
            threads.add(thread);
            //thread.start();
        }

        for (MyThread thread: threads) {
            thread.start();
        }
    }
}
