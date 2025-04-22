package hw4.player;

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

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
