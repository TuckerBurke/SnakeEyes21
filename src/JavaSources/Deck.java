/**********************************************************
* Title	      	 : Deck
* Author         : Tucker Burke
* Date           : May 2, 2015
* Course/Section : CSC112, 002W
* Description    : Deck of 52 cards modified for final project
*
* Methods:
* -------------
* Deck			- constructor creates standard 52 card deck
* populate		- generates the 52 card deck
* checkEmpty	- determines if the deck is empty
* parseSuit		- returns string equiv of suit
* parseFace		- returns string equiv of face
* shuffle		- shuffles the deck
* draw			- returns card from top of deck and removes it
* getRemaining	- returns number of cards remaining in deck
* toString		- displays the entire deck
**********************************************************/

//for NetBeans packaging
package JavaSources;

//import statements
import java.util.Random;

public class Deck
{
	//class constants

	//class variables
	private Card 	head;				//first card of the deck
	private Card 	tail;				//last card of the deck
	private	Card 	first;				//first card of operation
	private	Card 	current;			//card currently being processed
	private Card 	previous	= null;	//card previously processed
	private int		cardsLeft	= 0;	//cards remaining in deck

	/**********************************************************
	* Method Name    : Deck
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : creates an empty deck
	*
	* BEGIN Constructor
	* 	initialize head to null
	* END Constructor
	**********************************************************/

	public Deck()
	{
		//local constants

		//local variables

		/********************   Start constructor method   ********************/

		//initialize head to null
		head = null;

	}//END Deck

	/**********************************************************
	* Method Name    : populate
	* Author         : Tucker Burke
	* Date           : March 21, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : populates empty linked list with standard
	*				   52 card deck
	*
	* BEGIN populate
	*	FOR (each suit)
	*		FOR (each possible face)
	*			create new card
	*			increment cards left
	*			store new card as current
	*			set card suit as integer
	*			set card suit as string
	*			set card face as integer
	*			set card face as string
	*			IF(ace)
	*				set point value to 11
	*			ELSE IF(standard card)
	*				set point value equal to card face
	*			ELSE(face card)
	*				set point value to 10
	*			END IF
	*			set card unique ID
	*			increment ID count
	*			IF(deck is empty)
	*				set new card as head
	*			ELSE IF(not the last card in deck)
	*				point previous card to this one
	*			ELSE(must be last card)
	*				point previous card to this one
	*				set new card as tail
	*			END IF
	*			store card as previous
	*		END FOR(each face)
	*	END FOR(each suit)
	* END populate
	**********************************************************/

	public void populate()
	{
		//local constants
		final int TOTAL_SUITS 	= 4;	//total number of suits
		final int TOTAL_FACES	= 13;	//total possible faces
		final int LAST_CARD		= 53;	//id Count out of range
		final int ACE_POINTS	= 11;	//ace's point value
		final int FACE_POINTS	= 10;	//face card point value

		//local variables
		int		idCount	= 1;		//tabulates card unique ID

		/********************   Start populate method   ********************/

		//FOR (each suit)
		for(int currentSuit = 0; currentSuit < TOTAL_SUITS; currentSuit++)
		{
			//FOR (each possible face)
			for(int currentFace = 1; currentFace <= TOTAL_FACES; currentFace++)
			{
				//create new card
				Card newCard = new Card();

				//increment cards left
				cardsLeft++;

				//store new card as current
				current = newCard;

				//set card suit as integer
				current.setSuitInt(currentSuit);

				//set card suit as string
				current.setSuitString(parseSuit(currentSuit));

				//set card face as integer
				current.setFaceInt(currentFace);

				//set card face as string
				current.setFaceString(parseFace(currentFace));

				//IF(ace)
				if(currentFace == 1)
				{
					//set point value to 11
					current.setFaceValue(ACE_POINTS);
				}
				//ELSE IF(standard card)
				else if(currentFace < 11)
				{
					//set point value equal to card face
					current.setFaceValue(currentFace);
				}
				//ELSE(face card)
				else
				{
					//set point value to 10
					current.setFaceValue(FACE_POINTS);

				}//END IF

				//set card unique ID
				current.setID(idCount);

				//increment ID count
				idCount++;

				//IF (deck is empty)
				if(head == null)
				{
					//set new card as head
					head = current;
				}
				//ELSE IF (not the last card in deck)
				else if(idCount != LAST_CARD)
				{
					//point previous card to this one
					previous.setNext(current);
				}
				//ELSE (must be last card)
				else
				{
					//point previous card to this one
					previous.setNext(current);

					//set new card as tail
					tail = current;

				}//END IF

				//store card as previous
				previous = current;

			}//END FOR (each face)

		}//END FOR (each suit)

	}//END populate

