#ifndef DECK_H
#define DECK_H
#include "Card.h"
class Deck{
private:
	Card storage[52];
	int top = 0;
	int index;
	int size;

public:
	Deck();
	Card deal();
	void refreshDeck();
	void shuffle();
	int cardsLeft();
	void display();
};
#endif
