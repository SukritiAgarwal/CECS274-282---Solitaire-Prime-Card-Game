#ifndef CARD_H
#define CARD_H
class Card{
private:
	char rank;
	char suit;
	bool faceUp;

public:
	Card();
	Card(char r, char s);
	void flip();
	void setCard(char r, char s);
	void display();
	int getValue();
};
#endif
