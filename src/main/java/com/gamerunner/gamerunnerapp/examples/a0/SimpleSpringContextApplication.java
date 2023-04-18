package com.gamerunner.gamerunnerapp.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SimpleSpringContextApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(SimpleSpringContextApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}

	}

}
