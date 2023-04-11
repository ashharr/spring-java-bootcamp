package com.gamerunner.gamerunnerapp;

import com.gamerunner.gamerunnerapp.game.GameRunner;
import com.gamerunner.gamerunnerapp.game.MarioGame;
import com.gamerunner.gamerunnerapp.game.PacmanGame;
import com.gamerunner.gamerunnerapp.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		var game = new SuperContraGame();
//		var game = new MarioGame();
		var game2 = new PacmanGame();  // 1: Object Creation
		
		// Game Runner is Tightly Coupled
		// If you want to run a different game
		// You will have to create another constructor
		// it involves more work when we change 
		// Coupling is important in software building
		
		// We make it loosely coupled by creating an
		// interface which defines the functions
		// The classes will implement this interface
		// Now GameRunner Class is loosely coupled
		// It doesn't require code change
		
		var gameRunner = new GameRunner(game2);
		// 2: Object Creation + Wiring of Dependencies
		// Game is a dependency of GameRunner
		
		gameRunner.run();
	}

}
