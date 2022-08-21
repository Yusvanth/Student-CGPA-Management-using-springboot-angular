package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	StudentService service ;
	
	@GetMapping("/list")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> arr=service.getAllStudents();
		return new ResponseEntity<List<Student>>(arr,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student ){
		System.out.println(student);
		Student student2=service.addStudent(student);
		return new ResponseEntity<Student>(student2, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id")int id, @RequestBody Student student ){
		Student student2 =service.getStudentById(id);
		student2.setCgpa(student.getCgpa());
		student2.setName(student.getName());
		student2.setRollNo(student.getRollNo());
		Student student3 = service.updateStudent(student2);
		return new ResponseEntity<Student>(student3,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id){
		service.deleteStudent(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("/get/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id")int id){
		Student student = service.getStudentById(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
