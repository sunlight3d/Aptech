package com.de02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ThreadData {
    private List<String> vietnameseDays = List.of(
                                            "Thu hai",
                                            "Thu ba",
                                            "Thu tu",
                                            "Thu nam",
                                            "Thu sau",
                                            "Thu bay",
                                            "Chu nhat");
    private List<String> englishDays = List.of(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday");
    public int selectedIndex = 0;
    public void generateSelectedIndex() {
        int min = 0;
        int max = vietnameseDays.size() - 1;
        int randomIndex =  (int)(Math.random()*(max-min+1)+min);
        selectedIndex = randomIndex;
    }
    public String getRandomDay(Language language) {
        if(language == Language.ENGLISH) {
            return englishDays.get(selectedIndex);
        }
        return vietnameseDays.get(selectedIndex);
    }
}
