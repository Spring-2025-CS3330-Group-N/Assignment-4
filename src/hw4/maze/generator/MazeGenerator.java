package hw4.maze.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import hw4.player.Movement;

public class MazeGenerator {
	private int width;
	private int height;
	private boolean[][] visited;
	private ArrayList<Coordinate> backtrack;

	/**
	 * create an instance of a width x height maze generator
	 * @param width
	 * @param height
	 */
	public MazeGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		visited = new boolean[height][width];
		backtrack = new ArrayList<Coordinate>();
	}

	/**
	 * pick a random item from a list
	 * @param <T>
	 * @param list
	 * @return
	 */
	private <T> T pick(List<T> list) {
		var random = new Random();
		var index = random.nextInt(list.size());
		var item = list.get(index);
		return item;
	}

	/**
	 * check if a coordinate is in the bounds of the maze
	 * @param coordinate
	 * @return
	 */
	private boolean inBounds(Coordinate coordinate) {
		var xInBounds = 0 <= coordinate.getX() && coordinate.getX() < this.width;
		var yInBounds = 0 <= coordinate.getY() && coordinate.getY() < this.height;
		var inBounds = xInBounds && yInBounds;
		return inBounds;
	}

	/**
	 * check if a coordinate has already been visited in the search
	 * @param coordinate
	 * @return
	 */
	private boolean isVisited(Coordinate coordinate) {
		var isVisited = this.visited[coordinate.getY()][coordinate.getX()];
		return isVisited;
	}

	/**
	 * get a list of all the coordinates neighboring a particular coordinate
	 * @param of
	 * @return
	 */
	private List<Coordinate> getNeighbors(Coordinate of) {
		var neighbors = Arrays.asList(
			of.add(Movement.RIGHT),
			of.add(Movement.UP),
			of.add(Movement.LEFT),
			of.add(Movement.DOWN)
		);
		return neighbors;
	}

	/**
	 * get a list of all the coordinates neighboring a particular coordinate that can (still) be visited
	 * @param of
	 * @return
	 */
	private List<Coordinate> getVisitableNeighbors(Coordinate of) {
		var neighbors = this.getNeighbors(of);
		var visitableNeighbors = neighbors.stream().filter(
			coordinate -> this.inBounds(coordinate) && !this.isVisited(coordinate)
		).collect(Collectors.toList());
		return visitableNeighbors;
	}

	/**
	 * mark a location as visited and add it to the backtracking stack
	 * @param location
	 */
	private void visit(Coordinate location) {
		this.visited[location.getY()][location.getX()] = true;
		this.backtrack.add(location);
	}

	/**
	 * generate a random maze starting at (x, y) using a ("recursive") backtracking algorithm
	 * @param x the starting x position
	 * @param y the starting y position
	 * @param sketcher a tool for connecting cells in the maze
	 */
	public void generate(int x, int y, MazeSketcher sketcher) {
		this.visit(new Coordinate(x, y));

		while (this.backtrack.size() > 0) {
			var current = this.backtrack.getLast();
			var neighbors = this.getVisitableNeighbors(current);
			if (neighbors.size() == 0) {
				this.backtrack.removeLast();
				continue;
			}
			var next = this.pick(neighbors);
			sketcher.connect(current.getX(), current.getY(), next.getX(), next.getY());
			this.visit(next);
		}
	}
}
