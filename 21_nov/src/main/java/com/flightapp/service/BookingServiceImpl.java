package com.flightapp.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightapp.dto.BookingGetResponse;
import com.flightapp.dto.Bookingdto;
import com.flightapp.dto.Passengers;
import com.flightapp.exceptions.BookingException;
import com.flightapp.exceptions.ResourceNotFoundException;
import com.flightapp.model.BookingEntity;
import com.flightapp.model.FlightEntity;
import com.flightapp.model.PassengerEntity;
import com.flightapp.model.User;
import com.flightapp.repository.BookingRepository;
import com.flightapp.repository.FlightRepository;
import com.flightapp.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Mono<String> bookFlight(Bookingdto data) {

	    int outboundId = data.getOutboundFlightId();

	    Mono<FlightEntity> outboundFlight = flightRepository.findById(outboundId)
	            .switchIfEmpty(Mono.error(
	                    new ResourceNotFoundException("Outbound flight not found")));

	    Mono<User> userModel = userRepository.findByEmail(data.getEmailId())
	            .switchIfEmpty(
	                Mono.defer(() -> {
	                    User newUser = new User();
	                    newUser.setEmail(data.getEmailId());
	                    newUser.setName(data.getName());
	                    return userRepository.save(newUser);
	                })
	            );
	    return outboundFlight.zipWith(userModel)
	    	    .flatMap(tuple -> {

	    	        FlightEntity outFlight = tuple.getT1();
	    	        User user = tuple.getT2();

	    	        if (outFlight.getAvaliSeats() < data.getNoOfSeats()) {
	    	            throw new BookingException("Not enough seats in outbound flight.");
	    	        }

	    	        BookingEntity bookingEntity = new BookingEntity();
	    	        bookingEntity.setUserId(user.getUserId());
	    	        bookingEntity.setEmailId(data.getEmailId());
	    	        bookingEntity.setFlightId(outFlight.getFlightId());
	    	        bookingEntity.setNoOfSeats(data.getNoOfSeats());
	    	        bookingEntity.setStatus(true);
	    	        bookingEntity.setBookingTime(LocalDateTime.now());
	    	        bookingEntity.setPnr(UUID.randomUUID().toString().substring(0, 8).toUpperCase());

	    	        data.getPassengers().forEach(p -> {
	    	            PassengerEntity passenger = new PassengerEntity();
	    	            passenger.setName(p.getName());
	    	            passenger.setAge(p.getAge());
	    	            passenger.setGender(p.getGender());
	    	            passenger.setMeal(p.getMeal());
	    	            passenger.setSeatNo(p.getSeatNo());
	    	            bookingEntity.addPassenger(passenger);
	    	        });

	    	        outFlight.setAvaliSeats(outFlight.getAvaliSeats() - data.getNoOfSeats());

	    	        return bookingRepository.save(bookingEntity)
	    	                .then(flightRepository.save(outFlight))
	    	                .thenReturn(bookingEntity);
	    	    })
	    	    .flatMap(bookingEntity -> {

	    	        if (data.getReturnFlightId() != null) {
	    	            return flightRepository.findById(data.getReturnFlightId())
	    	                    .switchIfEmpty(Mono.error(
	    	                            new ResourceNotFoundException("Return flight not found")))
	    	                    .flatMap(returnFlight -> {

	    	                        if (returnFlight.getAvaliSeats() < data.getNoOfSeats()) {
	    	                            throw new BookingException("Not enough seats in return flight.");
	    	                        }

	    	                        returnFlight.setAvaliSeats(returnFlight.getAvaliSeats() - data.getNoOfSeats());
	    	                        bookingEntity.setReturnFlightId(returnFlight.getFlightId());

	    	                        return flightRepository.save(returnFlight)
	    	                                .then(bookingRepository.save(bookingEntity))
	    	                                .thenReturn("Round-trip Booking Successful! PNR: " + bookingEntity.getPnr());
	    	                    });
	    	        }

	    	        return Mono.just("One-way Booking Successful! PNR: " + bookingEntity.getPnr());
	    	    });

	}


	@Override
	public Mono<BookingGetResponse> getBookingDetails(String pnr) {
		// TODO Auto-generated method stub
		
		return  bookingRepository.findByPnr(pnr)
				.switchIfEmpty(Mono.error(
						new ResourceNotFoundException("No booking found with PNR: " + pnr)))
				.flatMap(booking -> 
	            flightRepository.findById(booking.getFlightId())
	                .map(flight -> {

	                    BookingGetResponse response = new BookingGetResponse();
	                    response.setPnr(booking.getPnr());
	                    response.setFlightId(String.valueOf(flight.getFlightId()));
	                    List<Passengers> passengersList = booking.getPassengers().stream().map(entity -> {
						Passengers passengerDto = new Passengers();
						passengerDto.setName(entity.getName());
						passengerDto.setAge(entity.getAge());
						passengerDto.setGender(entity.getGender());
						passengerDto.setMeal(entity.getMeal());
						passengerDto.setSeatNo(entity.getSeatNo());
						return passengerDto;
					}).collect(Collectors.toList());
				response.setPassengersList(passengersList);
				return response;
				})
		);
	}

	@Override
	public Mono<String> cancelTicket(String pnr) {
		// TODO Auto-generated method stub
		return bookingRepository.findByPnr(pnr).
				switchIfEmpty(Mono.error(new ResourceNotFoundException("Cancellation Failed: PNR not found.")))
		        .flatMap(booking -> 
	            flightRepository.findById(booking.getFlightId())
	                .flatMap(flight -> {

	                    long hoursRemaining = Duration
	                            .between(LocalDateTime.now(), flight.getDepatureTime()).toHours();

	                    if (hoursRemaining < 24) {
	                        throw new BookingException("Cannot cancel ticket less than 24 hours before journey.");
	                    }

	                    flight.setAvaliSeats(flight.getAvaliSeats() + booking.getNoOfSeats());

	                    return flightRepository.save(flight)
	                        .then(bookingRepository.deleteByPnr(pnr))
	                        .thenReturn("Ticket with PNR " + pnr + " successfully cancelled.");
	                })
	        );
		
	}

	@Override
	public Flux<Bookingdto> getHistoryByEmail(String emailId) {
		// TODO Auto-generated method stub
		return bookingRepository.findAllByEmailId(emailId)
		        .switchIfEmpty(Mono.error(new ResourceNotFoundException("No booking history found.")))
		        .flatMap(booking ->
		            userRepository.findById(booking.getUserId())
		                .map(user -> {

		                    Bookingdto dto = new Bookingdto();
		                    dto.setEmailId(booking.getEmailId());
		                    dto.setNoOfSeats(booking.getNoOfSeats());
		                    dto.setName(user.getName());

		                    List<Passengers> list = booking.getPassengers().stream()
		                        .map(pe -> {
		                            Passengers p = new Passengers();
		                            p.setName(pe.getName());
		                            p.setAge(pe.getAge());
		                            p.setGender(pe.getGender());
		                            p.setMeal(pe.getMeal());
		                            p.setSeatNo(pe.getSeatNo());
		                            return p;
		                        }).collect(Collectors.toList());

		                    dto.setPassengers(list);

		                    return dto;
		                })
		        );
	}

}
