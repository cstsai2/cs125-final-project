import java.util.Scanner;

public class CandyLandDemo {
	private static int numPlayers;
	private static Scanner reader;
	private Player[] players;
	private static GameBoard board;
	public static void main(String[] args) {
		setUp();
		//Game Start
		//while winner is not found
		//players take turns playing- loop
		//break, display winner name
	}
	
	private void turn(Player player) {
		//specified player takes a turn
		//Draws a card
		Card myCard = new Card();
		String card = myCard.draw();
		//Move according to card
		//...
	}
	
	private static void setUp() {
		//initialize scanner
		reader = new Scanner(System.in);
		//initialize game board
		board = new GameBoard();
		//welcome to candyland...
		//how many players
		numPlayers = reader.nextInt();
		//setUp players	
	}
}
