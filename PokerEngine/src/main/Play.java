package main;

public class Play {

	public static void checkFlush(Hand player){

		//tally holds the number of same suits
		int tally = 0;

		//This is the return variable that will state whether it is true or false
		boolean ans = false;
		//for loop to check each card against one another
		for(int i = 0; i <=3; i++){

			if (player.HandCards.get(i).Getsuit() == player.HandCards.get(i+1).Getsuit()){
				tally += 1;
			}

		}

		player.Flush = (tally == 4) ? true : false ;	
	}


	public static void checkStraight(Hand player){

		//a variable to report whether there is a straight or not, defaulted at false.

		//Regular straight
		if(player.HandCards.get(0).Getrank() == (player.HandCards.get(1).Getrank() -1)
				&& player.HandCards.get(0).Getrank() == (player.HandCards.get(2).Getrank() - 2)
				&& player.HandCards.get(0).Getrank() == (player.HandCards.get(3).Getrank()-3)
				&& player.HandCards.get(0).Getrank() == (player.HandCards.get(4).Getrank()-4))
			player.Straight = true;

		//Ace High straight
		else if (player.HandCards.get(0).Getrank() == 14 && player.HandCards.get(1).Getrank()==13
				&& player.HandCards.get(2).Getrank() == 12 && player.HandCards.get(3).Getrank() == 11
				&& player.HandCards.get(4).Getrank() == 10){
			player.Straight = true;

		}

		//Ace low card straight
		else if( (player.HandCards.get(0).Getrank()==14) && player.HandCards.get(1).Getrank()==5 && player.HandCards.get(2).Getrank()==4 && player.HandCards.get(3).Getrank()==3 
				&& player.HandCards.get(4).Getrank()==2){
			player.Straight = true;
		}

		else{
			player.Straight = false;
		}

	}
	
	

	//Check Royal
	public static void checkRoyal(Hand player){
		if(player.HandCards.get(0).Getrank() == 14 && player.HandCards.get(1).Getrank()==13
				&& player.HandCards.get(2).Getrank() == 12 && player.HandCards.get(3).Getrank() == 11
				&& player.HandCards.get(4).Getrank() == 10){
			player.Royal = true;
		}
	}
	
	

	public static void main(String[] args){
		

		int player1_score = 0;
		int player2_score = 0;


		//Creating a deck with variable named d
		Deck d = new Deck();
		d.Shuffledeck(d.cards);

		//Instantiating first hand
		Hand h1 = new Hand(d);
		String hand1_cards="";

		//Instantiating second hand
		Hand h2 = new Hand(d);
		String hand2_cards="";
		

		//Inset sort function


		//Showing the cards remaining in the deck
		System.out.println(d.Cardsremaining());
		
		//Initializing evaluation
		checkFlush(h1);
		checkStraight(h1);
		checkRoyal(h1);
		
		checkFlush(h2);
		checkStraight(h2);
		checkRoyal(h2);
		
		h1.hand_eval(h1, h1.Flush, h1.Royal, h1.Straight);
		h2.hand_eval(h2, h2.Flush, h2.Royal, h2.Straight);

				//Compare hands
				
				//System.out.println("Player 1 Hand: "+h1.HandCards.get(0).);

		//h1.HandCards.get(0).rank= 3;
		//h1.HandCards.get(1).rank= 9;
		//h1.HandCards.get(2).rank= 10;
		//h1.HandCards.get(3).rank= 8;
		//h1.HandCards.get(4).rank= 12;
		checkFlush(h1);
		checkStraight(h1);
		checkRoyal(h1);
		h1.hand_eval(h1,h1.Flush,h1.Royal,h1.Straight);
		System.out.print(h1.get_handstrength());
		
		//Compare Hands
		//Display Player 1 hand
		for(int i = 0; i<5; i++){

			hand1_cards += h1.HandCards.get(i).ranktostring();
			hand1_cards += h1.HandCards.get(i).suittostring() + ", ";
		}	
		System.out.println("Player 1's hand is: " + hand1_cards);
		System.out.println("Player 1  hand strength is: " + h1.get_handstrength());
		System.out.println("Player 1 high card is: "+ h1.get_HighCard());
		System.out.println("Player 1 low card is: " +h1.get_LowHand());
		System.out.println("Player 1 kicker is: "+ h1.get_Kicker());
		
		//Display Player 2 hand
		for(int n = 0; n<5; n++){
			//for(int n=0; n<4; n++){
			hand2_cards += h2.HandCards.get(n).ranktostring();
			
			hand2_cards += h2.HandCards.get(n).suittostring() + ", ";
		}
		System.out.println("Player 2's hand is: " + hand2_cards);
		System.out.println("Player 2 hand strength is: " + h2.get_handstrength());
		System.out.println("Player 2 high card is: "+ h2.get_HighCard());
		System.out.println("Player 2 low card is: " +h2.get_LowHand());
		System.out.println("Player 2 kicker is: "+ h2.get_Kicker());
		
		//Comparing Hands
			System.out.println("Comparing Hands..");
			
			if(h1.get_handstrength() == h2.get_handstrength()){
				System.out.print("Hand strength is equal comparing High Cards.. \n");
				
				if(h1.get_HighCard() == h2.get_HighCard()){
					System.out.print("High cards are equal comparing LowHand");
					
					if(h1.get_LowHand() == h2.get_LowHand()){
						System.out.print("Low hands are equal..");
					}
					
					
						if(h1.get_Kicker() == h2.get_Kicker()){
							System.out.print("");
						}
							else if(h1.get_Kicker() > h2.get_Kicker()){
								System.out.print("Player 1 wins!!!");
							}
							else if(h1.get_Kicker() < h2.get_Kicker()){
								System.out.print("Player 2 wins!!");
							}
					
					else if(h1.get_HighCard() > h2.get_HighCard()){
						System.out.print("Player 1 wins!!!");
					}
					else{
						System.out.print("Player 2 wins!!!");
					}
				}
			}
				else if(h1.get_handstrength() > h2.get_handstrength()){
					System.out.print("Player 1 wins!!!");
				}
				else{
					System.out.print("Player 2 wins!!!");
				}
				
			
		
		


	}
}
