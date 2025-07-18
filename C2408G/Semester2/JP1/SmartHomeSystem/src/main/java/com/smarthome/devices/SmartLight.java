package com.smarthome.devices;

import com.smarthome.interfaces.Configurable;
import com.smarthome.interfaces.Controllable;

public class SmartLight extends SmartDevice implements Configurable, Controllable {
    public SmartLight(String name) {
        super(name);
    }

    @Override
    public void deviceInfo() {
        System.out.println("deviceInfo of SmartLight");
    }

    @Override
    public void configure(String settings) {
        System.out.println("configure of SmartLight");
    }

    @Override
    public void turnOn() {
        System.out.println("turnOn of SmartLight");
    }

    @Override
    public void turnOff() {
        System.out.println("turnOff of SmartLight");
    }
}
