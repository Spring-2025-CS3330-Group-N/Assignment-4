package hw4.maze.generator;

import hw4.player.Movement;

public class Coordinate {
	private int x;
	private int y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Coordinate add(Movement direction) {
		var coordinate = new Coordinate(
			this.x + direction.getX(),
			this.y + direction.getY()
		);
		return coordinate;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Coordinate)) {
			return false;
		}
		var other = (Coordinate) obj;
		return this.x == other.getX() && this.y == other.getY();
	}
}
