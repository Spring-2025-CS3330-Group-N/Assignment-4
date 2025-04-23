package hw4.maze.solver;

public interface MazeProbe {
	boolean checkEscaped(int x, int y);
	boolean attemptMove(int x, int y);
}
