package com.aptech.models;

import javax.persistence.*;

@Entity
@Table(name="tblProduct")
@NamedQueries({
    @NamedQuery(name = "Product.findByName",
            query = "SELECT a FROM Product a WHERE a.productName = :name")
})
public class Product {
	@Id
	private int ID;
	private String productName;
	private float price;
	private int quantity;
	
	public Product(int iD, String productName, float price, int quantity) {
		super();
		ID = iD;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
