package com.springbootcamp.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springbootcamp.springboot.learnjpaandhibernate.course.Course;
import com.springbootcamp.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.springbootcamp.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	private  CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(1,"Learn AWS", "Ashhar"));
		repository.save(new Course(2,"Zero to hero in Python", "Bonny"));
		repository.save(new Course(3,"Full Stack React", "Faraz"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Faraz"));
		System.out.println(repository.findByName("Zero to hero in Python"));
		
	}

}
