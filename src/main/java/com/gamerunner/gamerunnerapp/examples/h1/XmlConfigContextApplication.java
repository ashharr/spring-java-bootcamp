package com.gamerunner.gamerunnerapp.examples.h1;

import java.util.Arrays;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gamerunner.gamerunnerapp.game.GameRunner;

@Configuration
@ComponentScan
public class XmlConfigContextApplication {

	public static void main(String[] args) {

		try (var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();

		}
	}

}
