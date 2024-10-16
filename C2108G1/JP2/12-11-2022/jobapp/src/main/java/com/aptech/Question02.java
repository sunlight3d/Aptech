package com.aptech;

import java.util.*;

public class Question02 {
    public static void main(String [] args) {
        ThreadData threadData = new ThreadData();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    while (true) {
                        sleep(1);
                        synchronized (this) {
                            Map<String, String > map = threadData.getMap();
                            int randomIndex = (new Random()).nextInt(map.size() - 1);
                            threadData.setRandomIndex(randomIndex);
                            List<String> keysAsArray = new ArrayList<String>(map.keySet());
                            System.out.println("thread1: "
                                    +keysAsArray.get(randomIndex)+
                                    ",randomIndex: "+randomIndex);
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    while (true) {
                        sleep(1);
                        synchronized (this) {
                            Map<String, String > map = threadData.getMap();
                            int randomIndex = threadData.getRandomIndex();
                            if(randomIndex > 0) {
                                List<String> keysAsArray = new ArrayList<String>(map.keySet());
                                System.out.println("thread2: "
                                        +map.get(keysAsArray.get(randomIndex))
                                        +",randomIndex: "+randomIndex);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        };
        thread1.start();
        thread2.start();
    }
}
