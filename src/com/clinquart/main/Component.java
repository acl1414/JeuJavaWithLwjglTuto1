package com.clinquart.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Component {
	
	public boolean running = false;
	
	public static int scale = 3; //echelle
	public static int width =720 / scale ;
	public static int height =480 / scale;
	public static String title = "TITRE";
	
	DisplayMode mode = new DisplayMode(width * scale, height *scale);

	public Component() {
		try {
			Display.setDisplayMode(mode);
			Display.setResizable(true);
			Display.setFullscreen(false);
			Display.setTitle(title);
			Display.create();
		} 
		catch (LWJGLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void start() {
	running = true;
	loop();	
	}
	
	public void stop() {
		Display.destroy();
		System.exit(0);
	}
	
	public void exit() {
		running = false;
	}
	
	public void loop() {
	
		while (running) 
		{
			if (Display.isCloseRequested()) 
			{
				stop();
			}
			Display.update();
			System.out.println(running);
		}
		
		exit();
	}
	
	public static void main(String[] args) {
		Component main = new Component();
		main.start();
	}
}
