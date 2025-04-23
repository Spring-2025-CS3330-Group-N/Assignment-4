package hw4.player;

/**
 * Enum options for player movement in four directions: left, right, up, or down.
 */
public enum Movement {
	LEFT(-1, 0),
	RIGHT(1, 0),
	UP(0, -1),
	DOWN(0, 1);
	
	private int x;
	private int y;

	private Movement(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * fromDelta():
	 * This method takes in the change in x and y values to determine the corresponding movement direction.
	 * @param dx Amount of change along x axis (horizontal movement)
	 * @param dy Amount of change along y axis (vertical movement)
	 * @return
	 */
	public static Movement fromDelta(int dx, int dy) {
		if (dx == LEFT.x && dy == LEFT.y) {
			return LEFT;
		}
		if (dx == RIGHT.x && dy == RIGHT.y) {
			return RIGHT;
		}
		if (dx == UP.x && dy == UP.y) {
			return UP;
		}
		if (dx == DOWN.x && dy == DOWN.y) {
			return DOWN;
		}
		throw new Error("Unrecognized Direction " + dx + ", " + dy + "!");
	}

	/**
	 * getX():
	 * This getter function retrieves the x value of the coordinate it's called upon.
	 * @return Coordinate's x-value
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * getY():
	 * This getter function retrieves the y value of the coordinate it's called upon.
	 * @return Coordinate's y value
	 */
	public int getY() {
		return this.y;
	}
}
