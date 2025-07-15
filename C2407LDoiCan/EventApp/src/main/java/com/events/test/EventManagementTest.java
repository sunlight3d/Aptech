package com.events.test;

import com.events.com.events.types.privates.PrivateEvent;
import com.events.core.Event;
import com.events.types.publics.PublicEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class EventManagementTest {
    public static void main(String[] args) {
        int choice = 0;
        int numberOfPublicEvents = 0;
        int numberOfPrivateEvents = 0;
        List<Event> events = new ArrayList<>();
        while (choice != 5) {
            System.out.println("aha");
            System.out.println("Vui lòng chọn:");
            System.out.println("1. Nhập thông tin cho n Sự kiện Công cộng.");
            System.out.println("2. Nhập thông tin cho n Sự kiện Riêng tư.");
            System.out.println("3. Hiển thị thông tin các Sự kiện Công cộng (Sắp xếp theo giá vé tăng dần).");
            System.out.println("4. Hiển thị thông tin các Sự kiện Riêng tư (Sắp xếp theo tên người tổ chức A-Z).");
            System.out.println("5. Thoát.");
            System.out.println("Lựa chọn của bạn:");
            if(choice == 1) {
                System.out.println("Enter number of public events : ");
                numberOfPublicEvents = Event.getScanner().nextInt();
                for(int i = 0; i < numberOfPublicEvents; i++) {
                    PublicEvent publicEvent = new PublicEvent();
                    publicEvent.input();
                }
            }else if(choice == 2) {
                System.out.println("Enter number of private events : ");
                numberOfPrivateEvents = Event.getScanner().nextInt();
                for(int i = 0; i < numberOfPrivateEvents; i++) {
                    PrivateEvent privateEvent = new PrivateEvent();
                    privateEvent.input();
                }
            }else if(choice == 3) {
                List<Event> publicEvents = events.stream()
                        .filter((Event event) -> event instanceof PublicEvent)
                        .sorted((Event o1, Event o2) -> (int) (((PublicEvent)o1).getTicketPrice() - ((PublicEvent)o2).getTicketPrice()))
                        .toList();
            }else if(choice == 4) {

            }else {
                System.out.println("Please enter 1-5");
            }
        }


    }
}
