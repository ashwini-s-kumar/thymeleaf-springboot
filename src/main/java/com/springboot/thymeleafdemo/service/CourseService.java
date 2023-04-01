package com.springboot.thymeleafdemo.service;

import java.util.List;

import com.springboot.thymeleafdemo.entity.Course;

public interface CourseService {

	List<Course> findAll();
	
	Course findById(int theId);
	
	void save(Course course);
	
	void deleteById(int theId);
	
}
