package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<Student> getAllStudent(){
		return repo.findAll();
	}
	
	public Student  getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public Student saveStudent(Student stu) {
		return repo.save(stu);
	}
	
	public Student updateStudent(int id,Student updatedStu) {
		Optional<Student>opt=repo.findById(id);
		if(opt.isPresent()) {
			Student stu=opt.get();
			stu.setName(updatedStu.getName());
			stu.setEmail(updatedStu.getEmail());
			stu.setDept(updatedStu.getDept());
			return repo.save(updatedStu);
		}
		return null;
	}
	public void deleteById(int id) {
		repo.deleteById(id);
	}
	
	public void deleteAllStudent() {
		repo.deleteAll();
	}
}
