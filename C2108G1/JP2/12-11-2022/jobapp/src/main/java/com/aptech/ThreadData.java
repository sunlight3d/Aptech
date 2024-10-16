package com.aptech;

import java.util.HashMap;
import java.util.Map;

public class ThreadData {
    private  Map<String, String> map;
    private int randomIndex;

    public ThreadData() {
        this.map = new HashMap<>();
        map.put("Monday", "Thu 2");
        map.put("Tuesday", "Thu 3");
        map.put("Wednesday", "Thu 4");
        map.put("Thursday", "Thu 5");
        map.put("Friday", "Thu 6");
        map.put("Saturday", "Thu 7");
        map.put("Sunday", "Chu nhat");
        this.randomIndex = -1;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public int getRandomIndex() {
        return randomIndex;
    }

    public void setRandomIndex(int randomIndex) {
        this.randomIndex = randomIndex;
    }
}
