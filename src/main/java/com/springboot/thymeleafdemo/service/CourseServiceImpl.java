package com.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.springboot.thymeleafdemo.dao.CourseRepository;
import com.springboot.thymeleafdemo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository theCourseRepository) {
		courseRepository = theCourseRepository;
	}
	
	@Override
	public List<Course> findAll() {
		try {
			TimeUnit.SECONDS.sleep(2);
		}catch (Exception e){
			System.out.println(" Exception in findALL() : "+e);
		}
		return courseRepository.findAllByOrderByAuthorAsc();
	}

	@Override
	public Course findById(int theId) {
		Optional<Course> result = courseRepository.findById(theId);
		
		Course course = null;
		
		if (result.isPresent()) {
			course = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find course id - " + theId);
		}
		
		return course;
	}

	@Override
	public void save(Course course) {
		courseRepository.save(course);
	}

	@Override
	public void deleteById(int theId) {
		courseRepository.deleteById(theId);
	}

}






