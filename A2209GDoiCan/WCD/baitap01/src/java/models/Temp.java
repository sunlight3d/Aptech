/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

//lombok
public class Temp {
    private int id;
    private String name;
    private float price;
    private float quantity;
    private String description;
    
    private static int ID_VALUE = 0;

    public Temp(String name, float price, float quantity, String description) {    
        Temp.ID_VALUE++;     
        this.id = Temp.ID_VALUE;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Temp() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
