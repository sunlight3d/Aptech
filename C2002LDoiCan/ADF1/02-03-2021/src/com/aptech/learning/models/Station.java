package com.aptech.learning.models;

import java.util.ArrayList;

public class Station {
    private String stationName = "";
    private ArrayList<Customer> pendingCustomers = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    // c1, c2, c3 , c4
    //Queue : First In First Out = FIFO
    //Stack: Last In First Out = LIFO = tu quan ao
    public void addCustomer(Customer customer) {
        Customer foundCustomer = customers.stream()
          .filter(eachCustomer -> eachCustomer.getCustomerId()
                  .equals(customer.getCustomerId()))
          .findAny()
          .orElse(null);
        if(foundCustomer == null) {
            pendingCustomers.add(customer);
        }
    }
    public Boolean hasPendingCustomers() {
        return pendingCustomers.size() > 0;
    }
    public void buyTicket() {
        if(pendingCustomers.size() > 0){
            Customer customer = pendingCustomers.get(0);
            this.customers.add(customer);
            this.pendingCustomers.remove(0);
        }

    }
    public void showAllCustomers(){
        for (Customer customer:this.customers) {
            System.out.println(customer.toString());
        }
    }
    public void cancelTicket(Customer customer) {
        this.pendingCustomers.remove(customer);
    }

    @Override
    public String toString() {
        return "Station details: " +
                "pendingCustomers=" + pendingCustomers +
                ", customers=" + customers +
                ", stationName = "+this.stationName;
    }
}
