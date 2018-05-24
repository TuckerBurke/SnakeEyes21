/**********************************************************
* Title	      	 : FreqUsed (v2.0)
* Author         : Tucker Burke
* Date           : February 4, 2015
* Course/Section : CSC112, 002W
* Description    : Contains a variety of frequently used methods
*
* Contains Methods:
* 		title()
*		center(String)
*		columnRight(int, String)
*		columnLeft(int, String)
*		clrscr()
*		pause()
*		exitScreen()
**********************************************************/

//for NetBeans packaging
package JavaSources;

public class FreqUsed
{
	/**********************************************************
	* Method Name    : title
	* Author         : Tucker Burke
	* Date           : January 23, 2015
	* Course/Section : CSC112, 002W
	* Description	 : Stores and formats software title for
	*		   ease of repeated use
	*
	* Refined Algorithm:
	*
	* BEGIN title
	*   capitalize and center letters
	*	add heading
	*	output title
	* END title
	**********************************************************/

	public static void title(String name)
	{
		//local constants

		//local variables

		/********************* Start title Method **********************/

		//capitalize and center letters
		name = center(name.toUpperCase());

		//add heading
		name = "\n\n\n" + name + "\n\n";

		//output title
		System.out.print(name);

	}//END title

	/**********************************************************
	* Method Name    : center
	* Author         : Tucker Burke
	* Date           : January 23, 2015
	* Course/Section : CSC112, 002W
	* Program Description: Centers a string passed in as parameter
	*
	* Refined Algorithm:
	*
	* BEGIN center
	*   determine string length
	*   determine spaces to insert
	*   FOR (each space to be inserted)
	*     	add a space to be beginning of the string
	*   END FOR
	*	return field
	* END center
	**********************************************************/

	public static String center(String field)
	{
		//local constants
		final int	SCREEN	= 80;	//width of screen
		final int	HALF	= 2;	//divisor for halving blank space

		//local variables
		int length;	//length of string
		int padding;	//quantity of additional spaces required

		/******************* Start center Method *********************/

		//determine string length
		length = field.length();

		//determine spaces to insert
		padding = (SCREEN - length) / HALF;

		//FOR (each space to be inserted)
		for (int i = 0; i < padding; i++)

			//add a space to be beginning of the string
		   	field = " " + field;

		//return string
		return field;

	}//END center

	/**********************************************************
	* Method Name    : columnRight
	* Author         : Tucker Burke
	* Date           : February 11, 2015
	* Course/Section : CSC112 - 001
	* Description	 : Creates a right justified column
	*
	* Refined Algorithm:
	* -----------------
	* BEGIN center
	*   determine string lengths
	*	WHILE (gutter is too small)
	*		increase gutter size
	*	END WHILE
	* 	FOR (repeat until size of padding)
	*		add space to beginning of text field
	*	END FOR
	*	return row
	* END center
	**********************************************************/

	public static String columnRight(int gutter, String field2)
	{
		//local constants

		//local variables
		int 	column2;	//length of string in second column
		int		padding;	//amount of space to fill gutter
		String	row;		//completely formatted row

		/******************* Start center Method *********************/

		//determine string lengths
		column2 = field2.length();
		padding = gutter - column2;

		//WHILE (gutter is too small)
		while(column2 >= gutter)

			//increase gutter size
			gutter++;

		//END WHILE

		//FOR (repeat until size of padding)
		for (int i = 0; i < padding; i++)

			//add space to beginning of text field
			field2 = " " + field2;

		//END FOR

		//return row
		return field2;

	}//END columnRight

	/**********************************************************
	* Method Name    : columnLeft
	* Author         : Tucker Burke
	* Date           : February 11, 2015
	* Course/Section : CSC112 - 001
	* Description	 : Creates a left justified column
	*
	* Refined Algorithm:
	* -----------------
	* BEGIN center
	*   determine string lengths
	*	WHILE (gutter is too small)
	*		increase gutter size
	*	END WHILE
	* 	FOR (repeat until size of padding)
	*		add space to end of text field
	*	END FOR
	*	return row
	* END center
	**********************************************************/

	public static String columnLeft(int gutter, String field2)
	{
		//local constants

		//local variables
		int 	column2;	//length of string in second column
		int		padding;	//amount of space to fill gutter
		String	row;		//completely formatted row

		/******************* Start center Method *********************/

		//determine string lengths
		column2 = field2.length();
		padding = gutter - column2;

		//WHILE (gutter is too small)
		while(column2 >= gutter)

			//increase gutter size
			gutter++;

		//END WHILE

		//FOR (repeat until size of padding)
		for (int i = 0; i < padding; i++)

			//add space to end of text field
			field2 = field2 + " ";

		//END FOR

		//return row
		return field2;

	}//END columnLeft

	/**********************************************************
	* Method Name    : exitScreen
	* Author         : Tucker Burke
	* Date           : February 8, 2015
	* Course/Section : CSC264 - 01
	* Description    : Predesigned exit screen at termination
	*
	* BEGIN exitScreen
	*	clear screen
	*	display exit message
	* END exitScreen
	**********************************************************/

	public static void exitScreen()
	{
		//local constants

		//local variables

		//Library myLib = new Library();	//instance of library for pause and clear

		/********************   Start exitScreen method  *****************/

		//clear screen
		//myLib.clrscr();

		//display exit message
		System.out.println("\n\n\n" + center("Thank you for evaluating my software!") + "\n\n");
		System.out.println(center("TUCKER WOLFE BURKE") + '\n');
		System.out.println(center("Creative Director"));
		System.out.println(center("www.BrandNew-Creative.com") + "\n\n\n");

	}//END exitScreen

}//END FreqUsed