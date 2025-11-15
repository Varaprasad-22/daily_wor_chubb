package com.chubb.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order {
	@Min(value = 1)
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public double totalPrice() {
		return quantity*price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@NotBlank
	private String item;
	
	private float price;
	private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
