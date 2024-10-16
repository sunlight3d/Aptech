package com.myapp.aptech;

public class ThreadOne extends Thread{
    private Data data;
    public ThreadOne(Data data ) {
        this.data = data;
    }
    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                try {
                    sleep(1000);
                    synchronized(this) {
                        System.out.println("1111: ");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

//            for(int i = 0; i < data.getData().length; i++) {
//                synchronized (this) {
//                    sleep(1000);
//                    String eachItem = data.getData()[i].toUpperCase();
//                    System.out.println("Thread1 set item: "+eachItem);
//                    this.getData().setSelectedString(eachItem);
//                    //notify to thread2
//                    notify();
//                }
//            }
        } catch (Exception e) {
            System.err.println("Cannot run thread1: "+e.getMessage());
        }
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
