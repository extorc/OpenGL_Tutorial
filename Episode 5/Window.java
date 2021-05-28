package glfw_project.main;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {
	int w , h;
	String t;
	long window = 0;
	public Window(int w, int h , String t) {
		this.w = w;
		this.h = h;
		this.t = t;
	}
	public void createWindow() {
		if(!glfwInit()) {
			System.err.println("Window is not initialised");
		}
		window = glfwCreateWindow(w, h, t, 0,0);
		if(window == 0) {
			glfwTerminate();
			System.err.println("Window not created , exiting process");
		}
		
		//GlfwVidmode = stores the information about the window
		
		GLFWVidMode vidMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, vidMode.width()/2-w/2, vidMode.height()/2-h/2);
		
		glfwMakeContextCurrent(window);
		GL.createCapabilities();
		//clear color (rgba)
		GL11.glClearColor(1, 0, 0, 1);
		
		glfwShowWindow(window);
	}
	public void update() {
		glfwPollEvents();
	}
	public void render() {
		//clear (clear the previous frame)
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		glfwSwapBuffers(window);
	}
	public Boolean shouldCLose() {
		return glfwWindowShouldClose(window);
	}
}
