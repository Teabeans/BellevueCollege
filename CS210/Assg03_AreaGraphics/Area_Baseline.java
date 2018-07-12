/* 
 * CS210 Assignment 00 (Introductions)
 * FirstName LastName - ContactEmailAddress
 * Student ID: 123 456 789
 * YYYY.MM.DD - Which quarter
 *
 * This software is published under the GNU general public license
 * https://www.gnu.org/licenses/gpl.txt
 * https://en.wikipedia.org/wiki/GNU_General_Public_License
 *
 * This is a template file for future programs.
 */

import java.util.*; // For random and scanner class, also exceptions

public class Area_Baseline {

// Project default error message
	static final String DEFAULT_ERROR = "Not a valid input, please try again: ";
	
// Project error message for erroneous shape inputs
	static final String SHAPE_ERROR = "I don't understand what shape that is. Please choose a shape: ";
	
// Setting a constant for pi, but as a float (not a double)
	static final float floatPI = (float) Math.PI;

// General scanner entity defined here
	private static Scanner consoleInput = new Scanner(System.in);

	static int scratchpad1;
	static int scratchpad2;
	static float scratchpadArea;
	
	static String firstShape = "Foo Bar Baz";
	static int firstShapeDimension1 = 0;
	static int firstShapeDimension2 = 0;
	static float firstShapeArea = 0;
	
	static String secondShape = "Foo Bar Baz";
	static int secondShapeDimension1 = 0;
	static int secondShapeDimension2 = 0;
	static float secondShapeArea = 0;

