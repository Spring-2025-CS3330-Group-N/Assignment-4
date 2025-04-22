package hw4.game;

import java.util.ArrayList;

import hw4.maze.Cell;
import hw4.maze.CellComponents;
import hw4.maze.Grid;
import hw4.maze.Row;
import hw4.maze.generator.MazeGenerator;
import hw4.maze.generator.MazeSketcher;
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
	 * This method updates a character's position based on the given input variables. 
	 * @param movement The direction a player wants to move (ex. left, right, up, down)
	 * @param player The player to be moved
	 * @return True if the movement and player are valid, return False if otherwise.
	 */
	public boolean play(Movement movement, Player player) {
		// check for invalid player (testInvalidNullPlayer)
		if (player == null) {
			return false;
		}
		
		// check for invalid movement (testInvalidMovement)
		if (movement == null) {
			return false;
		}
		
		// get current player position
		var currentCell = player.getCurrentCell();

		// catch any null cell components
		var left = currentCell.getValidEdgeType(currentCell.getLeft());
		var right = currentCell.getValidEdgeType(currentCell.getRight());
		var up = currentCell.getValidEdgeType(currentCell.getUp());
		var down = currentCell.getValidEdgeType(currentCell.getDown());
		
		// if up or down, change row
		// if left or right, change cell
		
		// check left
		if (movement == Movement.LEFT) {
			// check for wall
			if (!(left == CellComponents.WALL)) {
				// update player position -- set current row/cell
				if (left == CellComponents.EXIT) {
					// end game after movement!
				}
				return true;
			}
			return false;
		}
		
		// check right
		if (movement == Movement.RIGHT) {
			// check for wall
			if (!(right == CellComponents.WALL)) {
				// update player position -- set current row/cell
				return true;
			}
			return false;
		}
	
		// check up
		if (movement == Movement.UP) {
			// check for wall
			if (!(up == CellComponents.WALL)) {
				// update player position -- set current row/cell
				return true;
			}
			return false;
		}
		
		// check down
		if (movement == Movement.DOWN) {
			// check for wall
			if (!(down == CellComponents.WALL)) {
				// update player position -- set current row/cell
				return true;
			}
			return false;
		}
		
		return false;
	}
	
	private Grid createEmptyGrid(int n) {
		var rows = new ArrayList<Row>();
		for (var i = 0; i < n; ++i) {
			var cells = new ArrayList<Cell>();
			for (var j = 0; j < n; ++j) {
				var cell = new Cell(
					CellComponents.WALL,
					CellComponents.WALL,
					CellComponents.WALL,
					CellComponents.WALL
				);
				cells.add(cell);
			}
			var row = new Row(cells);
			rows.add(row);
		}

		var grid = new Grid(rows);
		return grid;
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

		var grid = this.createEmptyGrid(n);
		
		var entranceCell = grid.getRows().get(0).getCells().get(0);
		entranceCell.setLeft(CellComponents.EXIT);
		
		var generator = new MazeGenerator(n, n);
		generator.generate(0, 0, new MazeSketcher() {
			@Override
			public void connect(int x1, int y1, int x2, int y2) {
				int dx = x2 - x1;
				int dy = y2 - y1;
				var startCell = grid.getRows().get(y1).getCells().get(x1);
				var endCell = grid.getRows().get(y2).getCells().get(x2);
				startCell.setSide(Movement.fromDelta(dx, dy), CellComponents.APERTURE);
				endCell.setSide(Movement.fromDelta(-dx, -dy), CellComponents.APERTURE);
			}
		});
		
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
