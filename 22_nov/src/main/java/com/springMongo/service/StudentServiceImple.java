package com.springMongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springMongo.model.StudentModels;
import com.springMongo.repository.StudentRepository;

@Service
public class StudentServiceImple implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	@Override
	public int addStudent(StudentModels student) {
		// TODO Auto-generated method stub
		StudentModels addedStudent= studentRepo.save(student);
		return addedStudent.getStudentId();
	}
	@Override
	public List<StudentModels> fetchAll() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}
	@Override
	public StudentModels findById(int id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).orElse(null);
	}
	@Override
	public void updateStudent(StudentModels student) {
		// TODO Auto-generated method stub
		StudentModels data=studentRepo.findById(student.getStudentId()).orElse(null);
		if(data!=null) {
			data.setName(student.getName());
			data.setAddress(student.getAddress());
			studentRepo.save(data);
		}
	}
	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
	}

}
