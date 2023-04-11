package com.gamerunner.gamerunnerapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Records :
//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor, getter, setter
//equals, hashcode and toString are automatically created. 
//Released in JDK 16.

record Person (String name, int age, Address address) {};
record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ashhar";
	}
	
	@Bean
	public int age() {
		return 24;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Faisal", 26, new Address("Central Park","NY"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		var person = new Person(name(),age(), address());
		return person;
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address address3) { // name, age, address2
		var person = new Person(name,age, address3);
		return person;
	}
	
	@Bean(name = "address2")
	public Address address() {
		var address = new Address("Baker Street", "London");
		return address;
	}
	
	@Bean(name = "address3")
	public Address address3() {
		var address = new Address("Sahara Star", "Mumbai");
		return address;
	}
	
	public HelloWorldConfiguration() {
		// TODO Auto-generated constructor stub
	}
}
