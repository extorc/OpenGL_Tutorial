package glfwWindowTutorial.main;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import static org.lwjgl.opengl.GL11.*;

public class Window {
	int width, height;
	String title;
	long window;
	public Window(int width, int height, String title) {
		this.width = width;
		this.height= height;
		this.title = title;
	}
	public void createWindow() {
		if (!glfwInit()) {
			System.err.println("Error 001");
		}
		//create window
		window = glfwCreateWindow(width, height, title,0,0);
		
		if(window == 0) {
			System.err.println("Error002");
			glfwTerminate();
			System.exit(0);
		}
		//set position of window
		GLFWVidMode vid = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, vid.width()/2-width/2,vid.height()/2-height/2);
		//context
		glfwMakeContextCurrent(window);
		//capability
		GL.createCapabilities();
		//set color
		glClearColor(1, 0, 0, 1);
		glfwShowWindow(window);
		
	}
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		glfwSwapBuffers(window);
	}
	public void update() {	
		glfwPollEvents();
	}
	public Boolean shouldclose() {
		return glfwWindowShouldClose(window);
	}
}
