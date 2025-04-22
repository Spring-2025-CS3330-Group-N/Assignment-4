package hw4.maze;

/** 
 * This is a class for cells in the maze. Each cell has 4 components: left, right, up and down.
 * Cell component options are either aperture, wall, or exit.
 * At least one cell component must be an aperture.
 */
public class Cell {
	private CellComponents left;
	private CellComponents right;
	private CellComponents up;
	private CellComponents down;

	/**
	 * Parameterized constructor for Cell():
	 * Assigns each Cell member its corresponding method argument's value.
	 * @param left
	 * @param right
	 * @param up
	 * @param down
	 */
	public Cell(CellComponents left, CellComponents right, CellComponents up, CellComponents down) {
		this.left = left;
		this.right = right;
		this.up = up;
		this.down = down;
	}

	/**
	 * getValidEdgeType():
	 * This method returns the value of a Cell's CellComponents member.
	 * @param edgeType The value of a CellComponent (ex. APERTURE, WALL, EXIT)
	 * @return If the given CellComponent argument's value is null, return WALL. Otherwise, return the given CellComponent value.
	 */
	public CellComponents getValidEdgeType(CellComponents edgeType) {
		return (edgeType == null)? CellComponents.WALL : edgeType;
	}

	/**
	 * getLeft():
	 * This method returns the CellComponent value for the left member of the Cell it's called upon.
	 * @return The left CellComponent of a Cell.
	 */
	public CellComponents getLeft() {
		return left;
	}

	/**
	 * setLeft():
	 * This method updates the CellComponent value for the left member of the Cell it's called upon.
	 * It checks the validity of the given argument during assignment.
	 * @return The updated left CellComponent of a Cell.
	 */
	public void setLeft(CellComponents left) {
		this.left = getValidEdgeType(left);
	}

	/**
	 * getRight():
	 * This method returns the CellComponent value for the right member of the Cell it's called upon.
	 * @return The right CellComponent of a Cell.
	 */
	public CellComponents getRight() {
		return right;
	}

	/**
	 * setRight():
	 * This method updates the CellComponent value for the right member of the Cell it's called upon.
	 * It checks the validity of the given argument during assignment.
	 * @return The updated right CellComponent of a Cell.
	 */
	public void setRight(CellComponents right) {
		this.right = getValidEdgeType(right);
	}

	/**
	 * getUp():
	 * This method returns the CellComponent value for the up member of the Cell it's called upon.
	 * @return The up CellComponent of a Cell.
	 */
	public CellComponents getUp() {
		return up;
	}

	/**
	 * setUp():
	 * This method updates the CellComponent value for the up member of the Cell it's called upon.
	 * It checks the validity of the given argument during assignment.
	 * @return The updated up CellComponent of a Cell.
	 */
	public void setUp(CellComponents up) {
		this.up = getValidEdgeType(up);
	}

	/**
	 * getDown():
	 * This method returns the CellComponent value for the down member of the Cell it's called upon.
	 * @return The down CellComponent of a Cell.
	 */
	public CellComponents getDown() {
		return down;
	}

	/**
	 * setDown():
	 * This method updates the CellComponent value for the down member of the Cell it's called upon.
	 * It checks the validity of the given argument during assignment.
	 * @return The updated down CellComponent of a Cell.
	 */
	public void setDown(CellComponents down) {
		this.down = getValidEdgeType(down);
	}

	/**
	 * toString():
	 * This method prints the values of each of the CellComponents member values for the Cell it's called upon.
	 */
	@Override
	public String toString() {
		return "Cell [left=" + left + ", right=" + right + ", up=" + up + ", down=" + down + "]";
	}
}
