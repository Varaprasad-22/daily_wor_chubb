package com.flightapp.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
@Data
@Table("flight")
public class FlightEntity {
	@Id
	private int flightId;
	private int airlineId;
	private String flightNumber;
	private String fromLocation;
	private String toLocation;
	private LocalDateTime depatureTime;
	private LocalDateTime arrivalTime;
	private double price;
	private int totalSeats;
	private int avaliSeats;
	
	public int getFlightId() {
		return flightId;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	
	public double getPrice() {
		return price;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public int getAvaliSeats() {
		return avaliSeats;
	}
	public void setAvaliSeats(int avaliSeats) {
		this.avaliSeats = avaliSeats;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public void setDepatureTime(LocalDateTime depatureTime) {
		this.depatureTime = depatureTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepatureTime() {
		return depatureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	
}
