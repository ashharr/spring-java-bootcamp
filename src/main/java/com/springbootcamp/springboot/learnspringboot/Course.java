package com.springbootcamp.springboot.learnspringboot;

public class Course {
	private long id;
	private String course;
	private String author;
	
	
	
	public Course(long id, String course, String author) {
		super();
		this.id = id;
		this.course = course;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public String getCourse() {
		return course;
	}
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + course + ", author=" + author + "]";
	}
	
	
}
