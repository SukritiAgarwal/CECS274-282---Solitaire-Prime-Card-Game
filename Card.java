package SOLITAIREPRIME;
//This is the Card class
public class Card {
	
	//Declare all the public and private vehicles
	
	private char suit; // Suit has the values: Spade, Heart, Diamond, Club 
	
	private char rank; // Rank has the values: Ace, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King
	
	public Card(char r, char s) { // This is a constructor for Card class with 2 parameters
		rank = r;
		suit = s;
	}
	
	public void display() { //This function is used to display the value of the card and does not return anything
		if (rank == 'T') //This case is an exception, because for all the other cases rank is displayed the same way it is declared. 
			System.out.print("10" + "" + suit + " ");
		else
			System.out.print(rank + "" + suit + " ");
	}	
	
	public int getValue() { //This function is used to get values for all the ranks and returns an integer value 
		int value;
		if (rank == 'A')
			value = 1;
		
		else if (rank >= '2' && rank <= '9') // && (and) operator is used to make sure both the conditions are true
			value =  (int)rank - 48; // (int)rank returns the ASCII value of the numbers from 2 to 9; thus -48 (ASCII for 0) is used to get the actual number 
		
		else if(rank == 'T' || rank == 'J' || rank == 'Q' || rank == 'K') // ||(or) operator is used, so it is true even if one of the conditions is true
			value = 10; 
		else 
			value = 0;
		
		return value; //This is the default value, and it is return because we do not have an else case. This acts like a default return value, if none of the if statements is true. 
	}	
	
	public char getRank() { //This function is used to get the rank and returns a char
		return rank;
	}	
	
	public char getSuit() { //This function is used to get the suit and returns a char
		return suit;
	}
}