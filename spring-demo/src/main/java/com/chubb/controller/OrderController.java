package com.chubb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chubb.request.Order;
import com.chubb.service.OrderService;

import jakarta.validation.Valid;

@RestController()
public class OrderController {
	@Autowired
	private OrderService orderservice;
	
	@GetMapping("/order")
	String getOrder() {
		return "HELLO";
	}
	
	@PostMapping("/order")
	Order SaveData(@RequestBody @Valid Order a) {
		System.out.println(a.totalPrice());
		a.totalPrice();
		orderservice.insertOrder();
		return a;
	}
}
