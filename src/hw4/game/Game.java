package hw4.game;

import hw4.maze.Grid;
import hw4.player.Movement;
import hw4.player.Player;

public class Game {
	private Grid grid;

	public Game(Grid grid) {
		this.grid = grid;
	}

	public Game(int n) {
		this.grid = createRandomGrid(n);
	}

	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public boolean play(Movement right, Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	public Grid createRandomGrid(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
}
