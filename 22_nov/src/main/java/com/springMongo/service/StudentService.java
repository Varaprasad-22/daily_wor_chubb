package com.springMongo.service;

import java.util.List;

import com.springMongo.model.StudentModels;

public interface StudentService {

	int addStudent(StudentModels student);

	List<StudentModels> fetchAll();

	StudentModels findById(int id);

	void updateStudent(StudentModels student);

	void deleteStudent(int id);

}
