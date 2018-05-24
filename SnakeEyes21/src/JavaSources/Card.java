/**********************************************************
* Title	      	 : Card
* Author         : Tucker Burke
* Date           : March 17, 2015
* Course/Section : CSC112, 002W
* Description    : Unit of one card node
*
* Methods:
* -------------
* Card			- constructor
* setFaceInt	- modifies the faceInt state
* getFaceInt	- returns the faceInt state
* setFaceString	- modifies the faceString state
* getFaceString	- returns the faceString state
* setSuitInt	- modifies the suitInt state
* getSuitInt	- returns the suitInt state
* setSuitString	- modifies the suitString state
* getSuitString	- returns the suitString state
* setFaceValue	- sets the card's point value
* getFaceValue	- returns the card's point value
* setID			- modifies the uniqueID state
* getID			- returns the uniqueID State
* setNext		- modifies pointer to next card
* getNext		- returns pointer to next card
* toString		- returns instance data as string
**********************************************************/

//for NetBeans packaging
package JavaSources;

public class Card
{
	//class constants

	//class variables
	private int 	faceInt;		//numeric face value
	private String 	faceString;		//string face value
	private int		suitInt;		//numeric suit value
	private String	suitString;		//string suit value
	private int		faceValue;		//number of points card is worth
	private int		uniqueID;		//unique card ID (1-52)
	private Card	next;			//link to next card

    /**********************************************************
    * Method Name    : Card
    * Author         : Tucker Burke
    * Date           : March 17, 2015
    * Course/Section : CSC112 - 01W
    * Description	 : Initializes the instance data
    *
    * BEGIN Constructor
    * 	initialize next card to null
    * END Constructor
    **********************************************************/

  	public Card()
  	{
		//local constants

		//local variables

		/********************   Start constructor method   ********************/

		//inititalize next card to null
		next = null;

	}//END Card

    /**********************************************************
    * Method Name    : setFaceInt
    * Author         : Tucker Burke
    * Date           : March 17, 2015
    * Course/Section : CSC112 - 01W
    * Description	 : modifies the faceInt state
    *
    * BEGIN setFaceInt(int setFace)
    * 	modify faceInt
    * END setFaceInt
    **********************************************************/

  	public void setFaceInt(int setFace)
  	{
		//local constants

		//local variables

		/********************   Start setFaceInt method   ********************/

		//modify faceInt
		faceInt = setFace;

	}//END setFaceInt

	/**********************************************************
	* Method Name    : getFaceInt
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns the faceInt state
	*
	* BEGIN getFaceInt()
	* 	return faceInt
	* END getFaceInt
	**********************************************************/

	public int getFaceInt()
	{
		//local constants

		//local variables

		/********************   Start getFaceInt method   ********************/

		//return faceInt
		return faceInt;

	}//END getFaceInt

    /**********************************************************
    * Method Name    : setFaceString
    * Author         : Tucker Burke
    * Date           : March 17, 2015
    * Course/Section : CSC112 - 01W
    * Description	 : modifies the faceString state
    *
    * BEGIN setFaceString(String setFace)
    * 	modify faceSting
    * END setFaceString
    **********************************************************/

  	public void setFaceString(String setFace)
  	{
		//local constants

		//local variables

		/********************   Start setFaceString method   ********************/

		//modify faceString
		faceString = setFace;

	}//END setFaceString

	/**********************************************************
	* Method Name    : getFaceString
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns the faceString state
	*
	* BEGIN getFaceString()
	* 	return faceString
	* END getFaceString
	**********************************************************/

	public String getFaceString()
	{
		//local constants

		//local variables

		/********************   Start getFaceString method   ********************/

		//return faceString
		return faceString;

	}//END getFaceString

	/**********************************************************
	* Method Name    : setSuitInt
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : modifies the suitInt state
	*
	* BEGIN setSuitInt(int setSuit)
	* 	modify suitInt
	* END setSuitInt
	**********************************************************/

	public void setSuitInt(int setSuit)
	{
		//local constants

		//local variables

		/********************   Start setSuitInt method   ********************/

		//modify suitInt
		suitInt = setSuit;

	}//END setSuitInt

	/**********************************************************
	* Method Name    : getSuitInt
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns the suitInt state
	*
	* BEGIN getSuitInt()
	* 	return suitInt
	* END getSuitInt
	**********************************************************/

