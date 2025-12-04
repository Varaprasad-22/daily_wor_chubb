package com.tutorial.service;

import java.util.List;
import java.util.Optional;

import com.tutorial.model.Tutorial;

public interface TutorialService {

	List<Tutorial> getAllTutorials();
	 List<Tutorial> getPublishedTutorials(boolean published);
	 List<Tutorial> getTutorialsByTitle(String title);
	 Tutorial createTutorial(Tutorial tutorial);
	 Optional<Tutorial> updateTutorial(String id, Tutorial tutorialDetails);
	 void deleteTutorial(String id);
	 void deleteAllTutorials();
	 Optional<Tutorial> getTutorialById(String id);
}
