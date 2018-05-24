/**********************************************************
* Program Name  : SnakeEyes21
* Author        : Tucker Burke
* Date          : May 3, 2015
* Course 		: CSC112 - 01W
* Description	: Mod of the card game black jack
*
* Methods:
* -------
* Main - Creates frame and adds instance of BodyPanel as a
*		 content pane
**********************************************************/

//for NetBeans packaging
package JavaSources;

//import statements
import javax.swing.*;

public class SnakeEyes21
{
	/**********************************************************
	* Method Name   : main
	* Author        : Tucker Burke
	* Date          : May 3, 2015
	* Course 		: CSC264 - 01
	* Description	: Creates an instance of BodyPanel and adds
	*				  it to the frame.
	*
	* BEGIN main
	*	prep frame
	*	add body to frame
	*	package for output
	* END main
	**********************************************************/

    public static void main(String args[])
    {
    	//local constants

    	//local variables
    	JFrame 		frame	= new JFrame ("Snake Eyes 21");	//title bar text
    	BodyPanel	body	= new BodyPanel();				//sub panel

    	/************************   Begin Main Method   *************************/

		//prep frame
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

		//add body to frame
		frame.getContentPane().add(body);

		//package for output
		frame.pack();
		frame.setVisible(true);

	}//END main method

}//END SnakeEyes21