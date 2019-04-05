/*
Sukriti Agarwal
016280171
CECS 282-05
Prog 1 - Solitaire Prime
Due- Sept 20,2018
*/

#include "Deck.h"
#include <iostream>
#include <string>
#include <time.h>
#include <cstdlib>
#include <stdlib.h>

using namespace std;

Deck::Deck()
{
	int count = 0;
	char Suits[] = { 'S','H','D','C' };
	char Ranks[] = { 'A', '2', '3', '4','5','6','7','8','9','T','J','Q','K' };
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 13; j++)
		{
			storage[count++].setCard(Ranks[j], Suits[i]);
		}
	}
}

Card Deck::deal()
{
	if (top < 52) {
		return storage[top++];
	}
	else
		return Card();
}

void Deck::refreshDeck()
{
	char rank[] = { 'A','2','3','4','5','6','7','8','9','T','J','Q','K' };
	char suit[] = { 'S','H','D','C' };
	int index = 0;
	top = 0;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 13; j++) {
			storage[index++].setCard(rank[j], suit[i]);
		}
	}
}

void Deck::shuffle()
{
	srand(time(0));
	for (int i = 0; i < 1000; i++)
	{
		int x = rand() % 52;
		int y = rand() % 52;
		Card temp = storage[x];
		storage[x] = storage[y];
		storage[y] = temp;
	}
	top = 0; 
}

int Deck::cardsLeft() {
	return 52 - top;
}

void Deck::display() {
	index = 0;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 13; j++) {
			storage[index++].display();
			cout << "   ";
		}
		cout << "\n"; 
	}
}
