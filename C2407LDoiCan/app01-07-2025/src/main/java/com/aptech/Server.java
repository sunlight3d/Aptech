package com.aptech;

public class Server {
    private int port;
    public void doSomething(){
        IPAddress ipAddress = new IPAddress();
        ipAddress.getIP();
    }
    private class IPAddress{
        public String getIP(){
            port = 100;
            return "192.168.1.18";
        }
    }
}

