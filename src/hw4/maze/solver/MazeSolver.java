package hw4.maze.solver;

import hw4.maze.generator.Coordinate;
import hw4.player.Movement;

public class MazeSolver {
	private Movement[] directions = { // in counter-clockwise order
		Movement.RIGHT,
		Movement.UP,
		Movement.LEFT,
		Movement.DOWN,
	};
	private Coordinate coordinate;
	private int directionIndex;
	private Movement direction;

	public MazeSolver(int x, int y) {
		this.coordinate = new Coordinate(x, y);
		setDirection(0); // any direction is fine to start
	}

	private void setDirection(int directionIndex) {
		this.directionIndex = directionIndex;
		this.direction = this.directions[directionIndex];
	}

	/**
	 * since java doesn't have this built in :|
	 * @param a
	 * @param b
	 * @return
	 */
	private int modulo(int a, int b) {
		return (a % b + b) % b;
	}

	/**
	 * rotate the direction 90*dir degrees counter-clockwise
	 * @param dir
	 */
	private void rotate(int dir) {
		var directionIndex = this.modulo(this.directionIndex + dir, this.directions.length);
		setDirection(directionIndex);
	}

	public void solve(MazeProbe probe) {
		while (!probe.checkEscaped(this.coordinate.getX(), this.coordinate.getY())) {
			this.rotate(-1);
			while (true) {
				Coordinate next = this.coordinate.add(this.direction);
				if (probe.attemptMove(coordinate.getX(), coordinate.getY(), next.getX(), next.getY())) {
					this.coordinate = next;
					break;
				}
				this.rotate(1);
			}
		}
	}
}
