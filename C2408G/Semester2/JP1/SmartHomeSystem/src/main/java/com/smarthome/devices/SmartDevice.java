package com.smarthome.devices;

public abstract class SmartDevice {
    protected String name;
    protected boolean isOn;

    public SmartDevice(String name) {
        this.name = name;
    }
    public void status() {
        System.out.println("Device's name: "+name+",isOn: "+isOn);
    }
    public abstract void deviceInfo();
}
