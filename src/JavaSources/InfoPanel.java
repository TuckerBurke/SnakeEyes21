/**********************************************************
* Program Name  : InfoPanel
* Author        : Tucker Burke
* Date          : May 3, 2015
* Course 		: CSC112 - 01W
* Description	: BorderLayout for sub panel displaying game info
*
* Methods:
* -------
* InfoPanel 		- constructor
* InfoPanel			- overloaded constructor
* setDeckResult		- refreshes deck jlabel
* setHeldResult		- refreshes hand jlabel
* setPointsResult	- refreshes points jlabel
**********************************************************/

//for NetBeans packaging
package JavaSources;

//import statements
import java.awt.*;
import javax.swing.*;

public class InfoPanel extends JPanel
{
	//instance constants
	final Color	FELT	= new Color(42, 83, 69);	//background rgb
	final Color PANEL	= new Color(216,205, 174);	//panel rgb

	//instance variables
	private JLabel		deckTitle;		//label displaying cards left heading
	private JLabel		heldTitle;		//label displaying held heading
	private JLabel		pointsTitle;	//label displaying points heading
	private JLabel		deckResult;		//label displaying cards in deck
	private JLabel		heldResult;		//label displaying cards in hand
	private JLabel		pointsResult;	//label displaying total points in hand
	private HandPanel	playerPanel;	//passed instance of HandPanel represents player
	private HandPanel	dealerPanel;	//passed instance of HandPanel represents dealer
	private Deck		deck;			//passed instance of Deck for get remaining method

	/**********************************************************
	* Method Name   : InfoPanel (constructor)
	* Author        : Tucker Burke
	* Date          : May 4, 2015
	* Course 		: CSC112 - 01W
	* Description	: Sets up default info display
	*
	* BEGIN InfoPanel (constructor)
	*	set layout
	*	initialize labels
	*	center text
	*	set fonts
	*	set panel size
	*	set panel color
	*	set panel border
	*	add labels to panel
	* END InfoPanel
	**********************************************************/

	public InfoPanel()
	{
		//local constants

		//local variables

		/************************   Begin Constructor   *************************/

		//set layout
		setLayout(new GridLayout(6, 1));

		//initialize labels
		deckTitle	= new JLabel("Cards in Deck");
		heldTitle	= new JLabel("Cards in Hand");
		pointsTitle	= new JLabel("Player Points");
		deckResult	= new JLabel("0");
		heldResult	= new JLabel("0");
		pointsResult= new JLabel("0");

		//center text
		deckTitle.setHorizontalAlignment(JLabel.CENTER);
		heldTitle.setHorizontalAlignment(JLabel.CENTER);
		pointsTitle.setHorizontalAlignment(JLabel.CENTER);
		deckResult.setHorizontalAlignment(JLabel.CENTER);
		heldResult.setHorizontalAlignment(JLabel.CENTER);
		pointsResult.setHorizontalAlignment(JLabel.CENTER);

		//set fonts
		deckResult.setFont(new Font("Card Characters", Font.PLAIN, 24));
		pointsResult.setFont(new Font("Card Characters", Font.PLAIN, 24));
		heldResult.setFont(new Font("Card Characters", Font.PLAIN, 24));
		pointsResult.setFont(new Font("Card Characters", Font.PLAIN, 24));
		deckResult.setForeground(Color.RED);
		heldResult.setForeground(Color.RED);
		pointsResult.setForeground(Color.RED);

		//set panel size
		setPreferredSize(new Dimension(100, 220));

		//set panel color
		setBackground(PANEL);

		//set panel border
		setBorder(BorderFactory.createLineBorder(FELT, 5));

		//add labels to panel
		add(deckTitle);
		add(deckResult);
		add(heldTitle);
		add(heldResult);
		add(pointsTitle);
		add(pointsResult);

	}//END InfoPanel (constructor)