	/**********************************************************
	* Method Name    : checkEmpty
	* Author         : Tucker Burke
	* Date           : March 21, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : checks to see if the deck is empty
	*
	* BEGIN checkEmpty
	*	IF (deck is empty)
	*		set empty to true
	*	ELSE (deck is not empty)
	*		set empty to false
	*	END IF
	*	return empty
	* END checkEmpty
	**********************************************************/

	public boolean checkEmpty()
	{
		//local constants

		//local variables
		boolean empty;

		/********************   Start checkEmpty method   ********************/

		//IF (deck is empty)
		if(head == null)
		{
			//set empty to true
			empty = true;
		}
		//ELSE (deck is not empty)
		else
		{
			//set empty to false
			empty = false;

		}//END IF

		//return empty
		return empty;

	}//END checkEmpty

	/**********************************************************
	* Method Name    : parseSuit
	* Author         : Tucker Burke
	* Date           : March 21, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns string equiv of suit
	*
	* BEGIN parseSuit(int passedSuit)
	* 	IF(parameter is a heart)
	*		set string variable to heart
	*	ELSE IF(parameter is a diamond)
	*		set string variable to diamond
	*	ELSE IF(parameter is a spade)
	*		set string variable to spade
	*	ELSE(parameter must be a club)
	*		set string variable to club
	*	END IF
	*	return string variable
	* END parseSuit
	**********************************************************/

	private String parseSuit(int passedSuit)
	{
		//local constants
		final int HEART		= 0;
		final int DIAMOND	= 1;
		final int SPADE		= 2;

		//local variables
		String	suitString;			//stores correlating suit

		/********************   Start parseSuit method   ********************/

	 	//IF(parameter is a heart)
	 	if(passedSuit == HEART)
	 	{
			//set string variable to heart
			suitString = "\u2665";
		}
		//ELSE IF(parameter is a diamond)
		else if(passedSuit == DIAMOND)
		{
			//set string variable to diamond
			suitString = "\u2666";
		}
		//ELSE IF(parameter is a spade)
		else if(passedSuit == SPADE)
		{
			//set string variable to spade
			suitString = "\u2660";
		}
		//ELSE(parameter must be a club)
		else
		{
			//set string variable to club
			suitString = "\u2663";

		}//END IF

		//return string variable
		return suitString;

	}//END parseSuit

	/**********************************************************
	* Method Name    : parseFace
	* Author         : Tucker Burke
	* Date           : March 21, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns string equiv of face
	*
	* BEGIN parseFace(int passedFace)
	*	IF(face is 1)
	*		set string to ace
	*	ELSE IF(face is 2)
	*		set string to two
	*	ELSE IF(face is 3)
	*		set string to three
	*	ELSE IF(face is 4)
	*		set string to four
	*	ELSE IF(face is 5)
	*		set string to five
	*	ELSE IF(face is 6)
	*		set string to six
	*	ELSE IF(face is 7)
	*		set string to seven
	*	ELSE IF(face is 8)
	*		set string to eight
	*	ELSE IF(face is 9)
	*		set string to nine
	*	ELSE IF(face is 10)
	*		set string to ten
	*	ELSE IF(face is 11)
	*		set string to jack
	*	ELSE IF(face is 12)
	*		set string to queen
	*	ELSE IF(face is 13)
	*		set string to king
	*	return string variable
	* END parseFace
	**********************************************************/

