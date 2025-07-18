package com.smarthome.devices;

import com.smarthome.interfaces.Configurable;
import com.smarthome.interfaces.Controllable;
import com.smarthome.interfaces.VoiceAssistantCompatible;

public class SmartSpeaker extends SmartDevice
        implements Controllable, Configurable, VoiceAssistantCompatible {
    public SmartSpeaker(String name) {
        super(name);
    }

    @Override
    public void deviceInfo() {
        System.out.println("deviceInfo of SmartSpeaker");
    }

    @Override
    public void configure(String settings) {
        System.out.println("settings of SmartSpeaker");
    }

    @Override
    public void turnOn() {
        System.out.println("turnOn of SmartSpeaker");
    }

    @Override
    public void turnOff() {
        System.out.println("turnOff of SmartSpeaker");
    }

    @Override
    public void respondToVoiceCommand(String command) {
        System.out.println("respondToVoiceCommand of SmartSpeaker");
    }
}
