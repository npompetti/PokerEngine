package main;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Hand {
	
	private ArrayList<Card> hand;
	
	private int HandStrength;
	private int LowHand=0;
	private int HighCard=0;
	private int Kicker=0;
	public boolean Royal;
	public boolean Straight;
	public boolean Flush;
	private boolean Scored = false;
	
	
	public ArrayList<Card> HandCards = new ArrayList<Card>();
	
	public Hand(Deck d){
		for (int i =1; i<=5; i++){
			Card addcard = d.drawCard();
			HandCards.add(addcard);
			
		}
		
	}
	
	public void sort_hand(Hand player){
		int[] rank_holder = new int[4];
		for(int i = 0; i<4; i++){
			rank_holder[i] = player.HandCards.get(i).Getrank();
		}
		Arrays.sort(rank_holder);
		
		for(int n= 0; n<4; n++){
			player.HandCards.get(n).rank = rank_holder[n];
		}
	}
	
	
	public int get_handstrength(){
		return HandStrength;
	}
	
	public int get_LowHand(){
		return LowHand;
	}
	
	public int get_HighCard(){
		return HighCard;
	}
	
	public int get_Kicker(){
		return Kicker;
	}
	
	
	
	
	
	public void hand_eval(Hand player, boolean flush_results, boolean royal_results, boolean straight_results){
		//Royal Flush
		if (royal_results == true && flush_results == true && straight_results == true){
			HandStrength = 10;
		}
		
		//Straight Flush
		if (straight_results == true && royal_results == true){
			HandStrength = 9;
			HighCard = player.HandCards.get(0).Getrank();
			Kicker = player.HandCards.get(4).Getrank();
			
		}
		
		
		//Four of a Kind
		
		else if(player.HandCards.get(0).Getrank() == player.HandCards.get(3).Getrank()){
			HandStrength = 8;
			HighCard=player.HandCards.get(0).Getrank();
			LowHand = 0;
			Kicker=player.HandCards.get(4).Getrank();
		}
		
		else if(player.HandCards.get(1).Getrank() == player.HandCards.get(4).Getrank()){
			HandStrength = 8;
			HighCard=player.HandCards.get(1).Getrank();
			Kicker=player.HandCards.get(0).Getrank();
		}
		
		//Full House, Do we make the three pair higher than the two pair
		else if(player.HandCards.get(0).Getrank()==player.HandCards.get(1).Getrank()
				&& player.HandCards.get(0).Getrank() == player.HandCards.get(2).Getrank()
				&& player.HandCards.get(3).Getrank() == player.HandCards.get(4).Getrank()){
			HandStrength = 7;
			HighCard=player.HandCards.get(0).Getrank();
			LowHand=player.HandCards.get(3).Getrank();
			Kicker = 0;
			
		}
		
		else if(player.HandCards.get(0).Getrank()==player.HandCards.get(1).Getrank()
				&& player.HandCards.get(2).Getrank() == player.HandCards.get(4).Getrank()){
			HandStrength = 7;
			HighCard=player.HandCards.get(2).Getrank();
			LowHand=player.HandCards.get(0).Getrank();
			Kicker = 0;
			
		}
		
		//Flush
		else if(flush_results == true){
			HandStrength = 6;
			HighCard=player.HandCards.get(0).Getrank();
			LowHand= player.HandCards.get(1).Getrank();
			Kicker = player.HandCards.get(4).Getrank();
		}
		
		//Straight
		else if(straight_results == true){
			HandStrength = 5;
			HighCard = player.HandCards.get(0).Getrank();
			LowHand=0;
			Kicker= 0;
			
		}
		
		//Three of a Kind
		else if(player.HandCards.get(0).Getrank()==player.HandCards.get(1).Getrank()
				&& player.HandCards.get(1).Getrank() == player.HandCards.get(2).Getrank()){
			HandStrength = 4;
			HighCard=player.HandCards.get(0).Getrank();
			LowHand = player.HandCards.get(3).Getrank();
			Kicker=player.HandCards.get(4).Getrank();
		}
		
		else if(player.HandCards.get(1).Getrank() == player.HandCards.get(3).Getrank()){
			HandStrength = 4;
			HighCard=player.HandCards.get(1).Getrank();
			LowHand=player.HandCards.get(0).Getrank();
			Kicker = player.HandCards.get(4).Getrank();	
		}
		
		else if(player.HandCards.get(2).Getrank() == player.HandCards.get(4).Getrank()){
			HandStrength = 4;
			HighCard=player.HandCards.get(2).Getrank();
			LowHand=player.HandCards.get(0).Getrank();
			Kicker=player.HandCards.get(1).Getrank();	
		}
		
		//Two pair
		else if(player.HandCards.get(0).Getrank() == player.HandCards.get(1).Getrank()
				&& player.HandCards.get(2).Getrank() == player.HandCards.get(3).Getrank()){
			HandStrength = 3;
			HighCard= player.HandCards.get(0).Getrank();
			LowHand= player.HandCards.get(2).Getrank();
			Kicker= player.HandCards.get(4).Getrank();
			
		}
		else if(player.HandCards.get(0).Getrank() == player.HandCards.get(1).Getrank()
				&& player .HandCards.get(3).Getrank() == player.HandCards.get(4).Getrank()){
			HandStrength = 3;
			HighCard=player.HandCards.get(0).Getrank();
			LowHand=player.HandCards.get(3).Getrank();
			Kicker=player.HandCards.get(2).Getrank();
		}
		else if(player.HandCards.get(1).Getrank() == player.HandCards.get(2).Getrank()
				&& player .HandCards.get(3).Getrank() == player.HandCards.get(4).Getrank()){
			HandStrength = 3;
			HighCard=player.HandCards.get(1).Getrank();
			LowHand=player.HandCards.get(3).Getrank();
			Kicker=player.HandCards.get(0).Getrank();
		}
		
		//Pair
		else if(player.HandCards.get(0).Getrank() == player.HandCards.get(1).Getrank()){
			HandStrength = 2;
			HighCard=player.HandCards.get(0).Getrank();
			LowHand=0;
			Kicker=player.HandCards.get(2).Getrank();
			
		}
		
		else if(player.HandCards.get(1).Getrank() == player.HandCards.get(2).Getrank()){
			HandStrength = 2;
			HighCard=player.HandCards.get(1).Getrank();
			LowHand=0;
			Kicker=player.HandCards.get(0).Getrank();
		}
		
		else if(player.HandCards.get(2).Getrank() == player.HandCards.get(3).Getrank()){
			HandStrength = 2;
			HighCard=player.HandCards.get(2).Getrank();
			LowHand=0;
			Kicker=player.HandCards.get(0).Getrank();
		}
		
		else if(player.HandCards.get(3).Getrank() == player.HandCards.get(4).Getrank()){
			HandStrength = 2;
			HighCard=player.HandCards.get(3).Getrank();
			LowHand=0;
			Kicker=player.HandCards.get(0).Getrank();
		}
	} 

}