	public static void main(String[] args) {

// Asks the first shape question and assigns only the valid response to the firstShape variable.
		positFirstQuestion();
		userSpecifyParameters(firstShape);
		firstShapeDimension1 = scratchpad1;
		firstShapeDimension2 = scratchpad2;
		firstShapeArea = scratchpadArea;

// Reports the state of the firstShape and firstShape area variable.
		System.out.printf("The area of the " + firstShape + " is (%.3f) square units. \n\n", firstShapeArea);

// Posit the second shape question - the second question function must receive the first choice, else it won't know what the user selected.		
		positSecondQuestion();
		userSpecifyParameters(secondShape);
		secondShapeDimension1 = scratchpad1;
		secondShapeDimension2 = scratchpad2;
		secondShapeArea = scratchpadArea;
		
// Reports the state of the secondShape and secondShape area variable.
		System.out.printf("The area of the " + secondShape + " is (%.3f) square units. \n\n", secondShapeArea);

// Makes the comparison between shapes
		compareAreas();
	}

	
// Asks first shape question, also passes back the result of the user response method.
	static void positFirstQuestion() { 
		System.out.print("Please choose your first shape (rectangle, triangle, or circle): ");
// Method that filters user inputs and returns a valid response (rectangle, triangle, circle). The response is immediately returned to main().
		String userSelection = "Foo Bar Baz";
// While loop that will continue while the firstShape variable is not equal to "rectangle", "triangle", or "circle"
		while (userSelection != "rectangle" && userSelection != "triangle" && userSelection != "circle") {
// Scans the next input as a string and assigns it to variable userSelection
			userSelection = consoleInput.nextLine();
// If the user types "rectangle", "triangle", "circle", or any permutation therein, pass the input to lowercasing().
// The returned result is a clean user input for the shape. Assign this value to the static variable firstShape.
// Assign the lowercased user input to userSelection (thus exiting the while loop).
			if (userSelection.equalsIgnoreCase("rectangle") || userSelection.equalsIgnoreCase("triangle") || userSelection.equalsIgnoreCase("circle")) {
				firstShape = lowercasing(userSelection);
				userSelection = firstShape;
			}
// All other user inputs would be invalid, so respond as such.
// Return to the top of the loop after responding.	
			else {
				System.out.print(SHAPE_ERROR);
			}
		}
	}


// Asks second shape question
	static void positSecondQuestion() {
		System.out.print("Please choose a second shape unlike the first: ");
		String userSelection = "Foo Bar Baz";
// While loop that will continue while the secondShape variable is not equal to "rectangle", "triangle", or "circle"
		while (userSelection != "rectangle" && userSelection != "triangle" && userSelection != "circle") {
// Scans the next input as a string and assigns it to variable userInput			
			userSelection = consoleInput.next(); 
// If the user typed the same thing as the previous selection, they will be prompted as such and the while loop starts again.
			if (userSelection.equalsIgnoreCase(firstShape)) {
				System.out.print("You already selected " + firstShape + ". Please try again: ");
			}
// If the user types "rectangle", "triangle", "circle", or any permutation therein, pass the input to lowercasing().
// The returned result is a clean user input for the shape. Assign this value to the static variable "secondShape".
// Assign the lowercased shape name to userSelection, thus exiting the while loop.
			else if (userSelection.equalsIgnoreCase("rectangle") || userSelection.equalsIgnoreCase("triangle") || userSelection.equalsIgnoreCase("circle")) {
				secondShape = lowercasing(userSelection);
				userSelection = secondShape;
			}
// All other user inputs would be invalid, so respond as such.
// Return to the top of the while loop after responding.	
			else {
				System.out.print(SHAPE_ERROR);
			}
		}
	}

		
// Method that parses valid inputs from positFirstQuestion() and positSecondQuestion(). This method identifies which shape the user picked and
// converts untidy user input to clean values. Passes the cleaned value back to the question posits (which assign them to static variables)
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
	static void userSpecifyParameters(String objectName) { 
		
// If the method is passed the word "rectangle", it will ask the appropriate questions and assign the values to static variables.
		if (objectName.equalsIgnoreCase("Rectangle")) {			
			System.out.print("Specify rectangle width (400 max.):  ");
// Assign the verified userInput to scratchpad1
			scratchpad1 = loopLocked(1, 400, DEFAULT_ERROR);

			System.out.print("Specify rectangle height (400 max.): ");
// Assign the verified userInput to scratchpad2
			scratchpad2 = loopLocked(1, 400, DEFAULT_ERROR);

// Calculate the area
			scratchpadArea = scratchpad1 * scratchpad2;
		}

// If the method is passed the word "rectangle", it will ask the appropriate questions and assign the values to static variables.
		else if (objectName.equalsIgnoreCase("Triangle")) {
			System.out.print("Specify triangle base (400 max.):    ");
			scratchpad1 = loopLocked(1, 400, DEFAULT_ERROR);// Assign the verified userInput to scratchpad1

			System.out.print("Specify triangle height (400 max.):  ");
			scratchpad2 = loopLocked(1, 400, DEFAULT_ERROR);

// Calculate the area as (Base * Height / 2)
			scratchpadArea = (scratchpad1 * scratchpad2)/2;
		}

// If the method is passed the word "circle", it will ask the appropriate questions and assign the values to static variables.
		else {
			System.out.print("Specify circle radius (200 max.):    ");
			scratchpad1 = loopLocked(1, 200, DEFAULT_ERROR);
			scratchpadArea = (floatPI * (scratchpad1 * scratchpad1));
		}
	}

// Method that stays in a loop until a condition is satisfied. In this case, that the verifiedInput is true
	static int loopLocked(int minimumRange, int maximumRange, String errorStatement) {
		consoleInput = new Scanner(System.in);
		boolean loopLock = true;
		String userInput = "";
		
		while (loopLock == true) {
			userInput = consoleInput.nextLine();

// Try-catch block ONLY verifies that the input is an integer
			try {
// If this line throws an exception, the passed userInput was not an integer
				if (verifiedInput(minimumRange, maximumRange, Integer.valueOf(userInput)) == true) {
// If the passed userInput is within the valid range, exit the loop
					loopLock = false;
				}
				else {
					System.out.println("User input value out of range");
					System.out.print(errorStatement);
				}
			}

			catch (Exception InputMismatchException) {
				System.out.println("InputMismatchException error");
				System.out.print(errorStatement);					
			}

		}
		return(Integer.valueOf(userInput));
	}
		
// Verifies that a given input is within range
	static boolean verifiedInput(int minimumRange, int maximumRange, int testValue) {
		if (testValue >= minimumRange && testValue <= maximumRange) {
			return(true);
		}
	
		else {
			return(false);
		}
	}

// Generates the comparison summary between the two shapes and their areas. Accepts the two shapes and their respective areas as parameters.	
	static void compareAreas() {
		String shape1Statement = "The area of the " + firstShape + " (" + firstShapeArea + " square units) is ";

// Determines the relationship of the first shape's area to the second shape's area.
		String comparison;
		if (firstShapeArea > secondShapeArea) {
			comparison = "greater than";
		}
		else if (firstShapeArea < secondShapeArea) {
			comparison = "less than";
		}
// If the first shape's area is neither greater than nor less than the second shape's area, it must be equal to it.
		else {
			comparison = "equal to";
		}

		String shape2Statement = (" the area of the " + secondShape + " (" + secondShapeArea + " square units).");

// Variable to store the complete summary string statement for later passing to the drawstring.method
		String summaryStatement = shape1Statement + comparison + shape2Statement;
		System.out.println(summaryStatement);
	}
}