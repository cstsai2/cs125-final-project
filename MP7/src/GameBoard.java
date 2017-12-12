import java.util.Arrays;
import java.util.stream.*;

/**
 * A class that implements a gameboard for CandyLand.
 * @author Corona + andrea
 */
public class GameBoard {
	/** The total number of positions, 134 color spaces + 2 to include the start and finish. */
	private static final int NUMPOSITIONS = 135; 
	/** An array of Positions that create the board. */
	private Position[] board;
	/**
	 * Constructor.
	 */
	public GameBoard() {
		//initialize board
		board = new Position[NUMPOSITIONS];
		//All the red spaces
		int[] red = {1, 7, 14, 21, 27, 33, 39, 46, 52, 58, 64, 71, 77, 83, 89, 96, 103, 109, 115, 121, 127, 133};
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
		//All the character cards
		int[] characters = {9, 20, 42, 69, 92, 102};
		//Character card names
		String[] characterNames = {"Gramma Nut",  "Queen Frostine", "Mr. Mint", "Candy Princess", "Gumdrop", "Candy Cane"};
		
		
		//All the "sticky" spaces
		int[] sticky = {47, 76, 89};
		//All the bridges
		int[] bridge = {5, 35};
		
		
		for (int i : red) {
			board[i] = new Position("r");
		}
		for (int i : orange) {
			board[i] = new Position("o");
		}
		for (int i : yellow) {
			board[i] = new Position("y");
		}
		for (int i : green) {
			board[i] = new Position("g");
		}
		for (int i : blue) {
			board[i] = new Position("b");
		}
		for (int i : purple) {
			board[i] = new Position("p");
		}
		for (int i : sticky) {
			board[i].setSticky(true);
		}
		for (int i : bridge) {
			board[i].setBridge(true);
		}
		

		
		board[09] = new Position("Gramma Nut");
		board[20] = new Position("Queen Frostine");
		board[42] = new Position("Mr. Mint");
		board[69] = new Position("Candy Princess");
		board[92] = new Position("Gumdrop");
		board[102] = new Position("Candy Cane");
		
		board[0] = new Position("start");
		board[134] = new Position("finish");
	}

	/**
	 * Returns the color of the specified space.
	 * @param position - the position of interest
	 * @return the color of the space at the position
	 */
	public String getPositionColor(int position) {
		return board[position].getColor(); //root of problem!!!!
	}
	/**
	 * Returns the condition, sticky or not, of the specific position.
	 * @param position - the position of interest
	 * @return true if the position is sticky, false otherwise
	 */
	public boolean getSticky(int position) {
		return board[position].getSticky();
	}
	/**
	 * Returns whether or not this space is a bridge.
	 * @param position - the position of interest
	 * @return true if the position is a bridge, false otherwise
	 */
	public boolean getBridge(int position) {
		return board[position].getBridge();
	}
}
