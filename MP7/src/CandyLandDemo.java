import java.util.Scanner;

public class CandyLandDemo {
	
	private static int numPlayers;
	private static Scanner reader;
	private static Player[] players;
	private static GameBoard board;
	private static Player winner;
	
	public static void main(String[] args) { 
		reader = new Scanner(System.in);
		board = new GameBoard();
		setUp();
		boolean isWinnerFound = false;
		int playerTurn = 0;
		
		while (!isWinnerFound) {
			
			if (!players[playerTurn].getSkipCondition()) {
				
				System.out.println("It is now " + players[playerTurn].getName() + "'s turn.");
				
				turn(players[playerTurn]); //problem
				isWinnerFound = checkWinner();
				printStatus();
			} else { 
				
				System.out.println(players[playerTurn].getName() + "'s turn has been skipped.");
				System.out.println(players[playerTurn].getName() + " does not advance.");
				players[playerTurn].setSkipCondition(false);
				
			}
 
			playerTurn++;
			if (playerTurn > players.length - 1) { //if the last player has just taken their turn
				playerTurn = 0;						// it wraps back around to the first player
			}
			
			System.out.println("*******************************");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(winner.getName() + " has won this round of CandyLand. Congratulations!");
	}
	
	/**
	 * Checks if any player has reached position 134. 134 is the position of the finish.
	 * @return true if above condition is found, false otherwise
	 */
	private static boolean checkWinner() {
		for (Player p : players) {
			if (p.getPosition() == 134) {
				winner = new Player(p);
				return true;
			}
		}
		return false;
	}
	/**
	 * Player turn.
	 * @param player - the player whose turn it is
	 */
	private static void turn(Player player) {
		
		Card myCard = new Card();
		String card = myCard.draw();
		System.out.println(player.getName() + " has drawn a card '" + card + "'." );
		if (card.length() <= 2) { //if a color or double color card has been drawn
			move(player, card); 
			System.out.println(player.getName() + " has moved.");
		} else {// a character card has been drawn
			// All the character cards
			int[] characters = {9, 20, 42, 69, 92, 102};
			// Character card names
			String[] characterNames = {"Gramma Nut",  "Queen Frostine", "Mr. Mint", "Candy Princess", "Gumdrop", "Candy Cane"};
			int newPosition = 0;
			for (int i = 0; i < 6; i++) {
				if (card.equals(characterNames[i])) {
					newPosition = characters[i];
					break;
				}
			}
			player.setPosition(newPosition);
			System.out.println(player.getName() + " has moved to position " + newPosition);
			
		}
	}
	/**
	 * A helper method for move().
	 * Get the next space with the color specified. 
	 * @param position - current position
	 * @param color - color of interest
	 * @return the next closest position when the space is the color of interest, or finish if no more colors
	 */
	private static int getNextPosition(int position, String color) {
		for (int i = position + 1; i < 134; i++) {
			String pColor = board.getPositionColor(i);
			if (pColor.equals(color)) {
				return i;
			}
		}
		return 134;
	}
	/**
	 * Move the player to the specified color space on the card drawn.
	 * @param player - the player who is moving
	 * @param card - the card the player drew
	 */
	private static void move(Player player, String card) {
		int endPosition = -1;
		int currentPosition = player.getPosition();
		String color = card.substring(0,1);
		endPosition = getNextPosition(currentPosition, color); // problem
 		if (card.length() == 2 && endPosition != 134) { // this is a double color card
			endPosition = getNextPosition(endPosition, color);
		}
		
		if (board.getSticky(endPosition)) { // the player has landed on a "sticky" space
			System.out.println(player.getName() + " has landed on a sticky space.");
			player.setSkipCondition(true); // Player will have to skip a turn
		}
		if (board.getBridge(endPosition)) {
			System.out.println(player.getName() + " has landed on a bridge.");
			if (endPosition == 5) {
				endPosition = 59;
				System.out.print(player.getName() + " crosses the bridge and lands at position 59.");
			} else if (endPosition  == 35) {
				endPosition = 46;
				System.out.print(player.getName() + " crosses the bridge and lands at position 46.");
			}
		}
		player.setPosition(endPosition);

	}
	/**
	 * Print the current player positions.
	 */
	private static void printStatus() {
		for (Player p : players) {
			System.out.println(p.getName() + " is currently " + (134 - p.getPosition()) + " spaces from finish.");
		}
	}
	/**
	 * Initialize necessary components for game play. Set up and initialize the players as well.
	 */
	private static void setUp() {
		
		// welcome to candyland...
		System.out.println("Welcome to CandyLand.");
		 
		// SET UP PLAYERS
		
		while (true) { // check value between 2 and 4
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
			// Player name
			String tempName;
			while (true) {
				System.out.println("What is Player " + (i + 1) + "'s name?");
				tempName = reader.next();
				if (tempName != null) { // make sure name is not null
					players[i].setName(tempName);
					break;
				}
				System.out.println("Please try again.");
			}
			// Player age
			int tempAge = 0;
			while (true) {
				System.out.println("What is Player " + (i + 1) + "'s age?");
				tempAge = reader.nextInt();
				if (tempAge >= 3) { // make sure age is over 3
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
	 * This is will also print the standard playing order after reordering the players appropriately.
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
