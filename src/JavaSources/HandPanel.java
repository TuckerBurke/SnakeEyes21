/**********************************************************
* Program Name  : HandPanel
* Author        : Tucker Burke
* Date          : May 3, 2015
* Course 		: CSC112 - 01W
* Description	: Display for a hand of cards
*
* Methods:
* -------
* HandPanel		- constructor
* HandPanel		- overloaded constructor
* refresh		- updates UI
* getPoints		- returns total points in hand
* getHandSize	- returns number of cards in hand
* getCardPanel	- returns card graphic for card at index
* flipDown		- calls method to flip card face down
* flipUp		- calls method to flip card face up
**********************************************************/

//for NetBeans packaging
package JavaSources;

//import statements
import java.awt.*;
import javax.swing.*;

public class HandPanel extends JPanel
{
	//instance constants
	final Color	FELT			= new Color(42, 83, 69);	//background rgb
	final Card	NULL_CARD		= null;						//blank card
	final int	MAX_HAND_SIZE	= 5;						//maximum hand size

	//instance variables
	private int			totalPoints;	//total points in hand
	private int			handSize;		//number of cards in hand
	private Hand		hand;			//instance of hand
	private Card[]		cards;			//array of cards duplicating hand
	private CardPanel[]	cardOut;		//array of panels

	/**********************************************************
	* Method Name   : HandPanel (constructor)
	* Author        : Tucker Burke
	* Date          : April 17, 2015
	* Course 		: CSC112 - 01W
	* Description	: Sets up the default hand panel
	*
	* BEGIN HandPanel (constructor)
	*	set layout format
	*	set panel size
	*	set panel color
	*	initialize array of cards
	*	initialize array of panels
	*	refresh display
	* END HandPanel
	**********************************************************/

	public HandPanel(int size)
	{
		//local constants

		//local variables

		/************************   Begin Constructor   *************************/

		//set layout format
		setLayout(new GridLayout(1, size));

		//set panel size
		setPreferredSize(new Dimension(500, 140));

		//set panel color
		setBackground(FELT);

		//initialize array of cards
		cards = new Card[MAX_HAND_SIZE];

		//initialize array of panels
		cardOut = new CardPanel[MAX_HAND_SIZE];

	}//END HandPanel (constructor)

	/**********************************************************
	* Method Name   : HandPanel (overloaded constructor)
	* Author        : Tucker Burke
	* Date          : April 17, 2015
	* Course 		: CSC112 - 01W
	* Description	: Sets up the panel which displays all cards in hand
	*
	* BEGIN HandPanel (constructor)
	*	set layout format
	*	set panel size
	*	set panel color
	*	store deck
	*	initialize array of cards
	*	initialize array of panels
	* END HandPanel
	**********************************************************/

	public HandPanel(int size, Hand passedHand)
	{
		//local constants

		//local variables

		/************************   Begin Constructor   *************************/

		//set layout format
		setLayout(new GridLayout(1, size));

		//set panel size
		setPreferredSize(new Dimension(500, 140));

		//set panel color
		setBackground(FELT);

		//store deck
		hand = passedHand;

		//initialize array of cards
		cards = new Card[MAX_HAND_SIZE];

		//initialize array of panels
		cardOut = new CardPanel[MAX_HAND_SIZE];

	}//END HandPanel (overloaded constructor)

	/**********************************************************
	* Method Name   : refresh
	* Author        : Tucker Burke
	* Date          : May 3, 2015
	* Course 		: CSC112 - 01W
	* Description	: refreshes hand data from hand instance and
	*				  updates the display
	*
	* BEGIN refresh
	*	clear cards from UI
	*	FOR(all hand slots)
	*		IF(there is a card
	*			retrieve card from instance
	*			save card to panel
	*			add the card panel to display
	*		END IF
	*	END FOR
	*	get number of cards in hand
	*	get points in hand
	* END refresh
	**********************************************************/

	public void refresh()
	{
		//local constants

		//local variables

		/************************   Begin refresh Method   *************************/

		//clear cards from UI
		removeAll();

		//FOR(all hand slots)
		for(int currentSlot = 0; currentSlot < MAX_HAND_SIZE; currentSlot++)
		{
			//IF(there is a card)
			if(hand.getCard(currentSlot)!=null)
			{
				//retrieve card from instance
				cards[currentSlot] = hand.getCard(currentSlot);

				//save card to panel
				cardOut[currentSlot] = new CardPanel(cards[currentSlot]);

				//add the card panel to display
				add(cardOut[currentSlot]);

			}//END IF

		}//END FOR

		//get number of cards in hand
		handSize = hand.getHandSize();

		//get points in hand
		totalPoints = hand.getPoints();

	}//END refresh

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
	* Method Name    : getHandSize
	* Author         : Tucker Burke
	* Date           : May 3, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns number of cards in hand
	*
	* BEGIN getPoints
	*	return hand size
	* END getPoints
	**********************************************************/

	public int getHandSize()
	{
		//local constants

		//local variables

		/********************   Start getHandSize method   ********************/

		//return hand size
		return handSize;

	}//END getHandSize

	/**********************************************************
	* Method Name    : getCardPanel
	* Author         : Tucker Burke
	* Date           : May 3, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns card graphic for card at index
	*
	* BEGIN getCardPanel
	*	return card panel at index
	* END getCardPanel
	**********************************************************/

	public CardPanel getCardPanel(int index)
	{
		//local constants

		//local variables

		/********************   Start getCardPanel method   ********************/

		//return card panel at index
		return cardOut[index];

	}//END getCardPanel

	/**********************************************************
	* Method Name    : flipDown
	* Author         : Tucker Burke
	* Date           : May 4, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : calls method to flip card face down
	*
	* BEGIN flipDown
	*	call method to set card face down
	* END flipDown
	**********************************************************/

	public void flipDown(int slot)
	{
		//local constants

		//local variables

		/********************   Start flipDown method   ********************/

		//call method to set card face down
		cardOut[slot].setDown();

	}//END flipDown

	/**********************************************************
	* Method Name    : flipUp
	* Author         : Tucker Burke
	* Date           : May 8, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : calls method to flip card face up
	*
	* BEGIN flipUp
	*	call method to set card face up
	* END flipUp
	**********************************************************/

	public void flipUp(int slot)
	{
		//local constants

		//local variables

		/********************   Start flipUp method   ********************/

		//call method to set card face up
		cardOut[slot].setUp();

	}//END flipUp

}//END HandPanel