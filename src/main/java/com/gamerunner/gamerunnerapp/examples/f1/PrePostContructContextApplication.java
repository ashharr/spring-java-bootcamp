package com.gamerunner.gamerunnerapp.examples.f1;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	@SuppressWarnings("unused")
	private SomeDependency someDependency;
	
	public SomeClass( SomeDependency someDependency) {
		super();
		this.someDependency = someDependency;
	}
	
	@PostConstruct
	public void initialization() {
		System.out.println("Initialization !!!");
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("Release resources / Close Connections / Cleanup");
	}
	
}


@Component
class SomeDependency {
	
}



@Configuration
@ComponentScan
public class PrePostContructContextApplication {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(PrePostContructContextApplication.class)) {
			System.out.println(context.getBean(SomeClass.class));
		}

	}

}
