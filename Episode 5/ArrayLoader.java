package glfw_project.main;

import java.nio.FloatBuffer;
import java.util.*;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class ArrayLoader {
	private List<Integer> vaos = new ArrayList<Integer>();
	private List<Integer> vbos = new ArrayList<Integer>();
	public Model loadModel(float[] vertex) {
		//generate and bind vao
		int vaoID = GL30.glGenVertexArrays();
		vaos.add(vaoID);
		GL30.glBindVertexArray(vaoID);
		
		//generate and bind the vbo
		int vboID = GL15.glGenBuffers();
		vbos.add(vboID);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
		
		//store data in vbos
		FloatBuffer vboBuffer = BufferUtils.createFloatBuffer(vertex.length);
		vboBuffer.put(vertex).flip();
		GL15.glBufferData(GL15.GL_ARRAY_BUFFER, vboBuffer, GL15.GL_STATIC_DRAW);
		GL20.glVertexAttribPointer(0, 3, GL15.GL_FLOAT, false, 0,0);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
		
		//cleanup vao
		
		GL30.glBindVertexArray(0);
		return new Model(vaoID, vertex.length/3);
	}
	public void cleanUp() {
		for(int vao : vaos) {
			GL30.glDeleteVertexArrays(vao);
		}
		for(int vbo : vbos) {
			GL15.glDeleteBuffers(vbo);
		}
	}
}
