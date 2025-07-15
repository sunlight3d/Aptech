package com.events.types.publics;

import com.events.core.Event;

import java.time.LocalDate;

public class PublicEvent extends Event {
    protected double ticketPrice;
    protected int minAgeRequirement;

    public PublicEvent(int eventID, String eventName, String location,
                       LocalDate eventDate, int expectedParticipants,
                       double ticketPrice, int minAgeRequirement) {
        super(eventID, eventName, location, eventDate, expectedParticipants);
        this.ticketPrice = ticketPrice;
        this.minAgeRequirement = minAgeRequirement;
    }
    public PublicEvent() {
        super();
        ticketPrice = 0.0;
        minAgeRequirement = 18;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getMinAgeRequirement() {
        return minAgeRequirement;
    }

    public void setMinAgeRequirement(int minAgeRequirement) {
        this.minAgeRequirement = minAgeRequirement;
    }

    @Override
    public void input() {
        super.baseInput();
        System.out.println("Enter ticket price: ");
        ticketPrice = Double.parseDouble(Event.getScanner().nextLine());

        System.out.println("Enter min age requirement: ");
        minAgeRequirement = Integer.parseInt(Event.getScanner().nextLine());


    }

    @Override
    public void display() {
        System.out.println("PublicEvent{" +
                "eventID=" + eventID +
                ", eventName='" + eventName + '\'' +
                ", location='" + location + '\'' +
                ", eventDate=" + eventDate +
                ", expectedParticipants=" + expectedParticipants +
                ", ticketPrice=" + ticketPrice +
                ", minAgeRequirement=" + minAgeRequirement +
                '}');
    }
}
