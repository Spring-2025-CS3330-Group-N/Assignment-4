package hw4;

import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.solver.MazeProbe;
import hw4.maze.solver.MazeSolver;
import hw4.player.Movement;
import hw4.player.Player;

public class Simulation {
	public static void main(String[] args) {
		var mazeSize = 7;
		var game = new Game(mazeSize);
		var player = new Player(null, null);
		game.movePlayerTo(player, mazeSize - 1, mazeSize - 1);

		game.printBoard(player, true);

		var solver = new MazeSolver(6, 6);
		solver.solve(new MazeProbe() {
			@Override
			public boolean checkEscaped(int x, int y) {
				var escaped = x < 0;
				return escaped;
			}

			@Override
			public boolean attemptMove(int x1, int y1, int x2, int y2) {
				var direction = Movement.fromDelta(x2 - x1, y2 - y1);
				var success = game.play(direction, player);
				return success;
			}
		});
	}
}
