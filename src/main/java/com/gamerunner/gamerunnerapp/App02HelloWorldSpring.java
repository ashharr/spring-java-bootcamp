package com.gamerunner.gamerunnerapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
		// 1. Launch a Spring Context
		
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		// 2. Configure the things that we want spring to manage
		// HelloWorldConfiguration – @Configuration
		// name - @Bean
		
		// Retrieving the Beans managed by Spring
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));
		System.out.println(context.getBean("address2"));
		
		// Another way to get bean
		// It will throw an exception if multiple beans found
//		System.out.println(context.getBean(Address.class));
		
		
	}


}


