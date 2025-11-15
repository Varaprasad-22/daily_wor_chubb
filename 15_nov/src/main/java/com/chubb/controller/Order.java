package com.chubb.controller;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "Item name cannot be empty")
	private String item;

	@Min(value = 1, message = "Price must be >= 1")
	private float price;

	@Min(value = 1, message = "Quantity must be >= 1")
	private int quantity;

	@Embedded
	private Address address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderItem> items;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	        name = "joinOrderTagTable",
	        joinColumns = @JoinColumn(name = "order_id"),
	        inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private Set<TagsToOrders> tags;

	public Set<TagsToOrders> getTags() {
		return tags;
	}

	public void setTags(Set<TagsToOrders> tags) {
		this.tags = tags;
	}

	public int getId() {
		return id;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float totalPrice() {
		return this.quantity * this.price;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
}
