package com.aptech;

import java.io.Serializable;

import static com.aptech.Helper.inputInt;
import static com.aptech.Helper.inputString;

public class TestResult implements Serializable {
    private String testDate;
    private int testDuration;
    private String testRoom;
    private int totalStudent;

    public TestResult() {

    }

    public TestResult(String testDate, int testDuration, String testRoom, int totalStudent) {
        this.testDate = testDate;
        this.testDuration = testDuration;
        this.testRoom = testRoom;
        this.totalStudent = totalStudent;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public int getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(int testDuration) {
        this.testDuration = testDuration;
    }

    public String getTestRoom() {
        return testRoom;
    }

    public void setTestRoom(String testRoom) {
        this.testRoom = testRoom;
    }

    public int getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "testDate='" + testDate + '\'' +
                ", testDuration=" + testDuration +
                ", testRoom='" + testRoom + '\'' +
                ", totalStudent=" + totalStudent +
                '}';
    }
    public void input() {
        this.testDate = inputString("Enter test date:");
        this.testDuration = inputInt("Enter test duration:");
        this.testRoom = inputString("Enter test's room:");
        this.totalStudent = inputInt("Enter total student:");
    }
    public void display() {
        System.out.println(this.toString());
    }
}
