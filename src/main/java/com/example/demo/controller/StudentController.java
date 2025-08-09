package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Integer id,@RequestBody Student stu) {
		return service.updateStudent(id,stu);
	}
	
	@PostMapping
	public Student create(@RequestBody Student stu) {
		return service.saveStudent(stu);
	}
}
