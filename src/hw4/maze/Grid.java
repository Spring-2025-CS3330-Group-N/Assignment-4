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

	public void worsePrint(int playerX, int playerY) {
		for (var i = 0; i < this.rows.size(); ++i) {
			var row = this.rows.get(i);
			var cells = row.getCells();

			for (var j = 0; j < cells.size(); ++j) {
				var cell = cells.get(j);
				String tile;
				if (i == playerY && j == playerX) {
					tile = "A";
				} else if (
					cell.getLeft() == CellComponents.EXIT
					|| cell.getRight() == CellComponents.EXIT
					|| cell.getUp() == CellComponents.EXIT
					|| cell.getDown() == CellComponents.EXIT
				) {
					tile = "E";
				} else {
					tile = "S";
				}
				System.out.print(tile + " ");
			}
			System.out.println();
		}
	}

	public void betterPrint(int playerX, int playerY) {
		for (var i = 0; i < this.rows.size(); ++i) {
			var row = this.rows.get(i);
			var cells = row.getCells();
			for (var cell : cells) {
				System.out.print((cell.getUp() == CellComponents.WALL)? "•-" : "• ");
			}
			System.out.println("•");
			for (var j = 0; j < cells.size(); ++j) {
				var cell = cells.get(j);
				var filler = (i == playerY && j == playerX) ? "@" : " ";
				var left = (cell.getLeft() == CellComponents.WALL)? '|' : ' ';
				System.out.print(left + filler);
			}
			System.out.println("|");
		}
		System.out.println("•-".repeat(rows.size()) + "•");
	}
}
