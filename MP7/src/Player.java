/**
 * A class that implements a player for CandyLand.
 * @author Corona & Andrea
 */
public class Player {
	/** Player name. */
	private String name;
	/** Player age. */
	private int age;
	/** Tracks player position. */
	private int position;
	/** Tracks if player will have a turn skipped.*/
	private boolean isSkipped;
	
	/**
	 * Default Constructor.
	 */
	public Player() {
		this.position = 0;
		this.isSkipped = false;
	}
	/**
	 * Copy Constructor.
	 */
	public Player(Player other) {
		this.name = other.name;
		this.age = other.age;
		this.position = other.position;
		this.isSkipped = other.isSkipped;
	}
	/**
	 * Creates a new player with a given name and age.
	 * Each player begins at position 0 and does not have their turn skipped.
	 * @param name - the name for the new player
	 * @param age - the age for the new player
	 */
	public Player(String name, int age) {
		this.name = name;
		this.age = age;
		this.position = 0;
		this.isSkipped = false;
	}
	/**
	 * Get the player's age.
	 * @return the player's age
	 */
	public int getAge() {
		return this.age;
	}
	/**
	 * Set the player's age.
	 * @param newAge - the player's new age
	 */
	public void setAge(int nAge) {
		this.age = nAge;
	}
	/**
	 * Gets the player name.
	 * @return the player's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Set the player's name.
	 * @param newName - the player's new name
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	/**
	 * Gets the player's position.
	 * @return the player position
	 */
	public int getPosition() {
		return this.position;
	}
	/**
	 * Sets the player's position.
	 * @param newPosition - the new player position
	 */
	public void setPosition(int newPosition) {
		this.position = newPosition;
	}
	/**
	 * Gets whether or not the player's next turn will be skipped.
	 * @return true if player's next turn should be skipped, else false
	 */
	public boolean getSkipCondition() {
		return this.isSkipped;
	}
	/**
	 * Sets player's 'isSkipped' condition.
	 * @param condition - the player's new condition
	 */
	public void setSkipCondition(boolean condition) {
		this.isSkipped = condition;
	}
	
}
