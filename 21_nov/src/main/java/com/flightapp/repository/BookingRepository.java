package com.flightapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.dto.BookingGetResponse;
import com.flightapp.model.BookingEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookingRepository extends R2dbcRepository<BookingEntity, Integer>{


	Flux<BookingEntity> findAllByEmailId(String emailId);

	Mono<BookingEntity> findByPnr(String pnr);

	Mono<Void> deleteByPnr(String pnr);

}