	public int getSuitInt()
	{
		//local constants

		//local variables

		/********************   Start getSuitInt method   ********************/

		//return suitInt
		return suitInt;

	}//END getSuitInt

	/**********************************************************
	* Method Name    : setSuitString
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : modifies the suitString state
	*
	* BEGIN setSuitString(String setSuit)
	* 	modify suitSting
	* END setSuitString
	**********************************************************/

	public void setSuitString(String setSuit)
	{
		//local constants

		//local variables

		/********************   Start setSuitString method   ********************/

		//modify suitString
		suitString = setSuit;

	}//END setSuitString

	/**********************************************************
	* Method Name    : getSuitString
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns the suitString state
	*
	* BEGIN getSuitString()
	* 	return suitString
	* END getSuitString
	**********************************************************/

	public String getSuitString()
	{
		//local constants

		//local variables

		/********************   Start getSuitString method   ********************/

		//return suitString
		return suitString;

	}//END getSuitString

    /**********************************************************
    * Method Name    : setFaceValue
    * Author         : Tucker Burke
    * Date           : May 4, 2015
    * Course/Section : CSC112 - 01W
    * Description	 : modifies the cards point value
    *
    * BEGIN setFaceValue(int points)
    * 	modify face value
    * END setFaceValue
    **********************************************************/

  	public void setFaceValue(int points)
  	{
		//local constants

		//local variables

		/********************   Start setFaceValue method   ********************/

		//modify uniqueID
		faceValue = points;

	}//END setFaceValue

    /**********************************************************
    * Method Name    : getFaceValue
    * Author         : Tucker Burke
    * Date           : May 4, 2015
    * Course/Section : CSC112 - 01W
    * Description	 : returns the cards point value
    *
    * BEGIN getFaceValue
    * 	return face value
    * END getFaceValue
    **********************************************************/

  	public int getFaceValue()
  	{
		//local constants

		//local variables

		/********************   Start getFaceValue method   ********************/

		//modify uniqueID
		return faceValue;

	}//END getFaceValue

    /**********************************************************
    * Method Name    : setID
    * Author         : Tucker Burke
    * Date           : March 17, 2015
    * Course/Section : CSC112 - 01W
    * Description	 : modifies the uniqueID state
    *
    * BEGIN setID(int setUniqueID)
    * 	modify uniqueID
    * END setID
    **********************************************************/

  	public void setID(int setUniqueID)
  	{
		//local constants

		//local variables

		/********************   Start setID method   ********************/

		//modify uniqueID
		uniqueID = setUniqueID;

	}//END setID

	/**********************************************************
	* Method Name    : getID
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns the uniqueID state
	*
	* BEGIN getID()
	* 	return uniqueID
	* END getID
	**********************************************************/

	public int getID()
	{
		//local constants

		//local variables

		/********************   Start getID method   ********************/

		//return uniqueID
		return uniqueID;

	}//END getID

	/**********************************************************
	* Method Name    : setNext
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : modifies pointer to next card
	*
	* BEGIN setNext(Card pointNext)
	* 	modify next
	* END setNext
	**********************************************************/

	public void setNext(Card pointNext)
	{
		//local constants

		//local variables

		/********************   Start setNext method   ********************/

		//modify next
		next = pointNext;

	}//END setNext

	/**********************************************************
	* Method Name    : getNext
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns pointer to next card
	*
	* BEGIN getNext()
	* 	return next
	* END getNext
	**********************************************************/

	public Card getNext()
	{
		//local constants

		//local variables

		/********************   Start getNext Method   ********************/

		//return next
		return next;

	}//END getNext

	/**********************************************************
	* Method Name    : toString
	* Author         : Tucker Burke
	* Date           : March 17, 2015
	* Course/Section : CSC112 - 01W
	* Description	 : returns card data as a string
	*
	* BEGIN toString()
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

		/********************   Start toString Method   ********************/

		//return concatenated string
		return FreqUsed.center(FreqUsed.columnLeft(GUTTER_FACE, "" + faceInt) +
							   FreqUsed.columnLeft(GUTTER_FACE, "" + suitInt) +
							   FreqUsed.columnLeft(GUTTER_FACE, faceString) +
							   FreqUsed.columnLeft(GUTTER_SUIT, suitString) +
							   FreqUsed.columnLeft(GUTTER_ID, "" + uniqueID));
	}//END toString

}//END Card