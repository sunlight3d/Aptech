package com.aptech.learning.constrollers;

import com.aptech.learning.models.Customer;
import com.aptech.learning.models.Station;

import java.util.ArrayList;

public class TicketManagement {
    private ArrayList<Station> stations = new ArrayList<Station>();
    public void showStationStatistics() {
        System.out.println("Danh sach customer co KH doi");
        for (Station station:this.stations) {
            if(station.hasPendingCustomers() == true){
                System.out.println(station.toString());
            }
        }
    }
    public void showAllCustomers() {
        System.out.println("Danh sach customer cua cac ga");
        for (Station station:this.stations) {
            station.showAllCustomers();
        }
    }
}
