package com.tutorial.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.model.Tutorial;


@Repository
public interface TutoRepository extends MongoRepository<Tutorial, String> {

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}