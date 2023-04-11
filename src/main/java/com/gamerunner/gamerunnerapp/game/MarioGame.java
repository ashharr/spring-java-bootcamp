package com.gamerunner.gamerunnerapp.game;

public class MarioGame implements GamingConsole{
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Crouch");
	}
	
	public void left() {
		System.out.println("Back");
	}
	public void right() {
		System.out.println("Accelerate");
	}
}
