package hw4.maze.solver;

public interface MazeProbe {
	/**
	 * determine whether a player at (x, y) has escaped the maze
	 * @param x
	 * @param y
	 * @return
	 */
	boolean checkEscaped(int x, int y);

	/**
	 * attempt to move the player from (x1, y1) to (x2, y2) and return true/false depending on whether the move was successful
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	boolean attemptMove(int x1, int y1, int x2, int y2);
}
