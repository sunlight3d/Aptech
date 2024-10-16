package com.aptech.nguyenvana;

import java.io.IOException;
import java.io.Serializable;

import static com.aptech.nguyenvana.Helper.getBufferedReader;
import static com.aptech.nguyenvana.Helper.println;

public class TestResult implements Serializable {
    private String testDate;
    private int testDuration;
    private String testRoom;
    private int totalStudent;

    public TestResult() {}
    public TestResult(String testDate, int testDuration,
                      String testRoom, int totalStudent) {
        this.testDate = testDate;
        this.testDuration = testDuration;
        this.testRoom = testRoom;
        this.totalStudent = totalStudent;
    }
    public void input()  {
        try {
            println("Enter test date(eg: 2022-12-25)");
            this.testDate = getBufferedReader().readLine();

            println("Enter test's duration: ");
            this.testDuration = Integer.parseInt(getBufferedReader().readLine());

            println("Test room: ");
            this.testRoom = getBufferedReader().readLine();

            println("Enter total student: ");
            this.totalStudent = Integer.parseInt(getBufferedReader().readLine());
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void display() {
        println("TestResult{" +
                "testDate='" + testDate + '\'' +
                ", testDuration=" + testDuration +
                ", testRoom='" + testRoom + '\'' +
                ", totalStudent=" + totalStudent);
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
}
