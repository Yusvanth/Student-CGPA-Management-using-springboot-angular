package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepo studentRepo ;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student addStudent(Student s) {
		return studentRepo.save(s);
	}


	@Override
	public void deleteStudent(int id) {
		studentRepo.deleteStudentById(id);
		
	}

	@Override
	public Student getStudentById(int i) {
		return studentRepo.findStudentById(i);
	}

	@Override
	public Student updateStudent(Student s) {
		return studentRepo.save(s);
	}
	
	

}
