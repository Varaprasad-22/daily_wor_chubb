package com.flightapp.repository;

import java.util.Optional;

import javax.swing.JPanel;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.Airline;

import reactor.core.publisher.Mono;

@Repository
public interface AirlineRepository extends R2dbcRepository<Airline, Integer>{

	Mono<Airline> findByAirlineName(String airlineName);

	Mono<Airline> findByAirlineId(int airlineId);

}
