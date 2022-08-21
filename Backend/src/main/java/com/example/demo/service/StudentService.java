package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {

	
	public List<Student> getAllStudents();
	
	public Student addStudent(Student s);
	
	public Student updateStudent(Student s);
	
	public void deleteStudent(int id);
	
	public Student getStudentById(int i);
}
