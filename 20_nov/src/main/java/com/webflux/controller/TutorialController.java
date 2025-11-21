package com.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.model.Tutorial;
import com.webflux.repository.TutorialRepository;
import com.webflux.service.TutorialService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/tutorial")
public class TutorialController {

    private final TutorialRepository tutorialRepository;

	@Autowired
	private TutorialService tutorialService;

    TutorialController(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
		return tutorialService.createTutorial(tutorial);
	}
	
	@GetMapping()
	public Flux<Tutorial> findAll(){
		return tutorialService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Tutorial> findById(@PathVariable Integer id ){
		return tutorialService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Mono<Tutorial> updateById(@PathVariable Integer id,@RequestBody Tutorial tutorial){
		return tutorialService.update(id, tutorial);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Mono<Void> deleteById(@PathVariable Integer id){
		return tutorialService.deleteById(id);
	}
	@DeleteMapping()
	public Mono<Void> deleteAll(){
		return tutorialService.deleteAll();
	}
	@GetMapping("/published")
	public Flux<Tutorial> findByPublished(){
		return tutorialService.findByPublished(true);
	}
}
