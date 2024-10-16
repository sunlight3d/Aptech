package com.member;

public class DayOfWeek {
    private int index;
    private String[] vietnameseDays = new String[] {
                                    "Thu hai",
                                    "Thu ba",
                                    "Thu tu",
                                    "Thu nam",
                                    "Thu sau",
                                    "Thu bay",
                                    "Chu nhat"
    };
    private String[] englishDays = new String[] {
                                    "Monday",
                                    "Tuesday",
                                    "Wednesday",
                                    "Thursday",
                                    "Friday",
                                    "Saturday",
                                    "Sunday"
    };
    public String getDay(String language) {
        return language.equalsIgnoreCase("english")
                    ? englishDays[index] : vietnameseDays[index];
    }
    public void randomIndex() {
        index = (int)(Math.random() * ((vietnameseDays.length - 1) + 1));
    }
    public int getIndex() {
        return index;
    }
}
