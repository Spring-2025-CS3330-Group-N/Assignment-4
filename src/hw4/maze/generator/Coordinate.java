package hw4.maze.generator;

import hw4.player.Movement;

/**
 * This class defines a pair of coordinates to be used for navigating the maze.
 */
public class Coordinate {
	private int x;
	private int y;

	/**
	 * Parameterized constructor for Coordinate():
	 * @param x X value
	 * @param y Y value
	 */
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * getX():
	 * This getter function retrieves the x value from the coordinate it's called upon.
	 * @return Coordinate's x value
	 */
	public int getX() {
		return x;
	}

	/**
	 * setX():
	 * This setter function assigns the provided argument to the coordinate's x value.
	 * @param x New x value for the coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * getY():
	 * This getter function retrieves the y value from the coordinate it's called upon.
	 * @return Coordinate's y value
	 */
	public int getY() {
		return y;
	}

	/**
	 * setY():
	 * This setter function assigns the provided argument to the coordinate's y value.
	 * @param y New y value for the coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * add():
	 * This method adds a new coordinate based on the coordinate it's called upon given a direction to move in.
	 * @param direction Direction to move in (ex. left, right, up, or down)
	 * @return A new coordinate with its position updated in the given direction
	 */
	public Coordinate add(Movement direction) {
		var coordinate = new Coordinate(
			this.x + direction.getX(),
			this.y + direction.getY()
		);
		return coordinate;
	}

	/**
	 * This implementation of equals() is used to compare the provided argument to the Coordinate object it's called upon.
	 * Returns true if the points in each Coordinate object are equal, otherwise returns false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coordinate)) {
			return false;
		}
		var other = (Coordinate) obj;
		return this.x == other.getX() && this.y == other.getY();
	}
}
