package hw4.maze.solver;

public interface MazeProbe {
	boolean checkEscaped(int x, int y);
	boolean attemptMove(int x1, int y1, int x2, int y2);
}
