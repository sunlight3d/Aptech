package com.smarthome;

import com.smarthome.devices.SmartLight;
import com.smarthome.devices.SmartSpeaker;
import com.smarthome.interfaces.Configurable;
import com.smarthome.interfaces.Controllable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Controllable> devices = new ArrayList<>();
        devices.add(new SmartLight("smart light 1"));
        devices.add(new SmartSpeaker("smart speaker 3"));
        devices.add(new SmartSpeaker("smart speaker 4"));
        devices.add(new SmartLight("smart light 2"));
        devices.add(new SmartSpeaker("smart speaker 1"));
        devices.add(new SmartLight("smart light 3"));
        devices.add(new SmartSpeaker("smart speaker 2"));
        for(Controllable eachDevice: devices) {
            eachDevice.turnOn();
        }
        int numberOfSmartLight = 0;
        int numberOfSmartSpeaker = 0;
        /*
        for(Controllable eachDevice: devices) {
            if(eachDevice instanceof SmartLight) {
                numberOfSmartLight++;
            } else if(eachDevice instanceof SmartSpeaker) {
                numberOfSmartSpeaker++;
            }
        }
        */
        //using lambda expression
        numberOfSmartLight = (int)devices.stream()
                .filter((Controllable controllable)-> controllable instanceof SmartLight)
                .count();
        numberOfSmartSpeaker = (int)devices.stream()
                .filter((Controllable controllable)-> controllable instanceof SmartSpeaker)
                .count();
        System.out.printf("numberOfSmartLight = %d, numberOfSmartSpeaker = %d",
                numberOfSmartLight, numberOfSmartSpeaker);

    }
}