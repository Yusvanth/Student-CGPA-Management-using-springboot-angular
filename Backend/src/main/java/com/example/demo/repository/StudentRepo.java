package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

	void deleteStudentById(int i);
	Student findStudentById(int id);
}
