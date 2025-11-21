package com.webflux.service;

import com.webflux.model.Tutorial;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TutorialService {

	Mono<Tutorial> createTutorial(Tutorial tutorial);

	Flux<Tutorial> findAll();

	Mono<Tutorial> findById(Integer id);

	Mono<Tutorial> update(Integer id, Tutorial tutorial);

	Mono<Void> deleteById(Integer id);

	Mono<Void> deleteAll();

	Flux<Tutorial> findByPublished(boolean isPublished);
}
