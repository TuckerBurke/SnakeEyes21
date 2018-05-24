/**********************************************************
* Program Name  : BodyPanel
* Author        : Tucker Burke
* Date          : May 3, 2015
* Course 		: CSC112 - 01W
* Description	: BorderLayout for 21 card game
*
* Classes:
* -------
* MultiButton	- captures button clicks and performs action
*				- contains actionsPerformed method
* Methods:
* -------
* BodyPanel 	- constructor
* aI			- dealer artificial intelligence logic
* continueGame	- starts new hand using same deck
* addDeck		- adds and shuffles a new deck
**********************************************************/

//for NetBeans packaging
package JavaSources;

//import statements
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BodyPanel extends JPanel
{
	//instance constants
	final Color	FELT			= new Color(42, 83, 69);	//background rgb
	final Color PANEL			= new Color(216,205, 174);	//panel rgb
	final int 	HAND_START		= 2;	//initial hand size
	final int	MAX_HAND_SIZE 	= 5;	//maximum hand size
	final int 	TARGET_SCORE	= 21;	//game's target score
	final int	SNAKE_EYES		= 22;	//point value of snake eyes

	//instance variables
	private JPanel	 	table;			//center panel containing deck, menus, and game results
	private JPanel	 	tableLeft;		//panel containing deck display
	private JPanel	 	tableMid;		//panel containing main menus
	private JPanel	 	tableRight;		//panel containing in game menus and results
	private HandPanel 	dealer;			//top panel containing dealer's hand
	private HandPanel	player;			//bottom panel containg player's hand
	private RulesPanel	rules;			//left panel which displays game rules
	private InfoPanel	info;			//right panel which displays current game data
	private JButton		newGame;		//new game button
	private JButton		contGame;		//continue button
	private JButton		hit;			//hit button
	private JButton		stay;			//stay button
	private Deck		gameDeck;		//deck for game
	private Hand		playerHand;		//player's hand
	private Hand		dealerHand;		//dealer's hand
	private JLabel		winLoseText;	//game over notification
	private JLabel		messageText;	//game message text
	private JLabel		auxMessageText;	//auxillary message
	private Card	  	blankCard;		//blank card for deck graphic
	private CardPanel 	deckGraphic;	//card panel representing a deck graphically

	/**********************************************************
	* Method Name   : BodyPanel (constructor)
	* Author        : Tucker Burke
	* Date          : May 3, 2015
	* Course 		: CSC112- 01W
	* Description	: Sets up sub panels for general game layout
	*
	* BEGIN BodyPanel (constructor)
	*	create temp deck
	*	create deck graphic
	*	initialize central panels
	*	hide pre game panels
	*	initialize external panels
	*	initialize notification labels
	*	initialize buttons
	*	set button color
	*	set button borders
	*	add button listeners
	*	set button sizes
	*	set layout formats
	*	set panel colors
	*	set panel borders
	*	set panel sizes
	*	add components to left panel
	*	add components to middle panel
	*	add components to right panel
	*	add subpanels to table
	*	add panels to frame
	* END BodyPanel
	**********************************************************/

	public BodyPanel()
	{
		//local constants

		//local variables
		JPanel		blankPanel	= new JPanel();	//blank panel for deck layout
		JPanel		blankPanel2	= new JPanel(); //blank panel for menu layout
		JPanel		blankPanel3	= new JPanel(); //blank panel for menu layout
		JPanel		blankPanel4	= new JPanel(); //blank panel for notification layout
		JPanel		blankPanel5	= new JPanel(); //blank panel for notification layout

		/************************   Begin Constructor   *************************/

		//create temp deck
		gameDeck = new Deck();
		gameDeck.populate();

		//create deck graphic
		blankCard	= new Card();
		deckGraphic	= new CardPanel(blankCard);
		deckGraphic.setDown();

		//initialize central panels
		table	 	= new JPanel();
		tableLeft 	= new JPanel();
		tableMid 	= new JPanel();
		tableRight 	= new JPanel();

		//hide pre game panels
		tableLeft.setVisible(false);
		tableRight.setVisible(false);

		//initialize external panels
		dealer 	= new HandPanel(MAX_HAND_SIZE);
		player 	= new HandPanel(MAX_HAND_SIZE);
		rules 	= new RulesPanel();
		info 	= new InfoPanel();

		//initialize notification labels
		winLoseText = new JLabel();
		winLoseText.setFont(new Font("Card Characters", Font.PLAIN, 14));
		winLoseText.setForeground(Color.WHITE);
		winLoseText.setHorizontalAlignment(JLabel.CENTER);
		messageText = new JLabel("Good Luck");
		messageText.setForeground(Color.WHITE);
		messageText.setHorizontalAlignment(JLabel.CENTER);
		auxMessageText = new JLabel();
		auxMessageText.setForeground(Color.WHITE);
		auxMessageText.setHorizontalAlignment(JLabel.CENTER);

		//initialize buttons
		newGame		= new JButton("New Deck");
		contGame	= new JButton("Continue");
		hit			= new JButton("Hit");
		stay		= new JButton("Stay");

		//set button color
		newGame.setBackground(PANEL);
		contGame.setBackground(PANEL);
		hit.setBackground(PANEL);
		stay.setBackground(PANEL);

		//set button borders
		newGame.setBorder(BorderFactory.createRaisedBevelBorder());
		contGame.setBorder(BorderFactory.createRaisedBevelBorder());
		hit.setBorder(BorderFactory.createRaisedBevelBorder());
		stay.setBorder(BorderFactory.createRaisedBevelBorder());

		//add button listeners
		newGame.addActionListener(new MultiButton());
		contGame.addActionListener(new MultiButton());
		hit.addActionListener(new MultiButton());
		stay.addActionListener(new MultiButton());

		//set button sizes
		newGame.setPreferredSize(new Dimension(100, 40));
		contGame.setPreferredSize(new Dimension(100, 40));
		hit.setPreferredSize(new Dimension(100, 40));
		stay.setPreferredSize(new Dimension(100, 40));

		//set layout formats
		table.setLayout(new GridLayout(1, 3));
		tableLeft.setLayout(new BorderLayout());
		tableMid.setLayout(new GridLayout(6, 1));
		tableRight.setLayout(new GridLayout(5,1));
		setLayout(new BorderLayout());

		//set panel colors
		blankPanel.setBackground(FELT);
		blankPanel2.setBackground(FELT);
		blankPanel3.setBackground(FELT);
		blankPanel4.setBackground(FELT);
		blankPanel5.setBackground(FELT);
		table.setBackground(FELT);
		tableLeft.setBackground(FELT);
		tableMid.setBackground(FELT);
		tableRight.setBackground(FELT);

		//set panel borders
		tableMid.setBorder(BorderFactory.createLineBorder(FELT, 5));
		tableRight.setBorder(BorderFactory.createLineBorder(FELT, 5));

		//set panel sizes
		table.setPreferredSize(new Dimension(300, 220));
		tableLeft.setPreferredSize(new Dimension(100, 220));
		blankPanel.setPreferredSize(new Dimension(100, 40));
		tableMid.setPreferredSize(new Dimension(100, 220));
		tableRight.setPreferredSize(new Dimension(100, 220));
		dealer.setPreferredSize(new Dimension(500, 140));
		player.setPreferredSize(new Dimension(500, 140));
		rules.setPreferredSize(new Dimension(100, 220));
		info.setPreferredSize(new Dimension(100, 220));
		setPreferredSize(new Dimension(500, 500));

		//add components to left panel
		tableLeft.add(blankPanel, BorderLayout.NORTH);
		tableLeft.add(deckGraphic, BorderLayout.CENTER);

		//add components to middle panel
		tableMid.add(blankPanel2);
		tableMid.add(blankPanel3);
		tableMid.add(newGame);

		//add components to right panel
		tableRight.add(blankPanel4);
		tableRight.add(winLoseText);
		tableRight.add(messageText);
		tableRight.add(auxMessageText);
		tableRight.add(blankPanel5);

		//add subpanels to table
		table.add(tableLeft);
		table.add(tableMid);
		table.add(tableRight);

		//add panels to frame
		add(table,	BorderLayout.CENTER);
		add(dealer, BorderLayout.NORTH);
		add(player, BorderLayout.SOUTH);
		add(info, 	BorderLayout.EAST);
		add(rules, BorderLayout.WEST);

	}//END BodyPanel (constructor)

	/**********************************************************
	* Method Name   : aI
	* Author        : Tucker Burke
	* Date          : May 8, 2015
	* Course 		: CSC112 - 01W
	* Description	: dealer artificial intelligents logic
	*
	* BEGIN aI
	*	face dealer card up
	*	IF(dealer got snake eyes)
	*		issue win notification
	*		issue game message
	*		issue snake eyes notification
	*		show game menu
	*		refresh UI
	*	ELSE IF(dealer got black jack)
	*		issue loss notification
	*		issue game message
	*		issue black jack notification
	*		show game menu
	*		refresh UI
	*	ELSE IF(dealer beats player)
	*		issue loss notification
	*		issue game message
	*		show game menu
	*		refresh UI
	*	ELSE IF(dealer busts)
	*		issue win notification
	*		issue game message
	*		show game menu
	*		refresh UI
	*	ELSE(dealer needs to draw)
	*		IF(deck is empty)
	*			add a new deck
	*		END IF
	*		draw card
	*		update cards in deck
	*		recursively trigger ai
	* END aI
	**********************************************************/

	public void aI()
	{
		//local constants

		//local variables

		/************************   Begin aI Method   *************************/

		//face dealer card up
		dealer.flipUp(0);

		//IF(dealer got snake eyes)
		if(dealer.getPoints() == SNAKE_EYES && dealer.getHandSize() == 2)
		{
			//issue win notification
			winLoseText.setText("You Win");

			//issue game message
			messageText.setText("Dealer Bust");

			//issue snake eyes notification
			auxMessageText.setText("SNAKE EYES!");

			//show game menu
			tableMid.add(newGame);
			tableMid.add(contGame);

			//refresh UI
			tableMid.repaint();
		}
		//ELSE IF(dealer got black jack)
		else if(dealer.getPoints() == TARGET_SCORE && dealer.getHandSize() == 2)
		{
			//issue loss notification
			winLoseText.setText("You Lose");

			//issue game message
			messageText.setText("Dealer: " + dealer.getPoints());

			//issue black jack notification
			auxMessageText.setText("BLACK JACK!");

			//show game menu
			tableMid.add(newGame);
			tableMid.add(contGame);

			//refresh UI
			tableMid.repaint();
		}
		//ELSE IF(dealer beats player)
		else if(dealer.getPoints() >= player.getPoints() && dealer.getPoints() < TARGET_SCORE +1)
		{
			//issue loss notification
			winLoseText.setText("You Lose");

			//issue game message
			messageText.setText("Dealer: " + dealer.getPoints());

			//show game menu
			tableMid.add(newGame);
			tableMid.add(contGame);

			//refresh UI
			tableMid.repaint();
		}
		//ELSE IF(dealer busts)
		else if(dealer.getPoints() > TARGET_SCORE )
		{
			//issue win notification
			winLoseText.setText("You Win");

			//issue game message
			messageText.setText("Dealer: " + dealer.getPoints());

			//show game menu
			tableMid.add(newGame);
			tableMid.add(contGame);

			//refresh UI
			tableMid.repaint();
		}
		//ELSE(dealer needs to draw)
		else
		{
			//IF(deck is empty)
			if(gameDeck.getRemaining() == 0)
			{
				//add a new deck
				addDeck();

			}//END IF

			//draw card
			dealerHand.draw(gameDeck);
			dealer.refresh();

			//update cards in deck
			info.setDeckResult(gameDeck.getRemaining());

			//recursively trigger ai
			aI();

		}//END IF

	}//END aI

	/**********************************************************
	* Method Name   : continueGame
	* Author        : Tucker Burke
	* Date          : May 8, 2015
	* Course 		: CSC112 - 01W
	* Description	: starts new hand using same deck
	*
	* BEGIN continueGame
	*	create new hands
	*	create new hand panels
	*	create new info panel
	*	set panel visibility
	*	set button visibility
	*	refresh UI
	*	set game messages
	*	and new game panels
	*	deal player's first card
	*	update info panel
	*	IF(deck empty)
	*		add a new deck
	*	END IF
	*	dealer draws first card
	*	update cards in deck
	*	dealer card face down
	*	IF(deck is empty)
	*		add new deck
	*	END IF
	*	deal player's second card
	*	update info panel
	*	IF(deck is empty)
	*		add new deck
	*	END IF
	*	dealer draws second card
	*	update cards in deck
	*	dealer card face down
	*	IF(player gets snake eyes)
	*		issue game message
	*		issue snake eyes notification
	*		show game menu
	*	ELSE IF(player got black jack)
	*		issue black jack notification
	*		disable hit / stay
	*		trigger AI
	*	END IF
	* END continueGame
	**********************************************************/

	public void continueGame()
	{
		//local constants

		//local variables

		/************************   Begin continueGame Method   *************************/

		//create new hands
		playerHand	= new Hand(MAX_HAND_SIZE);
		dealerHand	= new Hand(MAX_HAND_SIZE);

		//create new hand panels
		player 	= new HandPanel(MAX_HAND_SIZE, playerHand);
		dealer 	= new HandPanel(MAX_HAND_SIZE, dealerHand);

		//create new info panel
		info 	= new InfoPanel(player, dealer, gameDeck);

		//set panel visibility
		tableLeft.setVisible(true);
		tableRight.setVisible(true);

		//set button visibility
		tableMid.remove(newGame);
		tableMid.remove(contGame);
		tableMid.add(hit);
		tableMid.add(stay);

		//refresh UI
		tableMid.repaint();

		//set game messages
		winLoseText.setText("");
		messageText.setText("Good Luck");
		auxMessageText.setText("");

		//and new game panels
		add(dealer, BorderLayout.NORTH);
		add(player, BorderLayout.SOUTH);
		add(info, 	BorderLayout.EAST);

		//deal player's first card
		playerHand.draw(gameDeck);
		player.refresh();

		//update info panel
		info.setDeckResult(gameDeck.getRemaining());
		info.setHeldResult(player.getHandSize());
		info.setPointsResult(player.getPoints());

		//IF(deck empty)
		if(gameDeck.getRemaining() == 0)
		{
			//add a new deck
			addDeck();

		}//END IF

		//dealer draws first card
		dealerHand.draw(gameDeck);
		dealer.refresh();

		//update cards in deck
		info.setDeckResult(gameDeck.getRemaining());

		//dealer card face down
		dealer.flipDown(0);

		//IF(deck is empty)
		if(gameDeck.getRemaining() == 0)
		{
			//add new deck
			addDeck();

		}//END IF

		//deal player's second card
		playerHand.draw(gameDeck);
		player.refresh();

		//update info panel
		info.setDeckResult(gameDeck.getRemaining());
		info.setHeldResult(player.getHandSize());
		info.setPointsResult(player.getPoints());

		//IF(deck is empty)
		if(gameDeck.getRemaining() == 0)
		{
			//add new deck
			addDeck();

		}//END IF

		//dealer draws second card
		dealerHand.draw(gameDeck);
		dealer.refresh();

		//update cards in deck
		info.setDeckResult(gameDeck.getRemaining());

		//dealer card face down
		dealer.flipDown(0);

		//IF(player gets snake eyes)
		if(player.getPoints() == SNAKE_EYES)
		{
			//issue loss notification
			winLoseText.setText("You Lose");

			//issue game message
			messageText.setText("Bust");

			//issue snake eyes notification
			auxMessageText.setText("SNAKE EYES!");

			//show game menu
			tableMid.remove(hit);
			tableMid.remove(stay);
			tableMid.add(newGame);
			tableMid.add(contGame);
		}
		//ELSE IF(player got black jack)
		else if(player.getPoints() == TARGET_SCORE)
		{
			//issue black jack notification
			auxMessageText.setText("BLACK JACK!");

			//disable hit / stay
			tableMid.remove(hit);
			tableMid.remove(stay);

			//trigger AI
			aI();

		}//END IF

	}//END continueGame

	/**********************************************************
	* Method Name   : addDeck
	* Author        : Tucker Burke
	* Date          : May 8, 2015
	* Course 		: CSC112 - 01W
	* Description	: adds and shuffles a new deck
	*
	* BEGIN addDeck
	*	create a new deck
	*	add cards to deck
	*	shuffle deck
	*	issue notification
	* END addDeck
	**********************************************************/

	public void addDeck()
	{
		//local constants

		//local variables

		/************************   Begin addDeck Method   *************************/

		//create a new deck
		gameDeck = new Deck();

		//add cards to deck
		gameDeck.populate();

		//shuffle deck
		gameDeck.shuffle();

		//issue notification
		messageText.setText("Deck Added");

	}//END addDeck

	/**********************************************************
	* Class Name    : MultiButton
	* Author        : Tucker Burke
	* Date          : May 4, 2015
	* Course 		: CSC1112 - 01W
	* Description	: Captures button clicks and performs action
	*
	* Methods:
	* -------
	* actionPerformed - actions performed when button are clicked
	**********************************************************/

	private class MultiButton implements ActionListener
	{
		/**********************************************************
		* Method Name   : actionPerformed
		* Author        : Tucker Burke
		* Date          : May 4, 2015
		* Course 		: CSC112 - 01W
		* Description	: Actions performed when buttons are clicked
		*
		* BEGIN actionPerformed
		*	IF(deck is empty)
		*		add a deck
		*	ELSE(deck NOT empty)
		*		IF(new game pressed)
		*			create new deck
		*			add cards to deck
		*			shuffle deck
		*			create new hand
		*		ELSE IF(continue pressed)
		*			create new hand
		*		ELSE IF(hit pressed)
		*			draw player's card
		*			update info panel
		*			IF(player busts)
		*				issue loss notification
		*				issue game message
		*				show game menu
		*				refresh UI
		*			ELSE IF(player's hand is full)
		*				hide hit button
		*				trigger ai
		*			ELSE(normal hand)
		*				hide new game button
		*				show hit button
		*				show stay button
		*				refresh UI
		*			END IF
		*		ELSE IF(stay pressed)
		*			disable hit / stay
		*			trigger ai
		*		END IF - button pressed
		*	END IF - deck empty
		* END actionPerformed
		**********************************************************/

		public void actionPerformed(ActionEvent event)
		{
			//local constants

			//local variables

			/************************   Begin actionPerformed Method   *************************/

			//IF(deck is empty)
			if(gameDeck.getRemaining() == 0)
			{
				//add a deck
				addDeck();
			}
			//ELSE(deck NOT empty)
			else
			{
				//IF(new game pressed)
				if(event.getSource() == newGame)
				{
					//create new deck
					gameDeck = new Deck();

					//add cards to deck
					gameDeck.populate();

					//shuffle deck
					gameDeck.shuffle();

					//create new hand
					continueGame();
				}
				//ELSE IF(continue pressed)
				else if(event.getSource() == contGame)
				{
					//create new hand
					continueGame();
				}
				//ELSE IF(hit pressed)
				else if(event.getSource() == hit)
				{
					//draw player's card
					playerHand.draw(gameDeck);
					player.refresh();

					//update info panel
					info.setDeckResult(gameDeck.getRemaining());
					info.setHeldResult(player.getHandSize());
					info.setPointsResult(player.getPoints());

					//IF(player busts)
					if(player.getPoints() > TARGET_SCORE)
					{
						//issue loss notification
						winLoseText.setText("You Lose");

						//issue game message
						messageText.setText("Bust");

						//show game menu
						tableMid.remove(hit);
						tableMid.remove(stay);
						tableMid.add(newGame);
						tableMid.add(contGame);

						//refresh UI
						tableMid.repaint();
					}
					//ELSE IF(player's hand is full)
					else if(player.getHandSize() == MAX_HAND_SIZE &&
							player.getPoints() > TARGET_SCORE)
					{
						//hide hit button
						tableMid.remove(hit);
						tableMid.remove(stay);

						//trigger ai
						aI();
					}
					//ELSE(normal hand)
					else
					{
						//hide new game button
						tableMid.remove(newGame);
						tableMid.remove(contGame);

						//show hit button
						tableMid.add(hit);

						//show stay button
						tableMid.add(stay);

						//refresh UI
						tableMid.repaint();

					}//END IF
				}
				//ELSE IF(stay pressed)
				else if(event.getSource() == stay)
				{
					//disable hit / stay
					tableMid.remove(hit);
					tableMid.remove(stay);

					//trigger ai
					aI();

				}//END IF - button pressed

			}//END IF - deck empty

		}//END actionPerformed

	}//END MultiButton

}//END BodyPanel