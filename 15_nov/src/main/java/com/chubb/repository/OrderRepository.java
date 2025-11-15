package com.chubb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.chubb.controller.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
}