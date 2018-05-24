/**********************************************************
* Program Name  : CardPanel
* Author        : Tucker Burke
* Date          : May 3, 2015
* Course 		: CSC112 - 01W
* Description	: BorderLayout for card face
*
* Methods:
* -------
* BodyPanel - constructor
* setDown	- flips card face down
* setUp		- flips card face up
**********************************************************/

//for NetBeans packaging
package JavaSources;

//import statements
import java.awt.*;
import javax.swing.*;

public class CardPanel extends JPanel
{
	//instance constants
	final Color		FELT		= new Color(42, 83, 69);	//background rgb
	final Color		CARD		= new Color(247, 234, 198);	//card rgb
	final ImageIcon	BACK_IMAGE  = new ImageIcon(getClass().getResource("images/CardBack.jpg"));//image for back of card

	//instance variables
	private JPanel		subPanel;		//contains card layout
	private JPanel		left;			//contains face and suit boxes
	private JPanel 		right;			//contains suit and face boxes
	private JPanel		center;			//contains card image
	private JPanel		leftFaceBox;	//contains face label for left of card
	private JPanel		leftSuitBox;	//contains suit label for left of card
	private JPanel		rightFaceBox;	//contains face label for right of card
	private JPanel		rightSuitBox;	//contains suit label for right of card
	private JLabel		leftFace;		//contains face value string
	private JLabel		leftSuit;		//contains suit value string
	private JLabel		rightFace;		//contains face value string
	private JLabel		rightSuit;		//contains suit value string
	private	JLabel 		cardBack;		//card back image insert

	/**********************************************************
	* Method Name   : CardPanel (constructor)
	* Author        : Tucker Burke
	* Date          : May 3, 2015
	* Course 		: CSC264 - 01
	* Description	: Sets up sub panels for card layout
	*
	* BEGIN BodyPanel (constructor)
	*	IF(card is blank)
	*		set layout format
	*		initialize blank panel
	*		set panel size
	*		set panel color
	*		add components to panel
	*	ELSE IF(card is valid)
	*		initialize panels
	*		set sub panel layout
	*		curve border
	*		initialize labels
	*		set label fonts
	*		IF(card is blank)
	*			do nothing
	*		ELSE IF(heart or diamond)
	*			change text color
	*		END IF
	*		set panel sizes
	*		set panel colors
	*		add boxes to subpanels
	*		add labels to boxes
	*		add components to panel
	*	END IF
	* END BodyPanel
	**********************************************************/

	public CardPanel(Card card)
	{
		//local constants

		//local variables

		/************************   Begin Constructor   *************************/

		//IF(card is blank)
		if(card == null)
		{
			//set layout format
			setLayout(new BorderLayout());

			//initialize blank panel
			center = new JPanel();

			//set panel size
			center.setPreferredSize(new Dimension(100, 140));

			//set panel color
			center.setBackground(FELT);

			//add components to panel
			add(center, BorderLayout.NORTH);
		}
		//ELSE(card is valid)
		else
		{
			//initialize panels
			subPanel		= new JPanel();
			left			= new JPanel();
			right			= new JPanel();
			center			= new JPanel();
			leftFaceBox		= new JPanel();
			leftSuitBox		= new JPanel();
			rightFaceBox	= new JPanel();
			rightSuitBox	= new JPanel();

			//set sub panel layout
			subPanel.setLayout(new BorderLayout());
			left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
			right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
			center.setLayout(new BorderLayout());

			//curve border
			subPanel.setBorder(BorderFactory.createLineBorder(CARD, 10, true));
			subPanel.setBorder(BorderFactory.createLineBorder(CARD, 10, true));

			//initialize labels
			leftFace	= new JLabel(card.getFaceString());
			leftSuit	= new JLabel(card.getSuitString());
			rightFace	= new JLabel(card.getFaceString());
			rightSuit	= new JLabel(card.getSuitString());
			cardBack 	= new JLabel("", BACK_IMAGE, SwingConstants.LEFT);

			//set label fonts
			leftFace.setFont(new Font("Card Characters", Font.PLAIN, 18));
			leftSuit.setFont(new Font("Card Characters", Font.PLAIN, 18));
			rightFace.setFont(new Font("Card Characters", Font.PLAIN, 18));
			rightSuit.setFont(new Font("Card Characters", Font.PLAIN, 18));
			cardBack.setVisible(false);

			//IF(card is blank)
			if(card.getSuitString() == null)
			{
				//do nothing
			}
			//ELSE IF(heart or diamond)
			else if(card.getSuitString().compareTo("\u2665") == 0 || card.getSuitString().compareTo("\u2666") == 0)
			{
				//change text color
				leftFace.setForeground(Color.RED);
				leftSuit.setForeground(Color.RED);
				rightFace.setForeground(Color.RED);
				rightSuit.setForeground(Color.RED);

			}//END IF

			//set panel sizes
			left.setPreferredSize(new Dimension(24, 130));
			right.setPreferredSize(new Dimension(24, 130));
			center.setPreferredSize(new Dimension(20, 130));
			leftFaceBox.setPreferredSize(new Dimension(24, 24));
			leftSuitBox.setPreferredSize(new Dimension(24, 24));
			rightFaceBox.setPreferredSize(new Dimension(24, 24));
			rightSuitBox.setPreferredSize(new Dimension(24, 24));
			subPanel.setPreferredSize(new Dimension(96, 130));
			setPreferredSize(new Dimension(100, 140));

			//set panel colors
			left.setBackground(CARD);
			right.setBackground(CARD);
			center.setBackground(CARD);
			leftFaceBox.setBackground(CARD);
			leftSuitBox.setBackground(CARD);
			rightFaceBox.setBackground(CARD);
			rightSuitBox.setBackground(CARD);
			subPanel.setBackground(FELT);
			setBackground(FELT);

			//add boxes to subpanels
			left.add(leftFaceBox);
			left.add(Box.createRigidArea(new Dimension(0, 52)));
			left.add(leftSuitBox);
			right.add(rightSuitBox);
			right.add(Box.createRigidArea(new Dimension(0, 52)));
			right.add(rightFaceBox);

			//add labels to boxes
			leftFaceBox.add(leftFace);
			leftSuitBox.add(leftSuit);
			rightFaceBox.add(rightFace);
			rightSuitBox.add(rightSuit);

			//add components to panel
			center.add(cardBack, BorderLayout.CENTER);
			subPanel.add(left, 	 BorderLayout.WEST);
			subPanel.add(right,  BorderLayout.EAST);
			subPanel.add(center, BorderLayout.CENTER);
			add(subPanel);

		}//END IF

	}//END CardPanel (constructor)

	/**********************************************************
	* Method Name    : setDown
	* Author         : Tucker Burke
	* Date           : May 7, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : displays card face down
	*
	* BEGIN setDown
	*	hide card info
	*	show card back
	* END setDown
	**********************************************************/

	public void setDown()
	{
		//local constants

		//local variables


		/********************   Start setDown Method   ********************/

		//hide card info
		left.setVisible(false);
		right.setVisible(false);

		//show card back
		cardBack.setVisible(true);

	}//END setDown

	/**********************************************************
	* Method Name    : setUp
	* Author         : Tucker Burke
	* Date           : May 7, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : displays card face down
	*
	* BEGIN setUp
	*	show card info
	*	hide card back
	* END setUp
	**********************************************************/

	public void setUp()
	{
		//local constants

		//local variables


		/********************   Start setUp Method   ********************/

		//show card info
		left.setVisible(true);
		right.setVisible(true);

		//hide card back
		cardBack.setVisible(false);

	}//END setUp

}//END CardPanel