package com.aptech;

public class MyThread extends Thread{
    private SharedObject sharedObject;
    private String url;
    private String name;
    public MyThread(SharedObject sharedObject, String url, String name) {
        super();
        this.sharedObject = sharedObject;
        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {
        super.run();
        try {
            while (true) {
                sleep(0);
                sharedObject.sendGET(url);
                synchronized (this){
                    sharedObject.increase();
                }
                System.out.println(this.name + " is running");
                sharedObject.display();
            }
        } catch (InterruptedException e) {
            System.err.println(this.name + " is failed:"+e.getMessage());
        }
    }
}
