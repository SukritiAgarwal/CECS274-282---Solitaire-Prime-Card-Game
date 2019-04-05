/*
Sukriti Agarwal
016280171
CECS 282-05
Prog 1 - Solitaire Prime
Due- Sept 20,2018
*/

#include "Card.h"
#include <iostream>
#include <string>

using namespace std;

Card::Card(){
	rank = 'X';
	suit = 'X';
}
Card::Card(char r, char s){
	rank = r;
	suit = s;
}

void Card :: flip() {
	faceUp = !faceUp;
}

void Card::setCard(char r, char s)
{
	rank = r;
	suit = s;
}

void Card::display() {
	string a = "";
	if (rank == 'A')
		a += "A";
	else if (rank == 'K')
		a += "K";
	else if (rank == 'Q')
		a += "Q";
	else if (rank == 'J')
		a += "J";
	else if (rank == 'T')
		a += "T";
	else
		a += to_string((int)rank - 48);

	if (suit == 'S')
		a += "S";
	else if (suit == 'D')
		a += "D";
	else if (suit == 'H')
		a += "H";
	else if (suit == 'C')
		a += "C";
	cout << "<" << a << ">";
}

int Card::getValue() {
	if (rank == 'A')
		return 1;
	else if (rank == 'T' || rank == 'K' || rank == 'Q' || rank == 'J')
		return 10;
	else
		return (int)rank - 48;
}
