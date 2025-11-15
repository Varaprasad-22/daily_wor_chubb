package com.chubb.controller;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "tags")
public class TagsToOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Tag name cannot be blank")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Order> orders;

    public int getId() { return id; }

    public String getName() { return name; }
    
    public void setName(String name) { this.name = name; }

    public Set<Order> getOrders() { return orders; }
    
    public void setOrders(Set<Order> orders) { this.orders = orders; }
}
