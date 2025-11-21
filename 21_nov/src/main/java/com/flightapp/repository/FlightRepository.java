package com.flightapp.repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.model.FlightEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface FlightRepository extends R2dbcRepository<FlightEntity, Integer> {



	Flux<FlightEntity> findByFromLocationAndToLocationAndDepatureTimeBetween(String fromPlace, String toPlace,
			LocalDateTime startOfDay, LocalDateTime endOfDay);

	Mono<FlightEntity> findByFlightNumber(String flightNumber);
}
