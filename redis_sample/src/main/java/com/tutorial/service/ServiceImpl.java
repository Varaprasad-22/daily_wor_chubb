package com.tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tutorial.model.Tutorial;
import com.tutorial.repository.TutoRepository;

@Service
public class ServiceImpl implements TutorialService {

	    @Autowired
	    private TutoRepository tutorialRepository;

	    private void simulateSlowService() {
	        try {
	            Thread.sleep(3000); 
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    @Cacheable(value = "tutorials")
	    public List<Tutorial> getAllTutorials() {
	        simulateSlowService();
	        return tutorialRepository.findAll();
	    }

	    @Cacheable(value = "tutorial", key = "#id")
	    public Optional<Tutorial> getTutorialById(String id) {
	        simulateSlowService();
	        return tutorialRepository.findById(id);
	    }

	    @Cacheable(value = "publishedTutorials", key = "#published")
	    public List<Tutorial> getPublishedTutorials(boolean published) {
	        simulateSlowService();
	        return tutorialRepository.findByPublished(published);
	    }

	    @Cacheable(value = "tutorialsByTitle", key = "#title")
	    public List<Tutorial> getTutorialsByTitle(String title) {
	        simulateSlowService();
	        return tutorialRepository.findByTitleContaining(title);
	    }

	    @CacheEvict(
	            value = { "tutorials", "tutorial", "publishedTutorials", "tutorialsByTitle" },
	            allEntries = true
	    )
	    public Tutorial createTutorial(Tutorial tutorial) {
	        return tutorialRepository.save(tutorial);
	    }

	    @CacheEvict(
	            value = { "tutorials", "tutorial", "publishedTutorials", "tutorialsByTitle" },
	            allEntries = true
	    )
	    public Optional<Tutorial> updateTutorial(String id, Tutorial tutorialDetails) {
	        return tutorialRepository.findById(id).map(existing -> {
	            existing.setTitle(tutorialDetails.getTitle());
	            existing.setDescription(tutorialDetails.getDescription());
	            existing.setPublished(tutorialDetails.isPublished());
	            return tutorialRepository.save(existing);
	        });
	    }

	    @CacheEvict(
	            value = { "tutorials", "tutorial", "publishedTutorials", "tutorialsByTitle" },
	            allEntries = true
	    )
	    public void deleteTutorial(String id) {
	        tutorialRepository.deleteById(id);
	    }

	    @CacheEvict(
	            value = { "tutorials", "tutorial", "publishedTutorials", "tutorialsByTitle" },
	            allEntries = true
	    )
	    public void deleteAllTutorials() {
	        tutorialRepository.deleteAll();
	    }
	}
