package main;

public class Card {
	//I made these attributes public so that I could manipulate them to test certain functions in the main.
	public int suit;
	public int rank;
	boolean wild = false;
	
	public static final int Clubs = 1;
	public static final int Spades = 2;
	public static final int Hearts = 3;
	public static final int Diamonds =4;
	
	public final static int ACE =1;
	public final static int TWO = 2;
	public final static int THREE = 3;
	public final static int FOUR =4;
	public final static int FIVE = 5;
	public final static int SIX = 6;
	public final static int SEVEN = 7;
	public final static int EIGHT =8;
	public final static int NINE = 9;
	public final static int TEN = 10;
	public final static int JACK =11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	
	public Card (int x, int y){
		this.suit = x;
		this.rank = y;
	}
	
	public int Getsuit(){
		return this.suit;
	}
	
	public int Getrank(){
		return this.rank;
	}
	public String suittostring(){
		switch (this.suit){
		case Clubs:
			return " of Clubs";
		case Spades:
			return " of Spades";
		case Hearts:
			return " of Hearts";
		case Diamonds:
			return " of Diamonds";
		default:
			return null;
		}
	}
	
	public String ranktostring(){
		switch (this.rank) {
		case ACE:
			return "Ace";
		case TWO:
			return "Two";
		case THREE:
			return "Three";
		case FOUR:
			return "Four";
		case FIVE:
			return "Five";
		case SIX:
			return "Six";
		case SEVEN:
			return "Seven";
		case EIGHT:
			return "Eight";
		case NINE:
			return "Nine";
		case TEN:
			return "Ten";
		case JACK:
			return "Jack";
		case QUEEN:
			return "Queen";
		case KING:
			return "King";
		default:
			return null;
		}
		
	}
}
