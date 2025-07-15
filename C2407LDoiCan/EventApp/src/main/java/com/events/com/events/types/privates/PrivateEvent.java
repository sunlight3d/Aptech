package com.events.com.events.types.privates;

import com.events.core.Event;

import java.time.LocalDate;

public class PrivateEvent extends Event {
    protected String organizerName;
    protected boolean isInvitationOnly;

    public PrivateEvent(int eventID, String eventName, String location,
                        LocalDate eventDate,
                        int expectedParticipants, String organizerName) {
        super(eventID, eventName, location, eventDate, expectedParticipants);
        this.organizerName = organizerName;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public boolean isInvitationOnly() {
        return isInvitationOnly;
    }

    public void setInvitationOnly(boolean invitationOnly) {
        isInvitationOnly = invitationOnly;
    }

    public PrivateEvent() {

    }

    @Override
    public void input() {
        super.baseInput();
        System.out.println("Enter organizer's name: ");
        organizerName = Event.getScanner().nextLine();
        while (true) {
            System.out.println("isInvitationOnly(0 is false, 1 is true): ");
            int result = Event.getScanner().nextInt();
            isInvitationOnly = result == 1 ? true: false;
            if(result == 0 || result == 1) {
                break;
            }
        }


    }
    public double calculateEstimatedCost() {
        return isInvitationOnly ? 100_000 : 50_000;
    }
    @Override
    public void display() {
        System.out.println("PrivateEvent{" +
                "organizerName : '" + organizerName + '\'' +
                ", isInvitationOnly: " + isInvitationOnly +
                ", eventID : " + eventID +
                ", eventName='" + eventName + '\'' +
                ", location='" + location + '\'' +
                ", eventDate=" + eventDate +
                ", expectedParticipants=" + expectedParticipants +
                '}');
        System.out.println("Estimated cost: "+calculateEstimatedCost());
    }
}
