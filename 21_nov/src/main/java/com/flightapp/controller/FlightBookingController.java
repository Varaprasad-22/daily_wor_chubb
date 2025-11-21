package com.flightapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.dto.BookingGetResponse;
import com.flightapp.dto.Bookingdto;
import com.flightapp.dto.Flight;
import com.flightapp.dto.Search;
import com.flightapp.dto.SearchResult;
import com.flightapp.service.BookingService;
import com.flightapp.service.BookingServiceImpl;
import com.flightapp.service.FlightService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1.0/flight")
public class FlightBookingController {

	@Autowired
	private FlightService flightService;
	@Autowired
	private BookingService bookingService;

	@PostMapping("/airline/inventory/add")
	 public Mono<ResponseEntity<Integer>> addFlights(@RequestBody @Valid Flight flightEntry) {
        return flightService.addFlight(flightEntry)
                .map(id -> ResponseEntity.status(HttpStatus.CREATED).body(id));
    }

	@PostMapping("/search")
	public Mono<SearchResult> searchFlights(@Valid @RequestBody Search data) {
        return flightService.search(data);
    }

	@PostMapping("/booking")
	 public Mono<String> flightBooking(@Valid @RequestBody Bookingdto data) {
        return bookingService.bookFlight(data);
    }

	@GetMapping("/ticket/{pnr}")
	public Mono<ResponseEntity<BookingGetResponse>> bookingDetails(@PathVariable String pnr) {
        return bookingService.getBookingDetails(pnr)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }

	@GetMapping("/booking/history/{emailId}")
	public Flux<Bookingdto> getHistoryByEmail(@PathVariable String emailId) {
        return bookingService.getHistoryByEmail(emailId);
    }

	@DeleteMapping("/booking/cancel/{pnr}")
	public Mono<String> cancelBooking(@PathVariable String pnr) {
        return bookingService.cancelTicket(pnr);
    }
}
