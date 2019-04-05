/*
Sukriti Agarwal
016280171
CECS 282-05
Prog 1 - Solitaire Prime
Due- Sept 20,2018
*/


#include "Card.h"
#include "Deck.h"
#include <iostream>
#include <string>

using namespace std;

bool isPrime(int);

int main() {
	Deck myDeck;
	int sum = 0;
	int option;
	cout << "Welcome to Solitaire Prime!\n";
	while (true) {
		cout << "1)  New Deck\n";
		cout << "2)  Display Deck\n";
		cout << "3)  Shuffle Deck\n";
		cout << "4)  Play Solitaire Prime\n";
		cout << "5)  Exit\n";
		cout << "What operation do you wish to perform? ";
		cin >> option;
		if (option == 1) {
			myDeck.refreshDeck();
			cout << "New Deck Created.\n";
		}
		else if (option == 2) {
			myDeck.display();
		}
		else if (option == 3) {
			myDeck.shuffle();
			cout << "Existing deck is shuffled.\n"; 
		}
		else if (option == 4) {
			int piles = 0;
			Card myCard;
			for (int i = 0; i < 52; i++) {
				myCard = myDeck.deal();
				sum += myCard.getValue();
				myCard.display();
				if (isPrime(sum)) {
					cout << "  PRIME: " << sum << endl;
					sum = 0;
					piles++;
					continue;
				}
				else {
					continue;
				}
			}
			if (sum == 0) {
				cout << "\nWINNER in " << piles << " piles!\n";
			}
			else {
				cout << "  Sum is: " << sum << " which is NOT prime. \n";
				cout << "LOSER\n";
			}
			cout << endl;
		}
		else if (option == 5) {
			return false;
		}
		else {
			cout << "Invalid option! Enter the right option:  ";
			cin >> option;
		}
	}

	getchar();
	getchar();
	return 0;
}

bool isPrime(int x) {
	if (x == 1)
		return false;
	else if (x == 2)
		return true;
	else if (x % 2 == 0)
		return false;
	else {
		for (int i = 3; i*i <= x; i += 2) {
			if (x%i == 0)
				return false;
		}
		return true;
	}
}




