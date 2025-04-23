package hw4.maze;

import java.util.ArrayList;

/**
 * This class is used to groups cells.
 * It consists of an ArrayList of Cells.
 */
public class Row {
	private ArrayList<Cell> cells;

	/**
	 * Parameterized constructor for Row():
	 * Creates a row using the provided list of cells.
	 * @param cells List of cells to be added
	 */
	public Row(ArrayList<Cell> cells) {
		this.setCells(cells);
	}

	/**
	 * This getter function returns a list of cells in the row.
	 * @return All the cells in the given row.
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	/**
	 * This setter function assigns the row a new list of cells.
	 * @param cells List of cells
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

	/**
	 * toString():
	 * This method prints all the cells in a given row.
	 */
	@Override
	public String toString() {
		return "Row [cells=" + cells + "]";
	}
	
	/**
	 * getRowLength():
	 * This is a helper method that retrieves the size of the row it's called upon.
	 * @return The number of cells in a row
	 */
	public int getRowLength() {
		return this.cells.size();
	}
}
