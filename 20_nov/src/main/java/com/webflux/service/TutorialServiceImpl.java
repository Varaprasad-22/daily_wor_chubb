package com.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webflux.model.Tutorial;
import com.webflux.repository.TutorialRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TutorialServiceImpl implements TutorialService{
	
	@Autowired
	private TutorialRepository tutorialRepository;
	@Override
	public Mono<Tutorial> createTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		return tutorialRepository.save(tutorial);
	}

	@Override
	public Flux<Tutorial> findAll() {
		// TODO Auto-generated method stub
		return tutorialRepository.findAll();
	}

	@Override
	public Mono<Tutorial> findById(Integer id) {
		// TODO Auto-generated method stub
		return tutorialRepository.findById(id);
	}

	@Override
	public Mono<Tutorial> update(Integer id, Tutorial tutorial) {
		// TODO Auto-generated method stub
		return tutorialRepository.findById(id)
	            .flatMap(existingTutorial -> {
	                existingTutorial.setTitle(tutorial.getTitle());
	                existingTutorial.setDescription(tutorial.getDescription());
	                existingTutorial.setPublished(tutorial.getPublished());
	                return tutorialRepository.save(existingTutorial);
	            });
	}

	@Override
	public Mono<Void> deleteById(Integer id) {
		// TODO Auto-generated method stub
		return tutorialRepository.deleteById(id);
	}

	@Override
	public Mono<Void> deleteAll() {
		// TODO Auto-generated method stub
		return tutorialRepository.deleteAll();
	}

	@Override
	public Flux<Tutorial> findByPublished(boolean isPublished) {
		// TODO Auto-generated method stub
		return tutorialRepository.findByPublished(isPublished);
	}

}
