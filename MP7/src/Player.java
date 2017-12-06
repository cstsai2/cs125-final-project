/**
 * A class that implements a player for CandyLand.
 * @author Corona & Andrea
 */
public class Player {
	private String name;
	private int age;
	
	public Player(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
	/**
	 * Returns the player name.
	 * @return the current player's name
	 */
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
}
