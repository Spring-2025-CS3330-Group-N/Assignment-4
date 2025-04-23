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

	public MazeGenerator(int width, int height) {
		this.width = width;
		this.height = height;
		visited = new boolean[height][width];
		backtrack = new ArrayList<Coordinate>();
	}

	private <T> T pick(List<T> list) {
		var random = new Random();
		var index = random.nextInt(list.size());
		var item = list.get(index);
		return item;
	}

	private boolean inBounds(Coordinate coordinate) {
		var xInBounds = 0 <= coordinate.getX() && coordinate.getX() < this.width;
		var yInBounds = 0 <= coordinate.getY() && coordinate.getY() < this.height;
		var inBounds = xInBounds && yInBounds;
		return inBounds;
	}

	private boolean isVisited(Coordinate coordinate) {
		var isVisited = this.visited[coordinate.getY()][coordinate.getX()];
		return isVisited;
	}

	private List<Coordinate> getNeighbors(Coordinate of) {
		var neighbors = Arrays.asList(
			of.add(Movement.RIGHT),
			of.add(Movement.UP),
			of.add(Movement.LEFT),
			of.add(Movement.DOWN)
		);
		return neighbors;
	}

	private List<Coordinate> getVisitableNeighbors(Coordinate of) {
		var neighbors = this.getNeighbors(of);
		var visitableNeighbors = neighbors.stream().filter(
			coordinate -> this.inBounds(coordinate) && !this.isVisited(coordinate)
		).collect(Collectors.toList());
		return visitableNeighbors;
	}

	private void visit(Coordinate location) {
		this.visited[location.getY()][location.getX()] = true;
		this.backtrack.add(location);
	}

	/*
	 * x: the x coordinate of the entrance
	 * y: the y coordinate of the entrance
	 * sketcher: a "strategy" for "drawing" the maze
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
