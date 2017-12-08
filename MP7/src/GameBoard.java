import java.util.Arrays;
import java.util.stream.*;

/**
 * A class that implements a gameboard for CandyLand.
 * @author Corona
 */
public class GameBoard {
	
	private static final int NUMPOSITIONS = 136; 
	private Position[] board;
	public GameBoard() {
		//initialize board
		board = new Position[NUMPOSITIONS];
		setBoard();
	}
	public void setBoard() {
		//All the red spaces
		int[] red = {1, 7, 14, 21, 27, 33, 39, 46, 52, 64, 71, 77, 83, 89, 96, 103, 109, 115, 121, 127, 133};
		//All the orange spaces
		int[] orange = {5, 12, 18, 25, 31, 37, 44, 50, 56, 62, 68, 75, 81, 87, 94, 100, 107, 113, 119, 125, 131};
		//All the yellow spaces
		int[] yellow = {3, 10, 16, 23, 29, 35, 41, 48, 54, 60, 66, 73, 79, 85, 91, 98, 105, 111, 117, 123, 129};
		//All the green spaces
		int[] green = {6, 13, 19, 26, 32, 38, 45, 51, 57, 63, 70, 76, 82, 88, 95, 101, 108, 114, 120, 126, 132};
		//All the blue spaces
		int[] blue = {4, 11, 17, 24, 30, 36, 43, 49, 55, 61, 67, 74, 80, 86, 93, 99, 106, 112, 118, 124, 130};
		//All the purple spaces
		int[] purple = {2, 8, 15, 22, 28, 34, 40, 47, 53, 59, 65, 72, 78, 84, 90, 97, 104, 110, 116, 122, 128};
		//All the "sticky" spaces
		int[] sticky = {47, 76, 89};
		//All the bridges
		int[] bridge = {5, 35};
		
		
		for (int i = 1; i < 135; i++) { //index 0 is start, index 135 is finish
			int temp = i;
			if (IntStream.of(red).anyMatch(x -> x == temp)) {
				board[i] = new Position("r");
			} else if (IntStream.of(orange).anyMatch(x -> x == temp)) {
				board[i] = new Position("o");
			} else if (IntStream.of(yellow).anyMatch(x -> x == temp)) {
				board[i] = new Position("y");
			} else if (IntStream.of(green).anyMatch(x -> x == temp)) {
				board[i] = new Position("g");
			} else if (IntStream.of(blue).anyMatch(x -> x == temp)) {
				board[i] = new Position("b");
			} else if (IntStream.of(purple).anyMatch(x -> x == temp)) {
				board[i] = new Position("p");
			}
		}
	}
	
	public String getPositionColor(int position) {
		return board[position].getColor();
	}
}
