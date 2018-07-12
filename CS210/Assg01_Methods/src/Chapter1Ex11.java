// CS210 Assignment 1 (Methods)
// Timothy / Lum
// Student ID: 950 682 660
// 2017.04.10 - Spring quarter
//
// 3. (10) Points
//
// Solve Chapter 1 Exercises 11 (page56, 4th Edition).
//
// Submit your final “Chapter1Ex11.java” file .

public class Chapter1Ex11
{

	public static void main(String[] args)
	{
		drawCone();
		drawBox();
		drawUnitedStates();
		drawBox();
		drawCone();
	}
	
	static String Spaces = " "; // Spacing between the rockets can be adjusted at this variable
  
	static void drawCone()
	{
		String Cone1 = "   /\\   ";
		String Cone2 = "  /  \\  ";
		String Cone3 = " /    \\ ";
		System.out.println(Cone1 + Spaces + Cone1);
		System.out.println(Cone2 + Spaces + Cone2);
		System.out.println(Cone3 + Spaces + Cone3);
	}
  
	static void drawLine()
	{
		String Line1 = "+------+";
		System.out.println(Line1 + Spaces + Line1);
	}
  
	static void drawSides()
	{
		String Sides = "|      |";
		System.out.println(Sides + Spaces + Sides);
	}
  
	static void drawBox()
	{
		drawLine();
		drawSides();
		drawSides();
		drawLine();
	}
  
	static void drawUnitedStates()
	{
		String United = "|United|";
		String States = "|States|";
		System.out.println(United + Spaces + United);
		System.out.println(States + Spaces + States);
	}
  
}