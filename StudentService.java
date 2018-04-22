package com.swingdemo.services;

import java.util.List;

import com.swingdemo.models.Student;

public interface StudentService {

	public boolean addStudent(Student s);
	public List<Student> getAllStudent();
	public boolean deleteStudent(int id);
	public boolean updateStudent(Student s);
	public Student getById(int id);
	
	
}
