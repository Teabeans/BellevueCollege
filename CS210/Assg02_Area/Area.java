// CS210 Area calculator
// Timothy / Lum
// Student ID: 950 682 660
// 2017.04.18 - Spring quarter
//
// This program prompts the user for 2 of 3 different types of shapes
// (rectangle, triangle, and circle), their critical dimensions, then proceeds
// to calculate the area of the 2 shapes. Finally, it compares the areas of
// the shapes and gives a generalized response regarding this comparison.
//
// Assignment description as follows:
// Prompt the user for information about two figures and calculate the area.
// Prompt the width, height (rectangle), base, height (triangle), and radius (circle)
// After obtaining the area for each figure, the program should report how they compare.
//
// For the figure prompt, note that duplication is not allowed. The user must select two figures.
// The comparison message should read like follows:
//  The rectangle seems bigger than the triangle.
//  The triangle seems bigger than the rectangle.
//  The triangle and rectangle seem equal.
//
// Use at least 4 static methods besides main().
// Static methods should not exceed 12 lines of code.
// Include comments at the beginning of the program and for each method describing what it does.
//
// The program should be named Area.java
// Use "import java.util.*; for the Scanner class

import java.util.*; // For the scanner utility
import java.math.*; // For the PI utility

public class Area {
	static final float floatPI = (float) Math.PI; // Setting a constant for pi, but as a float (not a double)
	static Scanner consoleInput = new Scanner(System.in); // Establishes a new scanner object named consoleInput that can be accessed by all methods
	
