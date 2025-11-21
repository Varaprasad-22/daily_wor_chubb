package com.flightapp.service;

import java.util.List;

import com.flightapp.dto.BookingGetResponse;
import com.flightapp.dto.Bookingdto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookingService {
	Mono<String> bookFlight(Bookingdto data);

	Mono<BookingGetResponse> getBookingDetails(String pnr);

	Mono<String> cancelTicket(String pnr);

	Flux<Bookingdto> getHistoryByEmail(String emailId);
}