	/**********************************************************
	* Method Name   : RulesPanel (overloaded constructor)
	* Author        : Tucker Burke
	* Date          : May 4, 2015
	* Course 		: CSC112 - 01W
	* Description	: Sets up game info display
	*
	* BEGIN InfoPanel (constructor)
	*	store hand panels
	*	set layout format
	*	initialize labels
	*	center text
	*	set fonts
	*	set panel size
	*	set panel color
	*	set panel border
	*	add labels to panel
	* END InfoPanel
	**********************************************************/

	public InfoPanel(HandPanel playerHandPanel, HandPanel dealerHandPanel, Deck gameDeck)
	{
		//local constants

		//local variables

		/************************   Begin Constructor   *************************/

		//store hand panels
		playerPanel = playerHandPanel;
		dealerPanel = dealerHandPanel;
		deck		= gameDeck;

		//set layout format
		setLayout(new GridLayout(6, 1));

		//initialize labels
		deckTitle	= new JLabel("Cards in Deck");
		heldTitle	= new JLabel("Cards in Hand");
		pointsTitle	= new JLabel("Player Points");
		deckResult	= new JLabel("" + deck.getRemaining());
		heldResult	= new JLabel("" + playerPanel.getHandSize());
		pointsResult= new JLabel("" + playerPanel.getPoints());

		//center text
		deckTitle.setHorizontalAlignment(JLabel.CENTER);
		heldTitle.setHorizontalAlignment(JLabel.CENTER);
		pointsTitle.setHorizontalAlignment(JLabel.CENTER);
		deckResult.setHorizontalAlignment(JLabel.CENTER);
		heldResult.setHorizontalAlignment(JLabel.CENTER);
		pointsResult.setHorizontalAlignment(JLabel.CENTER);

		//set fonts
		deckResult.setFont(new Font("Card Characters", Font.PLAIN, 24));
		heldResult.setFont(new Font("Card Characters", Font.PLAIN, 24));
		pointsResult.setFont(new Font("Card Characters", Font.PLAIN, 24));
		deckResult.setForeground(Color.RED);
		heldResult.setForeground(Color.RED);
		pointsResult.setForeground(Color.RED);

		//set panel size
		setPreferredSize(new Dimension(100, 220));

		//set panel color
		setBackground(PANEL);

		//set panel border
		setBorder(BorderFactory.createLineBorder(FELT, 5));

		//add labels to panel
		add(deckTitle);
		add(deckResult);
		add(heldTitle);
		add(heldResult);
		add(pointsTitle);
		add(pointsResult);

	}//END InfoPanel (overloaded constructor)

	/**********************************************************
	* Method Name   : setDeckResult
	* Author        : Tucker Burke
	* Date          : May 7, 2015
	* Course 		: CSC112 - 01W
	* Description	: refreshes deck jlabel
	*
	* BEGIN setDeckResult
	* 	change JLabel text
	* END setDeckResult
	**********************************************************/

	public void setDeckResult(int numOfCards)
	{
		//local constants

		//local variables

		/************************   Begin setDeckResult Method   *************************/

		//change JLabel text
		deckResult.setText("" + numOfCards);

	}//END setDeckResult

	/**********************************************************
	* Method Name   : setHeldResult
	* Author        : Tucker Burke
	* Date          : May 7, 2015
	* Course 		: CSC112 - 01W
	* Description	: refreshes hand jlabel
	*
	* BEGIN setHeldResult
	* 	change JLabel text
	* END setHeldResult
	**********************************************************/

	public void setHeldResult(int numOfCards)
	{
		//local constants

		//local variables

		/************************   Begin setHeldResult Method   *************************/

		//change JLabel text
		heldResult.setText("" + numOfCards);

	}//END setHeldResult

	/**********************************************************
	* Method Name   : setPointsResult
	* Author        : Tucker Burke
	* Date          : May 7, 2015
	* Course 		: CSC112 - 01W
	* Description	: refreshes points jlabel
	*
	* BEGIN setHeldResult
	* 	change JLabel text
	* END setHeldResult
	**********************************************************/

	public void setPointsResult(int numOfPoints)
	{
		//local constants

		//local variables

		/************************   Begin setPointsResult Method   *************************/

		//change JLabel text
		pointsResult.setText("" + numOfPoints);

	}//END setPointsResult

}//END InfoPanel