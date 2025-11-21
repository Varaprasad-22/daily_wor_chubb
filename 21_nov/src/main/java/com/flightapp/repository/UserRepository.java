package com.flightapp.repository;

import java.util.Optional;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.flightapp.model.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends R2dbcRepository<User, Integer> {

	Mono<User> findByEmail(String email);

}
