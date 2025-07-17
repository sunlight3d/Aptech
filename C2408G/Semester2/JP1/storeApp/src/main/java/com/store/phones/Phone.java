
package com.store.phones;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Phone implements IPhone{

    private String name;
    private String brand;
    private double price;
    private int quantity;
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public Phone(String name, String brand, double price, int quantity) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public Phone() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    @Override
    public void inputDetails() {
        try {
            while(true) {
                System.out.println("Enter name: ");
                String name = bufferedReader.readLine();
                if(name.length() < 3) {
                    System.err.println("Name must be at least 3 characters");
                } else {
                    this.name = name;
                    break;
                }                
            }
            while(true) {
                System.out.println("Enter price: ");
                double price = Double.parseDouble(bufferedReader.readLine());
                if(price < 0) {
                    System.err.println("Price must be > 0");
                } else {
                    this.price = price;
                    break;
                }                
            }
            while(true) {
                System.out.println("Enter quantity: ");
                Integer quantity = Integer.parseInt(bufferedReader.readLine());
                if(quantity <= 0) {
                    System.err.println("Quantity must be > 0");
                } else {
                    this.quantity = quantity;
                    break;
                }                
            }
            
            
        }catch(Exception e) {
            System.err.println("Cannot input data, error: "+e.getMessage());
        } finally {
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Phone Name: "+this.name);
        System.out.println("Brand: "+this.brand);
        System.out.println("Price: "+this.price);
        System.out.println("Quantity: "+this.quantity);
    }
    public void calculateTotalPrice() {
       double totalPrice = price * quantity;
        System.out.println("The total price for "+quantity+
                " unit of "+this.name+" is "+totalPrice);
     
    }
}
