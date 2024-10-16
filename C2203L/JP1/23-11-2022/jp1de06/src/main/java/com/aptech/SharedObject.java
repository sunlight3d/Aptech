package com.aptech;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static jdk.internal.net.http.HttpRequestImpl.USER_AGENT;

public class SharedObject {
    private int counter = 0;

    //only read - must NOT be synchronized
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    //change object => must be synchronized
    public void increase() {
        counter++;
    }
    public void display() {
        System.out.println("current counter is: "+counter);
    }
    public void sendGET(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            //con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
        }catch (Exception e) {
            System.out.println("Cannot send request"+e.getMessage());
        }
    }
}
