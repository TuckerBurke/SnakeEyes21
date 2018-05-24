/**********************************************************
* Title	      	 : Hand
* Author         : Tucker Burke
* Date           : May 2, 2015
* Course/Section : CSC112, 002W
* Description    : Hand of cards for game play
*
* Methods:
* -------------
* Hand			- constructor creates a new hand of null cards
* draw			- draws a card from deck and adds it to hand
* getHandSize	- returns number of cards in hand
* getCard		- returns the card object at given slot
* getPoints		- returns total points
* toString		- returns hand data as string
**********************************************************/

//for NetBeans packaging
package JavaSources;

public class Hand
{
	//class constants

	//class variables
	private Card[] 	hand;			//array of cards
	private int 	cardsHeld;		//number of cards in hand
	private int		totalPoints;	//total points in hand

	/**********************************************************
	* Method Name    : Hand
	* Author         : Tucker Burke
	* Date           : May 3, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : creates an empty hand
	*
	* BEGIN Constructor
	* 	initialize hand array
	*	initialize number of cards held
	*	initialize total points
	* END Constructor
	**********************************************************/

	public Hand(int maxHandSize)
	{
		//local constants

		//local variables

		/********************   Start constructor method   ********************/

		//initialize hand array
		hand = new Card[maxHandSize];

		//initialize number of cards held
		cardsHeld = 0;

		//initialize total points
		totalPoints = 0;

	}//END Hand

	/**********************************************************
	* Method Name    : draw
	* Author         : Tucker Burke
	* Date           : May 3, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : draws a card from deck and adds it to hand
	*
	* BEGIN draw
	*	draw card and insert in array
	*	calculate points
	*	increment hand size
	*	return total points
	* END draw
	**********************************************************/

	public int draw(Deck deck)
	{
		//local constants

		//local variables

		/********************   Start draw method   ********************/

		//draw card and insert in array
		hand[cardsHeld] = deck.draw();

		//calculate points
		totalPoints += hand[cardsHeld].getFaceValue();

		//increment hand size
		cardsHeld++;

		//return total points
		return totalPoints;

	}//END draw

	/**********************************************************
	* Method Name    : getHandSize
	* Author         : Tucker Burke
	* Date           : May 3, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns the number of cards in hand
	*
	* BEGIN getHandSize
	*	return number of cards held
	* END getHandSize
	**********************************************************/

	public int getHandSize()
	{
		//local constants

		//local variables

		/********************   Start getHandSize method   ********************/

		//return number of cards held
		return cardsHeld;

	}//END getHandSize

	/**********************************************************
	* Method Name    : getCard
	* Author         : Tucker Burke
	* Date           : May 3, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns the card at given slot
	*
	* BEGIN getCard
	*	return card at slot
	* END getCard
	**********************************************************/

	public Card getCard(int slot)
	{
		//local constants

		//local variables

		/********************   Start getCard method   ********************/

		//return card at slot
		return hand[slot];

	}//END getCard

	/**********************************************************
	* Method Name    : getPoints
	* Author         : Tucker Burke
	* Date           : May 3, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns total points in hand
	*
	* BEGIN getPoints
	*	return total points
	* END getPoints
	**********************************************************/

	public int getPoints()
	{
		//local constants

		//local variables

		/********************   Start getPoints method   ********************/

		//return totalPoints
		return totalPoints;

	}//END getPoints

	/**********************************************************
	* Method Name    : toString
	* Author         : Tucker Burke
	* Date           : May 3, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns hand data as a string
	*
	* BEGIN toString()
	*	store deck heading
	*	FOR(each card in hand)
	*		store each card to output string
	*	END FOR
	* 	return concatenated string
	* END toString
	**********************************************************/

	public String toString()
	{
		//local constants
		final int GUTTER_FACE 	= 7;
		final int GUTTER_SUIT 	= 9;
		final int GUTTER_ID		= 4;

		//local variables
		String output;		//stores concatenated string

		/********************   Start toString Method   ********************/

		//store deck heading
		output = FreqUsed.center(FreqUsed.columnLeft(GUTTER_FACE, "FACE#") +
								 FreqUsed.columnLeft(GUTTER_FACE, "SUIT#") +
								 FreqUsed.columnLeft(GUTTER_FACE, "FACE") +
								 FreqUsed.columnLeft(GUTTER_SUIT, "SUIT") +
								 FreqUsed.columnLeft(GUTTER_ID, "ID")) + "\n";
		output += FreqUsed.center("-----------------------------------") + "\n";

		//FOR(each card in hand)
		for(int currentCard = 0; currentCard < cardsHeld; currentCard++)
		{
			//store each card to output string
			output += hand[currentCard].toString() + "\n";

		}//END FOR

		//return concatenated string
		return output;

	}//END toString

}//END Hand