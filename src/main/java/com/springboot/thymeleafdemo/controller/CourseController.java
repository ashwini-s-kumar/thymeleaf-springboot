package com.springboot.thymeleafdemo.controller;

import com.springboot.thymeleafdemo.entity.Course;
import com.springboot.thymeleafdemo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public String listCourses(Model theModel) {

		// add to the spring model
		theModel.addAttribute("courses", courseService.findAll() );
		return "courses/list-course";
	}

	@GetMapping("/courses/{courseId}")
	public String coursesById(@PathVariable("courseId") int id, Model theModel) {

		Course course = courseService.findById(id);
		if (course == null) {
			return "redirect:/api/error";
		}
		// add to the spring model
		theModel.addAttribute("course", course);
		return "courses/course";
	}

	@GetMapping("/showFormForAdd")
	private String showFormAdd(Model theModel){
		Course course = new Course();
		theModel.addAttribute("course",course);
		return "courses/course-form";
	}

	@GetMapping("/showFormForUpdate")
	private String showFormUpdate(@RequestParam("courseId")int id,  Model theModel){
		Course emp = courseService.findById(id);
		theModel.addAttribute("course",emp);
		return "courses/course-form";
	}

	@PostMapping("/save")
	private String saveCourse(@ModelAttribute("course") Course employee){
		courseService.save(employee);
		return "redirect:/api/courses";
	}

	@GetMapping("/delete")
	private String deleteCourse(@RequestParam("courseId")int id){
		courseService.deleteById(id);
		return "redirect:/api/courses";
	}

	@GetMapping("/error")
	private String error(){
		return "courses/error-page";
	}
}









