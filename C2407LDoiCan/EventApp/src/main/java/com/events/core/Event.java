package com.events.core;
import java.time.LocalDate;
import java.util.Scanner;

public abstract class Event {
    protected int eventID;
    protected String eventName;
    protected String location;
    protected LocalDate eventDate;
    protected int expectedParticipants;

    public abstract void input();
    public abstract void display();

    public Event(int eventID, String eventName, 
            String location, 
            LocalDate eventDate, 
            int expectedParticipants) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.location = location;
        this.eventDate = eventDate;
        this.expectedParticipants = expectedParticipants;
    }

    public Event() {
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public int getExpectedParticipants() {
        return expectedParticipants;
    }

    public void setExpectedParticipants(int expectedParticipants) {
        this.expectedParticipants = expectedParticipants;
    }
    public static Scanner getScanner() {
        return new Scanner(System.in);
    }
    protected void baseInput() {
        System.out.println("Enter event's ID: ");
        eventID = Event.getScanner().nextInt();

        System.out.println("Enter event's name: ");
        eventName = Event.getScanner().nextLine();

        System.out.println("Enter location: ");
        location = Event.getScanner().nextLine();

        System.out.println("Event date(eg:24-12-2025): ");
        String strEventDate = Event.getScanner().nextLine();
        int day = Integer.parseInt(strEventDate.split("-")[0]);
        int month = Integer.parseInt(strEventDate.split("-")[1]);
        int year = Integer.parseInt(strEventDate.split("-")[2]);
        eventDate = LocalDate.of(year, month, day);

        System.out.println("Enter expected participants: ");
        expectedParticipants = Event.getScanner().nextInt();
    }

    
}