	private String parseFace(int passedFace)
	{
		//local constants


		//local variables
		String	faceString;		//stores correlating face

		/********************   Start parseFace method   ********************/

		//IF(face is 1)
		if(passedFace == 1)
		{
			//set string to ace
			faceString = "A";
		}
		//ELSE IF(face is 2)
		else if(passedFace == 2)
		{
			//set string to two
			faceString = "2";
		}
		//ELSE IF(face is 3)
		else if(passedFace == 3)
		{
			//set string to three
			faceString = "3";
		}
		//ELSE IF(face is 4)
		else if(passedFace == 4)
		{
			//set string to four
			faceString = "4";
		}
		//ELSE IF(face is 5)
		else if(passedFace == 5)
		{
			//set string to five
			faceString = "5";
		}
		//ELSE IF(face is 6)
		else if(passedFace == 6)
		{
			//set string to six
			faceString = "6";
		}
		//ELSE IF(face is 7)
		else if(passedFace == 7)
		{
			//set string to seven
			faceString = "7";
		}
		//ELSE IF(face is 8)
		else if(passedFace == 8)
		{
			//set string to eight
			faceString = "8";
		}
		//ELSE IF(face is 9)
		else if(passedFace == 9)
		{
			//set string to nine
			faceString = "9";
		}
		//ELSE IF(face is 10)
		else if(passedFace == 10)
		{
			//set string to ten
			faceString = "10";
		}
		//ELSE IF(face is 11)
		else if(passedFace == 11)
		{
			//set string to jack
			faceString = "J";
		}
		//ELSE IF(face is 12)
		else if(passedFace == 12)
		{
			//set string to queen
			faceString = "Q";
		}
		//ELSE IF(face is 13)
		else
		{
			//set string to king
			faceString = "K";
		}

		//return string variable
		return faceString;

	}//END parseFace

	/**********************************************************
	* Method Name    : shuffle
	* Author         : Tucker Burke
	* Date           : May 2, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : shuffles deck using temporary array
	*
	* BEGIN shuffle
	*	instantiate array length 52
	*	keep track of head
	*	FOR (each card in deck)
	*		generate random number
	*		WHILE(card already stored at random index)
	*			generate random number
	*		END WHILE
	*		insert card at random index
	*	END FOR
	* 	set first card as head
	*	set last card as tail
	*	FOR(remaining cards in array)
	*		update links
	*	END FOR
	* END shuffle
	**********************************************************/

	public void shuffle()
	{
		//local constants
		final int LENGTH	= 52;	//size of temp array and random gen
		final int FIRST		= 0;	//array index of first card
		final int LAST		= 51;	//array index of last card

		//local variables
		Card[] 	rack;	//temporary card storage array
		int		slot;	//stores random index

		Random 	gen = new Random();	//random number generator


		/********************   Start shuffle Method   ********************/

		//instatiate array length 52
		rack = new Card[LENGTH];

		//keep track of head
		first = head;

		//FOR(each card in deck)
		for(current = first; current != null; current = current.getNext())
		{
			//generate random number
			slot = gen.nextInt(LENGTH);

			//WHILE(card already stored at random index)
			while(rack[slot] != null)
			{
				//generate random number
				slot = gen.nextInt(LENGTH);

			}//END WHILE

			//insert card at random index
			rack[slot] = current;

		}//END FOR

		//set first card as head
		head = rack[FIRST];

		//set last card as tail
		tail = rack[LAST];
		tail.setNext(null);

		//FOR(remaining cards in array)
		for(int currentSlot = 0; currentSlot < LENGTH - 1; currentSlot++)
		{
			//update links
			current = rack[currentSlot];
			current.setNext(rack[currentSlot + 1]);

		}//END FOR

	}//END shuffle

	/**********************************************************
	* Method Name    : draw
	* Author         : Tucker Burke
	* Date           : May 2, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns card from top of deck and removes it
	*
	* BEGIN draw
	*	store top card
	*	remove top card from deck
	*	decrement cards remaining
	*	return drawn card
	* END draw
	**********************************************************/

	public Card draw()
	{
		//local constants

		//local variables

		/********************   Start draw Method   ********************/

		//store top card
		current = head;

		//remove top card from deck
		head = current.getNext();

		//decrement cards remaining
		cardsLeft--;

		//return drawn card
		return current;

	}//END draw

	/**********************************************************
	* Method Name    : getRemaining
	* Author         : Tucker Burke
	* Date           : May 2, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns number of cards remaining in deck
	*
	* BEGIN getRemaining
	*	return quantity in deck
	* END getRemaining
	**********************************************************/

	public int getRemaining()
	{
		//local constants

		//local variables

		/********************   Start getRemaining Method   ********************/

		//return quantity in deck
		return cardsLeft;

	}//END getRemaining

	/**********************************************************
	* Method Name    : toString
	* Author         : Tucker Burke
	* Date           : March 21, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns deck data as a string
	*
	* BEGIN toString()
	*	store deck heading
	*	keep track of head
	*	FOR (each card in deck)
	*		store each card
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

		//keep track of head
		first = head;

		//FOR(each card in deck)
		for(current = first; current != null; current = current.getNext())
		{
			//store each card
			output += current.toString() + "\n";

		}//END FOR

		//return concatenated string
		return output;

	}//END toString

}//END Deck