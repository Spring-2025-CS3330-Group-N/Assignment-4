package hw4.maze.generator;

public interface MazeSketcher {
	/**
	 * connect two points in a maze (create "apertures" between them)
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 */
	void connect(int x1, int y1, int x2, int y2);
}
