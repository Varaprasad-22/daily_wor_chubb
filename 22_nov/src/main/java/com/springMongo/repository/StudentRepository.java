package com.springMongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springMongo.model.StudentModels;

public interface StudentRepository extends MongoRepository<StudentModels,Integer>{

}
