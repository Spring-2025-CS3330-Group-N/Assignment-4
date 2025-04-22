package hw4.maze;

import java.util.ArrayList;

/**
 * This class is used to group rows.
 * It consists of an ArrayList of Rows.
 */
public class Grid {
	private ArrayList<Row> rows;

	/**
	 * Parameterized constructor for Grid():
	 * Creates a grid using the provided list of rows.
	 * @param rows List of rows
	 */
	public Grid(ArrayList<Row> rows) {
		this.setRows(rows);
	}

	/**
	 * This getter function returns a list of rows in the grid.
	 * @return A list of rows
	 */
	public ArrayList<Row> getRows() {
		return rows;
	}

	/**
	 * This setter function assigns the grid a new list of rows.
	 * @param rows A list of rows
	 */
	public void setRows(ArrayList<Row> rows) {
		this.rows = rows;
	}

	/**
	 * toString():
	 * This method prints all the rows in a given grid.
	 */
	@Override
	public String toString() {
		return "Grid [rows=" + rows + "]";
	}
}
