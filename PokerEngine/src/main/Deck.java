package main;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private int Numberofcards;
	private int NumberofJokers;
	ArrayList<Card> cards = new ArrayList<Card>();
	
	
	public Deck (){
	 	
		for (int a=1; a<=4; a++){
			for (int b=1; b<=14; b++){
				cards.add(new Card(a, b));
				}
			}
	}
	
	public void Shuffledeck(ArrayList<Card> x){
		Collections.shuffle(x);
	}
	
	public Card drawCard(){
		Card drawcard = cards.get(0);
		cards.remove(0);
		return drawcard;
	}
	
	public int Cardsremaining(){
		return cards.size();
	}

}
