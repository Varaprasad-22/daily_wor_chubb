package com.springMongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.springMongo.model.StudentModels;
import com.springMongo.repository.StudentRepository;
import com.springMongo.service.StudentService;

@RestController
@RequestMapping("/api")
public class SpringController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/addStudent")
	public int addStudents(@RequestBody StudentModels student) {
		return studentService.addStudent(student);
	}
	
	@GetMapping("/fetchStudent")
	public List<StudentModels> fetchAllStudents(){
		return studentService.fetchAll();
	}
	
	@GetMapping("/getById/{id}")
	public StudentModels getStudentById(@PathVariable int id) {
		return studentService.findById(id);
	}
	@PutMapping("/updateStudent")
	public void updateStudent(@RequestBody StudentModels student) {
		studentService.updateStudent(student);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
}