	public static void main(String[] args) {
// Asks the first shape question and assigns only the valid response to the firstShape variable.
		String firstShape;
		firstShape = positFirstQuestion();
// Sends the first shape choice to get dimensions. Returns and stores the area.
		float firstShapeArea = userSpecifyParameters(firstShape);
// Reports the state of the firstShape and firstShape area variable AS SEEN BY THE MAIN METHOD.
		System.out.printf("The area of the " + firstShape + " is (%.3f) square units. \n\n", firstShapeArea);
		
// Posit the second shape question - the second question function must receive the first choice, else it won't know what the user selected.		
		String secondShape;
		secondShape = positSecondQuestion(firstShape);
// Sends the second shape choice to get dimensions. Returns and stores the area.		
		float secondShapeArea = userSpecifyParameters(secondShape);
// Reports the state of the secondShape and secondShape area variable AS SEEN BY THE MAIN METHOD.
		System.out.printf("The area of the " + secondShape + " is (%.3f) square units. \n\n", secondShapeArea);

// Method that accepts all relevant data generated thus far and performs the comparison statement.
		compareAreas(firstShape, secondShape, firstShapeArea, secondShapeArea);
	}


// Asks first shape question, also passes back the result of the user response method.
	static String positFirstQuestion() { 
		System.out.print("Please choose your first shape (rectangle, triangle, or circle): ");
// Method that filters user inputs and returns a valid response (rectangle, triangle, circle). The response is immediately returned to main().
		return (userChooseShape1());
	}


// Asks second shape question, both passes back the result of the user response method and passes forward the first shape input.
	static String positSecondQuestion(String passedFirstShape) {
		System.out.print("Please choose a second shape unlike the first: ");
// Method that filters user inputs and returns a valid response (rectangle, triangle, circle, minus the first shape which is passed to it). The result is immediately returned to main().
		return (userChooseShape2(passedFirstShape));
	}

	
// Code that controls the first shape selection.
	static String userChooseShape1() {		
		String userSelection = "Foo Bar Baz";
// While loop that will continue while the firstShape variable is not equal to "rectangle", "triangle", or "circle"
		while (userSelection != "rectangle" && userSelection != "triangle" && userSelection != "circle") {
// Scans the next input as a string and assigns it to variable userSelection
			userSelection = consoleInput.next();
// If the user types "rectangle", "triangle", "circle", or any permutation therein, pass the input to lowercasing().
// The returned result is a clean user input for the shape. Pass this value back to main().
			if (userSelection.equalsIgnoreCase("rectangle") || userSelection.equalsIgnoreCase("triangle") || userSelection.equalsIgnoreCase("circle")) {
				return(lowercasing(userSelection));
			}
// All other user inputs would be invalid, so respond as such.
// Return to the top of the loop after responding.	
			else {
				System.out.print("I don't understand what shape that is. Please choose a shape: ");
			}
		}
// Return result should never be activated, but is required for Java to compile properly.
		return ("Foo Bar Baz");
	}
	

// Code that controls the second shape selection. Must accept the first shape definition so it knows what to exclude.
	static String userChooseShape2(String passedFirstShape) {
		String userSelection = "Foo Bar Baz";
// While loop that will continue while the secondShape variable is not equal to "rectangle", "triangle", or "circle"
		while (userSelection != "rectangle" && userSelection != "triangle" && userSelection != "circle") {
// Scans the next input as a string and assigns it to variable userInput			
			userSelection = consoleInput.next(); 
// If the user types the same thing as the previous selection, they will be prompted as such and the while loop starts again.
			if (userSelection.equalsIgnoreCase(passedFirstShape)) {
				System.out.print("You already selected " + passedFirstShape + ". Please try again: ");
			}
// If the user types "rectangle", "triangle", "circle", or any permutation therein, pass the input to lowercasing().
// The returned result is a clean user input for the shape. Pass this value back to main().
			else if (userSelection.equalsIgnoreCase("rectangle") || userSelection.equalsIgnoreCase("triangle") || userSelection.equalsIgnoreCase("circle")) {
				return(lowercasing(userSelection));
			}
// All other user inputs would be invalid, so respond as such.
// Return to the top of the while loop after responding.	
			else {
				System.out.print("I don't understand what shape that is. Please choose a shape: ");
			}
		}
// This return result should never be activated, but is required for Java to compile properly.
		return ("Foo Bar Baz");
	}

	
// Method that parses valid inputs from ChooseShape2(). This method both selects which shape the user picked and
// converts untidy user input to clean values. Passes the cleaned value back to ChooseShape2() (which passes it to main())
	static String lowercasing(String goodInput) {
		if (goodInput.equalsIgnoreCase("rectangle")) {
			return("rectangle");
		}
		else if (goodInput.equalsIgnoreCase("triangle")) {
			return("triangle");
		}
		else {
			return("circle");
		}
	}
	
// This method controls the selection of the correct parameter prompts.
	static float userSpecifyParameters(String objectName) { 
// If the method is passed the word "rectangle", it will activate the "rectangleCase()" method, which prompts for rectangle dimensions
// and returns the area. This value (the area), is immediately sent back to main().
		if (objectName.equalsIgnoreCase("Rectangle")) {			
			return(rectangleCase());
		}

// If the method is passed the word "triangle", it will activate the "triangleCase()" method, which prompts for triangle dimensions
// and returns the area. This value (the area), is immediately sent back to main().		
		else if (objectName.equalsIgnoreCase("Triangle")) {
			return(triangleCase());
		}
		
// Otherwise, this function assumes it has received "circle", and will activate the"circleCase()" method, which prompts for circle radius
// and returns the area. This value (the area), is immediately sent back to main().	 
		else {
			return(circleCase());
		}
	}
	
	
// Takes rectangular dimension inputs from the user and returns the area to userSpecifyParameters(), which returns it to main().
	static float rectangleCase() { 
		System.out.print("Specify rectangle width:  ");
// Assign console input to local shapeWidth variable
		float shapeWidth = consoleInput.nextFloat();

		System.out.print("Specify rectangle height: ");
// Assign console input to local shapeHeight variable
		float shapeHeight = consoleInput.nextFloat();

// Calculate the area as (Width * Height)		
		return (shapeWidth * shapeHeight);
	}
	

// Takes triangular dimension inputs from the user and returns the area to userSpecifyParameters() (which returns it to main()).
	static float triangleCase() {
// Prompts for triangle base
		System.out.print("Specify triangle base:    ");
// Assign console input to local shapeBase variable
		float shapeBase = consoleInput.nextFloat();

// Prompts for triangle height
		System.out.print("Specify triangle height:  ");
// Assign console input to local shapeHeight variable
		float shapeHeight = consoleInput.nextFloat();

// Calculate the area as (Base * Height / 2)
		return ((shapeBase * shapeHeight)/2);
		}


// Takes circular dimension input from the user and returns the area to userSpecifyParameters() (which returns it to main()).
	static float circleCase() {
// Prompts for circle radius.
		System.out.print("Specify circle radius:    ");
// Assign console input to local shapeRadius variable
		float shapeRadius = consoleInput.nextFloat();

// Calculate the area as the constant pi times the radius times the radius. Return the value to userSpecifyParameters().
		return (floatPI * (shapeRadius * shapeRadius));
	}


// Writes the comparison statement between the two shapes and their areas. Accepts the two shapes and their respective areas as parameters.	
	static void compareAreas(String localFirstShape, String localSecondShape, float localFirstArea, float localSecondArea) {
		System.out.printf("The area of the " + localFirstShape + " (%.3f square units) is ", localFirstArea);

// Determines the relationship of the first shape's area to the second shape's area.
		if (localFirstArea > localSecondArea) {
			System.out.print("greater than");
		}
		else if (localFirstArea < localSecondArea) {
			System.out.print("less than");
		}
// If the first shape's area is neither greater than nor less than the second shape's area, it must be equal to it.
		else {
			System.out.print("equal to");
		}
		System.out.printf(" the area of the " + localSecondShape + " (%.3f square units).", localSecondArea);
	}
}