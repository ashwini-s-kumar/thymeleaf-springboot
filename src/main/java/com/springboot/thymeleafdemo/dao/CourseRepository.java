package com.springboot.thymeleafdemo.dao;

import com.springboot.thymeleafdemo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	// that's it ... no need to write any code LOL!

    //add a method to sort by last name
    public List<Course> findAllByOrderByAuthorAsc();

}