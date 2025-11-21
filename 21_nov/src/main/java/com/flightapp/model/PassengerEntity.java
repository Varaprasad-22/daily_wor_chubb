package com.flightapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;
@Data
@Table("passengers")
public class PassengerEntity {
	@Id
	private int passengerId;
 
	private BookingEntity booking; 
	private String name;
	private String gender;
	private int age;
	private String meal;
    
	private String seatNo;

	
	public int getPassengerId() {
		return passengerId;
	}

	public BookingEntity getBooking() {
		return booking;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getMeal() {
		return meal;
	}

	public String getSeatNo() {
		return seatNo;
	}

	
	public void setBooking(BookingEntity booking) {
        this.booking = booking;
    }

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
}
