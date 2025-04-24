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

	/**
	 * constructs a maze solver starting at (x, y)
	 * @param x
	 * @param y
	 */
	public MazeSolver(int x, int y) {
		this.coordinate = new Coordinate(x, y);
		setDirection(0); // any direction is fine to start
	}

	/**
	 * private helper function for setting the direction to keep the rotation system in sync
	 * @param directionIndex
	 */
	private void setDirection(int directionIndex) {
		this.directionIndex = directionIndex;
		this.direction = this.directions[directionIndex];
	}

	/**
	 * actual modulo since java's % doesn't work for negative numbers
	 * @param a
	 * @param b
	 * @return
	 */
	private int modulo(int a, int b) {
		return (a % b + b) % b; // a % b gets us within (-b, b), + b within the positive range, and % b for the actual result
	}

	/**
	 * rotate the direction 90*dir degrees counter-clockwise
	 * @param dir (ex: +1 means +90 deg, -1 mean -90 deg)
	 */
	private void rotate(int dir) {
		var directionIndex = this.modulo(this.directionIndex + dir, this.directions.length);
		setDirection(directionIndex);
	}

	/**
	 * solve the maze using a "follow the right wall" strategy
	 * @param probe
	 */
	public void solve(MazeProbe probe) {
		while (!probe.checkEscaped(this.coordinate.getX(), this.coordinate.getY())) {
			this.rotate(-1); // this more or less works to find the right wall
			while (true) {
				Coordinate next = this.coordinate.add(this.direction);
				if (probe.attemptMove(coordinate.getX(), coordinate.getY(), next.getX(), next.getY())) {
					this.coordinate = next;
					break;
				}
				this.rotate(1); // while this turns until you can move forward after finding the wall
			}
		}
	}
}
