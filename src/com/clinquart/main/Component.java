package com.clinquart.main;

import org.lwjgl.LWJGLException;

import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;
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
			
			initGl();
		} 
		catch (LWJGLException e) {
		
			e.printStackTrace();
		}
	}
	
	private void initGl() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0,width, height, 0);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
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
			render();
			System.out.println(running);
		}
		
		exit();
	}
	
	public void render() {
		// dessin carre
		glRectf(64, 64, 32, 32);
		
		// dessin caree methode 2
		int x=16;
		int y=16;
		int size=16;
		glBegin(GL_QUADS);
		
		glColor3f(0, 10, 156); //color
		glVertex2f(x,y);
		
		glColor3f(150, 150, 156); //color
		glVertex2f(x+size,y);
		
		glVertex2f(x+size,y+size);
		glVertex2f(x,y+size);
		glEnd();
	}
	
	public static void main(String[] args) {
		Component main = new Component();
		main.start();
	}
}
