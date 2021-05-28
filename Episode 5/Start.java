package glfw_project.main;

public class Start implements Runnable{
	Thread game;
	Boolean running = true;
	Window win;
	Model tri;
	ArrayLoader arrayLoader;
	Renderer renderer;
	float[] vertex = new float[] {
			0 -0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f,
			0f, 0.5f, -0.5f, 0f, 0.5f, 0.5f, 0f, -0.5f, 0.5f, 0f
	};
	public static void main(String[] args) {
		new Start().start();
	}
	public void start() {
		game = new Thread(this, "Game");
		game.start();
	}
	public void run() {
		init();
		while(running == true) {
			update();
			render();
			if(win.shouldCLose()) {
				running = false;
			}
		}
		arrayLoader.cleanUp();
	}
	public void init() {
		win = new Window(600,600,"Our Game");
		win.createWindow();
		arrayLoader = new ArrayLoader();
		renderer = new Renderer();
		tri = arrayLoader.loadModel(vertex);
	}
	public void update() {
		win.update();
	}
	public void render() {
		renderer.render(tri);
		win.render();
	}
}
