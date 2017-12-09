import java.util.Scanner;

public class CandyLandDemo {
	private static int numPlayers;
	private static Scanner reader;
	private static Player[] players;
	private static GameBoard board;
	public static void main(String[] args) {
		setUp();
		//Game Start
		//while winner is not found
		//players take turns playing- loop //print status of players each turn
		//break, display winner name
	}
	
	private void turn(Player player) {
		//specified player takes a turn
		//Draws a card
		Card myCard = new Card();
		String card = myCard.draw();
		//Move according to card
		if (card.length() <= 2) { //if a color or double color card has been drawn
			move(player, card);
		} //else move to other specified location
		
		//...
	}
	
	private void move(Player player, String card) {
		int endPosition = -1; // 
		
		//dont forget about bridges!
	}
	private void printStatus() {
		//prints the status of each player each turn
		//ex. player one is x number of spaces from finish, player 2 is y number, etc
	}
	
	private static void setUp() {
		//initialize scanner
		reader = new Scanner(System.in);
		//initialize game board
		board = new GameBoard();
		//welcome to candyland...
		System.out.println("Welcome to CandyLand.");
		 
		//SET UP PLAYERS
		
		while (true) { //check value between 2 and 4
			System.out.println("How many players are there? (minimum of 2 and maximum of 4)");
			numPlayers = reader.nextInt();
			if (numPlayers >= 2 && numPlayers <= 4) {
				break;
			}
			System.out.println("You inputted an invalid value, please try again.");
		}
		
		players = new Player[numPlayers];
		
		for (int i = 0; i < players.length; i++) {
			players[i] = new Player();
			//Player name
			String tempName;
			while (true) {
				System.out.println("What is Player " + (i + 1) + "'s name?");
				tempName = reader.next();
				if (tempName != null) { //make sure name is not null
					players[i].setName(tempName);
					break;
				}
				System.out.println("Please try again.");
			}
			//Player age
			int tempAge = 0;
			while (true) {
				System.out.println("What is Player " + (i + 1) + "'s age?");
				tempAge = reader.nextInt();
				if (tempAge >= 3) { //make sure age is over 3
					break;
				}
				System.out.println("Player must be 3 years of age or older, please try again.");
			}
			players[i] = new Player(tempName, tempAge);

			
		}
		
		turnOrder();
	}
	/**
	 * Reorders the player array such that it is in order of ascending ages.
	 * This is the standard playing order.
	 */
	private static void turnOrder() {
		for (int i = 0; i < players.length - 1; i++) {
			for (int j = i; j < players.length; j++) {
				if (players[j].getAge() < players[i].getAge()) {
					Player temp = players[j];
					players[j] = players[i];
					players[i] = temp;
				}
			}
		}
		System.out.println("The playing order is as follows: " );
		for (Player p : players) {
			System.out.println(p.getName());
		}
	}
	
}
