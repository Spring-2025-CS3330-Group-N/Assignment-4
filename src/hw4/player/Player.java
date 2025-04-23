package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;
import hw4.maze.generator.*;

/**
 * This class includes information on where the player is located in the maze.
 * It contains the player's current row and cell, as well as their current position in the maze.
 */
public class Player {
	private Row currentRow;
	private Cell currentCell;
	private Coordinate position = null;

	/**
	 * Parameterized constructor for Player():
	 * Creates a player at a given location in the maze based on the provided arguments.
	 * @param currentRow The desired row position of the player
	 * @param currentCell The desired cell position of the player
	 */
	public Player(Row currentRow, Cell currentCell) {
		this.currentRow = currentRow;
		this.currentCell = currentCell;
	}

	/**
	 * This getter method returns the current row position of the player.
	 * @return the player's row position
	 */
	public Row getCurrentRow() {
		return currentRow;
	}

	/**
	 * This setter method assigns the player's current row to the provided method argument.
	 * @param currentRow Desired row position for the player
	 */
	public void setCurrentRow(Row currentRow) {
		this.currentRow = currentRow;
	}

	/**
	 * This getter method returns the current cell position of the player.
	 * @return The player's cell position
	 */
	public Cell getCurrentCell() {
		return currentCell;
	}

	/**
	 * This setter method assigns the player's current cell to the provided method argument.
	 * @param currentCell Desired cell position for the player
	 */
	public void setCurrentCell(Cell currentCell) {
		this.currentCell = currentCell;
	}

	/**
	 * toString():
	 * This method prints the player's location in the maze using their current cell and row positions.
	 */
	@Override
	public String toString() {
		return "Player [currentCell=" + currentCell + ", currentRow=" + currentRow + "]";
	}
	
	/**
	 * This getter function retrieves the coordinates of a given player.
	 * @return Current position of player
	 */
	public Coordinate getPlayerPosition() {
		if (this.position == null) {
			// set position to bottom right of grid
			var n = this.currentRow.getRowLength();
			this.setPlayerPosition(n, n);
		}
		return this.position;
	}
	/**
	 * This setter method assigns the provided argument values to the corresponding coordinate points.
	 * @param x Desired x value of coordinate
	 * @param y Desired y value of coordinate
	 */
	public void setPlayerPosition(int x, int y) {
		// if null, set position to bottom right of grid
		if (this.position == null) {
			var n = this.currentRow.getRowLength();
			Coordinate origin = new Coordinate(n, n); 
			this.position = origin;
		}
		this.position.setX(x);
		this.position.setY(y);
	}
}
