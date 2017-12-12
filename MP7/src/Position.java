/**
 * A class that implements a square on the gameboard for CandyLand.
 * @author Corona
 *
 */
public class Position {
	private String color;
	private boolean isBridge;
	private boolean isSticky;
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
		this.color = color;
		isBridge = false;
	}
	/**
	 * Set position to be a bridge.
	 * Position 5 connects to 59 and position 35 to 46.
	 */
	public void setBridge(boolean condition) {
		isBridge = condition;
	}
	/**
	 * Get the isBridge status of the position.
	 * @return true if it is a bridge, false otherwise
	 */
	public boolean getBridge() {
		return isBridge;
	}
	/**
	 * Set position to be a "sticky" space.
	 * Positions 47, 76, and 89 are sticky spaces.
	 */
	public void setSticky(boolean condition) {
		isSticky = condition;
	}
	/**
	 * Get the isSticky status of the position.
	 * @return true if it is a sticky position, false otherwise
	 */
	public boolean getSticky() {
		return isSticky;
	}
	/**
	 * Get the color of the square.
	 * @return the color of the current position
	 */
	public String getColor() {
		return color;
	}
	
}
