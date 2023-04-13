package com.gamerunner.gamerunnerapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gamerunner.gamerunnerapp.game.GameRunner;
import com.gamerunner.gamerunnerapp.game.GamingConsole;
import com.gamerunner.gamerunnerapp.game.PacmanGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
}
