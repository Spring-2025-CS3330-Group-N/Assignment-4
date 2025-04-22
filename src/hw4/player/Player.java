package hw4.player;

import hw4.maze.Cell;
import hw4.maze.Row;

/**
 * This class includes information on where the player is located in the maze.
 * It contains the player's current row as well as their current cell.
 */
public class Player {
	private Row currentRow;
	private Cell currentCell;

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
}
