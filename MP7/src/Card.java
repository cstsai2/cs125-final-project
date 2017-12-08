/**
 * A class that implements a card for CandyLand.
 * Cards drawn will be of varying colors of the candyland gameboard.
 * @author Corona & Andrea
 *
 */
public class Card {
	private int randomNumber;
	/**
	 * Empty Constructor;
	 */
	public Card() {
		
	}
	/**
	 * Returns the color of a card that is drawn.
	 * @return the contents of the card drawn
	 */
	public String draw() {
		randomNumber = (int) (Math.random()*64 + 1);
		String color = determineColor(randomNumber);
		return color;
	}
	/**
	 * Determining the color of the card given the random number generated. Random number is between
	 * 1 and 64 as there are 64 cards total in the deck and is used to accurately model the probability
	 * of drawing a card based on the standard CandyLand deck.
	 * @param num - a random number between 1 and 64
	 * @return a string representing the card that is drawn
	 */
	private String determineColor(int num) {
		String temp = "";
		if (num <= 6) { //SINGLE COLOR CARDS
			temp = "r"; //There are 6 red cards in the deck
		} else if (num <= 12) {
			temp = "o"; //There are 6 orange cards in the deck
		} else if (num <= 18) {
			temp = "y"; //There are 6 yellow cards in the deck
		} else if (num <= 24) {
			temp = "g"; //There are 6 green cards in the deck
		} else if (num <= 30) {
			temp = "b"; //There are 6 blue cards in the deck
		} else if (num <= 36) {
			temp = "p"; //There are 6 purple cards in the deck
		} else if (num <= 40) { //DOUBLE COLOR CARDS
			temp = "rr"; //There are 4 double red cards in the deck
		} else if (num <= 43) {
			temp = "oo"; //There are 3 double orange cards in the deck
		} else if (num <= 47) {
			temp = "yy"; //There are 4 double yellow cards in the deck
		} else if (num <= 50) {
			temp = "gg"; //There are 3 double green cards in the deck
		} else if (num <= 54) {
			temp = "bb"; //There are 4 double blue cards in the deck
		} else if (num <= 58) {
			temp = "pp"; //There are 4 double purple cards in the deck
		} else if (num == 59) { //CHARACTER CARDS
			//
		} else if (num == 60) {
			//
		} else if (num == 61) {
			//
		} else if (num == 62) {
			//
		} else if (num == 63) {
			//
		} else if (num == 64) {
			//
		}
		return temp;
	}

}
