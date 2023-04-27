package com.springbootcamp.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> getAllCourses(){
		return Arrays.asList(
				new Course(1,"Learn DSA", "Ashhar Shaikh"),
				new Course(2,"Learn Machine Learning", "Anas"),
				new Course(2,"Learn Azure", "Faisal")
				);
	}
}
