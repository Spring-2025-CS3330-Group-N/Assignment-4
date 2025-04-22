package hw4.game;

import java.util.ArrayList;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

/**
 * This class is used to provide game functionality for the maze.
 * It contains a grid of rows and cells.
 */
public class Game {
	private Grid grid;

	/**
	 * Parameterized constructor for Grid():
	 * Creates a game using the provided argument.
	 * @param grid Grid to be used for the maze game
	 */
	public Game(Grid grid) {
		this.grid = grid;
	}

	/**
	 * This alternative constructor creates a random grid.
	 * @param n Size of the grid
	 */
	public Game(int n) {
		this.grid = createRandomGrid(n);
	}

	/**
	 * getGrid():
	 * This getter method retrieves a grid from the Game object it's called upon.
	 * @return The grid assigned to the game
	 */
	public Grid getGrid() {
		return grid;
	}

	/**
	 * This setter method assigns a grid to the Game object it's called upon.
	 * @param grid Grid to be used for the game
	 */
	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	/**
	 * play():
	 * This method updates a character's position based on the given input variables
	 * @param right The direction a player will move (ex. left, right, up, down)
	 * @param player The player to be moved
	 * @return True if the movement and player are valid, return False if otherwise.
	 */
	public boolean play(Movement right, Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * createRandomGrid():
	 * This method creates a random grid based on the size argument passed in.
	 * It checks to ensure the size argument is greater than or equal to three as well as less than or equal to 8.
	 * @param n Desired dimension (size) for the grid
	 * @return A new random grid of size n upon success, otherwise return null.
	 */
	public Grid createRandomGrid(int n) {
		if (2 >= n || n >= 8) {
			return null;
		}

		var rows = new ArrayList<Row>();
		var grid = new Grid(rows);
		return grid;
	}

	/**
	 * toString():
	 * This method prints the grid details used for the given game.
	 */
	@Override
	public String toString() {
		return "Game [grid=" + grid + "]";
	}
}
