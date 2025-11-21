package com.flightapp.service;

import java.util.List;

import com.flightapp.dto.Flight;
import com.flightapp.dto.Search;
import com.flightapp.dto.SearchResult;

import reactor.core.publisher.Mono;

public interface FlightService {
	Mono<Integer> addFlight(Flight flight);
	Mono<SearchResult> search(Search data);
}
