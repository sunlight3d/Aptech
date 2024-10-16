package org.aptech;

import java.util.ArrayList;

public class Excercise02 {
    public static void main(String[] args) {
        ArrayList<String[]> days = new ArrayList<String[]>();
        days.add(new String[]{"Monday", "Thu hai"});
        days.add(new String[]{"Tuesday", "Thu ba"});
        days.add(new String[]{"Wednesday", "Thu tu"});
        days.add(new String[]{"Thursday", "Thu nam"});
        days.add(new String[]{"Friday", "Thu sau"});
        days.add(new String[]{"Saturday", "Thu bay"});
        days.add(new String[]{"Sunday", "Chu nhat"});

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                        int randomIndex = (int )(Math.random() * days.size() + 1) - 1;
                        synchronized(this) {
                            String language = days.get(randomIndex)[1];
                            System.out.println("language: "+language);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(1000);
                        int randomIndex = (int )(Math.random() * days.size() + 1) - 1;
                        synchronized(this) {
                            String language = days.get(randomIndex)[0];
                            System.out.println("language: "+language);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
