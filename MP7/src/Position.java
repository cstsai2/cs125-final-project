/**
 * A class that implements a square on the gameboard for CandyLand.
 * @author Corona
 *
 */
public class Position {

	private String color;
	/** 
	 * Empty Constructor.
	 */
	public Position() {
		
	}
	/**
	 * Create a game board position with a specified color.
	 * @param color - the color of the gameboard square
	 */
	public Position(String color) {
		this.color = color.toUpperCase();
	}
	/**
	 * Get the color of the square.
	 * @return the color of the current position
	 */
	public String getColor() {
		return this.color;
	}
}
