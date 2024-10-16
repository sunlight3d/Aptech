package com.myapp.aptech;

public class ThreadTwo extends Thread{
    private Data data;
    public ThreadTwo(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                synchronized (this) {
                    sleep(1000);
                    System.out.println("222222");
                    System.out.println("Thread2 received: " + data.getSelectedString());
//                    if(data.getSelectedString() == null) {
//                        break;
//                    } else {
//
//                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //sleep(200);
        }

    }
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}