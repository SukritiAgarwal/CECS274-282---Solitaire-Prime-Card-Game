package SOLITAIREPRIME;
//Sukriti Agarwal
/* CECS 274 - 05
 * Prog 2 - Solitaire Prime
 * Due date: Feb 22, 2018
 */

import java.util.Scanner;

public class SolitairePrime {
	public static void main(String[] args) {
		Deck myDeck = new Deck(); //myDeck is a reference to an object from Deck class
			
		System.out.println("Welcome to Solitaire Prime!");
		int option; //This variable is used to store the option user chooses for a menu
		option = menu(); //menu returns an integer value and that is stored in the variable option
		while (option != 5) {  // 5 in menu equals Quit. 
		    if(option == 1) { // Creates a new Deck
		    	 myDeck = new Deck(); //This creates a new deck	         
		    }
		    else if(option == 2) { //Display the deck
		    	myDeck.display();
		    }
		    else if(option == 3) { //Shuffle the deck
		       myDeck.shuffle(); 
		    }
		    else if(option == 4) { //Play the game with the existing deck
		    	playSolitairePrime(myDeck);
		    }
		System.out.print("\nChoose an option: \n"); //Ask if user wants to play again, if yes then let them choose other option
		option = menu();
		}
	}	
	public static int menu() { //This is a function which displays the menu choices for the user and returns an integer value
		System.out.println("1 - New Deck");
		System.out.println("2 - Display Deck");
		System.out.println("3 - Shuffle Deck");
		System.out.println("4 - Play Solitaire Prime");
		System.out.println("5 - Exit");
		Scanner in = new Scanner(System.in);
		System.out.println("Enter \"1\", \"2\", \"3\", \"4\" or \"5\" ");
		int option = in.nextInt();
		in.close();
		if (option < 1 || option > 5) { //Input validation for other integers
	        System.out.println("Enter \"1\", \"2\", \"3\", \"4\" or \"5\"");
	        option = in.nextInt();
	    }
		return option; //returns user's choice
	} 
	
	public static void playSolitairePrime(Deck deck){ //This function helps to play the game and is a void function
		Card C1;
		int num = 0;
		int numPiles=0;
		for(int i = 0; i < 52; i++){
			C1= deck.deal(); //Calls the deal function from the Card class
			num += C1.getValue(); //Calls the getValue function from the Card class
			C1.display(); //Display function of Card class
			if(isPrime(num)){ 
				System.out.println("Prime:" + num);
				num = 0; //reset the num to be 0
				numPiles++; //increment the number of piles
				continue;                                    
			}
			else{
				continue;
			}           
		}
		if(num == 0){ //If the last pile is prime, then the user is a winner
			System.out.println("Winner in " + numPiles + "piles.");
		}
		else { //If last pile is composite, the user loses the game
			System.out.println("Loser");
		}
	}
	
	private static boolean isPrime(int n) {
		if (n == 1) { // 1 is neither Prime nor Composite
			return false;
		}
		else {
		    if (n % 2 == 0)  //check if n is a multiple of 2
		    	return false;
		    for(int i = 3 ; i * i <= n ; i += 2) { //if not, then just check the odd values(increment by a step of +2), because 2 is the only even prime number
		        if(n % i == 0) 
		            return false;
		    }
		    return true;
		} 
	}	
}

