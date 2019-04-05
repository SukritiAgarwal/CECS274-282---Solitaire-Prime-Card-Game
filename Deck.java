package SOLITAIREPRIME;
import java.util.Random;

//This is the Deck class
public class Deck {
	// Declare all the variables
	
	private Card [ ] data; // data is a reference to an object from Card class and has 0 items in it
	private int top; //This is used to keep a track of the number of cards dealt, and hence where is the top card placed
	String suits = "SHDC";
	String ranks = "A23456789TJQK";
	
	public Deck() { //This is the default constructor for Deck class
		data = new Card[52]; //Initialize the object to have 52 references 
		top = 0; //Initialize the top variable
		int count = 0; //Counter variable
		Card C1; //Another reference to an object from Card class
		for(int s = 0; s < suits.length(); s++)
			for (int r = 0; r < ranks.length(); r++){
				C1 = new Card(ranks.charAt(r), suits.charAt(s));
				data[count++] = C1;
			}
	}
		
	public void display(){ //A function to display the deck in 13 columns * 4 rows format and does not return anything 
		int index = 0;
		for (int i = 0; i < suits.length(); i++) {
			for (int j = 0; j < ranks.length(); j++) {
				data[index].display();
				if (data[index].getRank() == 'T') { //separate case needed because displaying 10 requires 2 spaces, everything else is a char long
					System.out.print("  ");
				} 
				else {
					System.out.print("   ");
				}
				index++; //Increment the index after the if-else statements has been executed once
			}
			System.out.println(); //New line after the inner loop has been executed once, thus displaying 13 values in a row
		}
	}
	
	public void shuffle(){ //This function is used to shuffle the cards of the Deck, does not print anything, does not return anything
		Random rand = new Random(); // Rand is a reference to an object for Random class
		int x,y;
		Card temp; // Temp card to temporarily store the swapped value
		for (int i = 0; i < 1050; i++) {
			x = rand.nextInt(52);
			y = rand.nextInt(52);
			temp = data[x];
			data[x] = data[y];
			data[y] = temp;
		}
		top = 0;
	}
	
	public Card deal() { //This function is used to deal a card from the deck, it returns a Card from the Deck
		return data[top++]; // top++ : top increments after its executed for one time 
	}
}