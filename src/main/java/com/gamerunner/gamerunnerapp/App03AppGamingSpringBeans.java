package com.gamerunner.gamerunnerapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gamerunner.gamerunnerapp.game.GameRunner;
import com.gamerunner.gamerunnerapp.game.GamingConsole;

public class App03AppGamingSpringBeans {

	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}

	}

}
