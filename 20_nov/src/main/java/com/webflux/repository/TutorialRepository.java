package com.webflux.repository;

import org.springframework.data.r2dbc.repository.config.R2dbcRepositoryConfigurationExtension;

import com.webflux.model.Tutorial;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface TutorialRepository extends R2dbcRepository<Tutorial, Integer>{

	Flux<Tutorial> findByPublished(boolean isPublished);

}
