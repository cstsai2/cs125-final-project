import java.util.Arrays;
import java.util.stream.*;

/**
 * A class that implements a gameboard for CandyLand.
 * @author Corona
 */
public class GameBoard {
	
	private static final int NUMPOSITIONS = 143; // I forget what the actual number is
	private Position[] board;
	public GameBoard() {
		//initialize board
		board = new Position[NUMPOSITIONS];
		setBoard();
	}
	public void setBoard() {
		int[] red = {};
		//int[] color2 = {}; 
		//.... rest of the colors
		for (int i = 1; i < board.length; i++) {
			int temp = i;
			if (IntStream.of(red).anyMatch(x -> x == temp)) {
				board[i] = new Position("red");
			} //else if orange, else if yellow, etc
		}
	}
}
