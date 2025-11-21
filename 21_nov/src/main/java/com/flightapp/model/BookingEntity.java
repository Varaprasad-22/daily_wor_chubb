package com.flightapp.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Table("booking")
public class BookingEntity {
	@Id
	private int bookingId;
	private String emailId;
	
	private String pnr;
	
	private Integer userId;
	private Integer flightId;
	private Integer returnFlightId;
	 private LocalDateTime bookingTime;
	 private Integer noOfSeats;
	private Boolean status;
	 private List<PassengerEntity> passengers = new ArrayList<>();

	 public void addPassenger(PassengerEntity passenger) {
	       passengers.add(passenger);
	  }

	 public int getBookingId() {
		 return bookingId;
	 }

	 public void setBookingId(int bookingId) {
		 this.bookingId = bookingId;
	 }

	 public String getEmailId() {
		 return emailId;
	 }

	 public void setEmailId(String emailId) {
		 this.emailId = emailId;
	 }

	 public String getPnr() {
		 return pnr;
	 }

	 public void setPnr(String pnr) {
		 this.pnr = pnr;
	 }

	 public Integer getUserId() {
		 return userId;
	 }

	 public void setUserId(Integer userId) {
		 this.userId = userId;
	 }

	 public Integer getFlightId() {
		 return flightId;
	 }

	 public void setFlightId(Integer flightId) {
		 this.flightId = flightId;
	 }

	 public Integer getReturnFlightId() {
		 return returnFlightId;
	 }

	 public void setReturnFlightId(Integer returnFlightId) {
		 this.returnFlightId = returnFlightId;
	 }

	 public LocalDateTime getBookingTime() {
		 return bookingTime;
	 }

	 public void setBookingTime(LocalDateTime bookingTime) {
		 this.bookingTime = bookingTime;
	 }

	 public Integer getNoOfSeats() {
		 return noOfSeats;
	 }

	 public void setNoOfSeats(Integer noOfSeats) {
		 this.noOfSeats = noOfSeats;
	 }

	 public Boolean getStatus() {
		 return status;
	 }

	 public void setStatus(Boolean status) {
		 this.status = status;
	 }

	 public List<PassengerEntity> getPassengers() {
		 return passengers;
	 }

	 public void setPassengers(List<PassengerEntity> passengers) {
		 this.passengers = passengers;
	 }
}
