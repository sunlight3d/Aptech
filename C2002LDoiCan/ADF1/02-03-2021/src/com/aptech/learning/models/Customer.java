package com.aptech.learning.models;

public class Customer {
    private String customerId;
    private String customerName;
    private String destination;
    private Double price; //field
    //Encapsulation
    //gop field + getter + setter => property

    public Customer(String customerId, String customerName,
                    String destination, Double price) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.destination = destination;
        this.price = price;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                '}';
    }
}
