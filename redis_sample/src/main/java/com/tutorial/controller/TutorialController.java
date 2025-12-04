package com.tutorial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tutorial.model.Tutorial;
import com.tutorial.service.TutorialService;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @PostMapping
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        try {
            Tutorial created = tutorialService.createTutorial(
                    new Tutorial(
                            tutorial.getTitle(),
                            tutorial.getDescription(),
                            tutorial.isPublished()
                    )
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorials(
            @RequestParam(required = false) String title) {

        try {
            List<Tutorial> tutorials;

            if (title == null || title.isEmpty()) {
                tutorials = tutorialService.getAllTutorials();
            } else {
                tutorials = tutorialService.getTutorialsByTitle(title);
            }

            if (tutorials.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(tutorials);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") String id) {
        Optional<Tutorial> tutorial = tutorialService.getTutorialById(id);

        return tutorial
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(
            @PathVariable("id") String id,
            @RequestBody Tutorial tutorial) {

        Optional<Tutorial> updated = tutorialService.updateTutorial(id, tutorial);

        return updated
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutorial(@PathVariable("id") String id) {
        try {
            tutorialService.deleteTutorial(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTutorials() {
        try {
            tutorialService.deleteAllTutorials();
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> getPublishedTutorials() {
        try {
            List<Tutorial> tutorials = tutorialService.getPublishedTutorials(true);

            if (tutorials.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(tutorials);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
