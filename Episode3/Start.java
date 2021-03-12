package glfwWindowTutorial.main;

public class Start implements Runnable{
	Thread gameThread;
	Boolean running = true;
	Window window;
	public static void main(String[] args) {
		new Start().start();
	}
	public void start() {
		gameThread = new Thread(this, "Game");
		gameThread.start();
	}
	public void run() {
		init();
		while(running == true) {
			update();
			render();
			if(window.shouldclose()) {
				running = false;
			}
		}
	}
	public void init() {
		window = new Window(600,600,"Our Game");
		window.createWindow();
	}
	public void update() {
		window.update();
	}
	public void render() {
		window.render();
	}
}
