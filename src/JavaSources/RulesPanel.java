/**********************************************************
* Program Name  : RulesPanel
* Author        : Tucker Burke
* Date          : May 3, 2015
* Course 		: CSC112 - 01W
* Description	: BorderLayout for sub panel displaying game rules
*
* Methods:
* -------
* BodyPanel - constructor
**********************************************************/

//for NetBeans packaging
package JavaSources;

//import statements
import java.awt.*;
import javax.swing.*;

public class RulesPanel extends JPanel
{
	//instance constants
	final Color	FELT	= new Color(42, 83, 69);	//background rgb
	final Color PANEL	= new Color(216,205, 174);	//panel rgb

	//instance variables
	private JLabel	winBox;		//winning text box
	private JLabel	snakeBox;	//snake eyes text box
	private JLabel 	pointsBox;	//points text box
	private String	html;		//for html styling
	private String	winText;	//win rules
	private String	snakeText;	//snake eyes rules
	private String	pointsText;	//point values

	/**********************************************************
	* Method Name   : RulesPanel (constructor)
	* Author        : Tucker Burke
	* Date          : April 30, 2015
	* Course 		: CSC112 - 01W
	* Description	: Sets up sub panels rules display
	*
	* BEGIN BodyPanel (constructor)
	*	initialize text
	*	initialize labels
	*	set panel size
	*	set panel color
	*	set panel border
	*	add labels to panel
	* END BodyPanel
	**********************************************************/

	public RulesPanel()
	{
		//local constants

		//local variables

		/************************   Begin Constructor   *************************/

		//initialize text
		html		= "<html><body style='width:62px'>";
		winText		= "Winning:<br> ~Closest 21 ~Lose on tie ~Lose on bust";
		snakeText	= "Snake Eyes:<br> ~2 Aces = 22 ~Draw 'n bust";
		pointsText	= "Points:<br>~Ace 11 pts ~Face 10 pts ~Other X pts";

		//initialize labels
		winBox		= new JLabel(html + winText);
		snakeBox	= new JLabel(html + snakeText);
		pointsBox	= new JLabel(html + pointsText);

		//set panel size
		setPreferredSize(new Dimension(100, 220));

		//set panel color
		setBackground(PANEL);

		//set panel border
		setBorder(BorderFactory.createLineBorder(FELT, 5));

		//add labels to panel
		add(winBox);
		add(snakeBox);
		add(pointsBox);

	}//END RulesPanel (constructor)

}//END RulesPanel