// CS210 Guessing Game
// Timothy / Lum
// Student ID: 950 682 660
// 2017.05.08 - Spring quarter
//
// Program which plays a game against the user, attempting to determine a number held by the player.
//
// This software is published under the GNU general public license
// https://www.gnu.org/licenses/gpl.txt
// https://en.wikipedia.org/wiki/GNU_General_Public_License

import java.util.*; // For the random number generators

public class GuessingGame {

// The upper limit of the game range (inclusive)
	static final int upperBoundActual = 100; // The hardcode value limit of the game
	static int upperBound = upperBoundActual; // The flexible limit of the guess
// The lower limit of the game range (inclusive)
	static final int lowerBoundActual = 1; // The hardcode value limit of the game
	static int lowerBound = lowerBoundActual; // The flexible limit of the guess

// Variables for storing the current guess value, turn counter, and game state.
	static int currentGuess = 0;
	static int turnCounter = 0;
	static boolean gameOver = false;
	static boolean derivedAnswer = false;
	
// Random number generator and console input objects.
	static Random someRandomNumber = new Random();
	static Scanner consoleInput = new Scanner(System.in);
	
	public static void main(String[] args) {
// Initialize the game states
		resetGame();
		while (gameOver == false) {
			computerGuess();
			playerResponds();
		}
// End of game when player opts not to continue
		gameOver();
	} // Closing main()

	static void computerGuess(){
		try {
// Generate a number from the difference between the lower and upper bounds, then add the lower bound to that difference.
// Assign this value to "currentGuess"
			currentGuess = someRandomNumber.nextInt((upperBound+1)-lowerBound)+lowerBound;
// If, based on user inputs, the lower and upper bounds have no range (only a single value is allowed),
// the computer will just assume this as the correct answer.
			if (upperBound-lowerBound == 0){
				System.out.println("Then the answer must be... " + currentGuess + "!");
				turnCounter++;
// Used in playerResponse() to bypass an actual player response.
				derivedAnswer = true;
			}
			else {
				System.out.println("Computer guesses: " + currentGuess);
				turnCounter++;
			}
		} // Closing try
		catch (Exception IllegalArgumentException) {
			System.out.println("That's not possible... (IllegalArgumentException: Non-positive bounds)");
// Used in playerResponse() to bypass an actual player response.
			derivedAnswer = true;
		} // Closing catch
	} // Closing computerGuess()

// Function for the player response turn (may be defaulted if the computer has derived an answer
// that does not require a response.
	static void playerResponds() {
		boolean validResponse = false;
		if (derivedAnswer == true) {
			matchOver();
		} // Closing if
		else {
			while (validResponse == false) {
				System.out.print("Player responds, this is (high, low, correct): ");
				String response;
				response = consoleInput.nextLine();
				System.out.println(response);
// Adjust the upper bound if user says "high"
				if (response.equalsIgnoreCase("high")) {
					upperBound = currentGuess - 1;
					validResponse = true;
				}
// Adjust the loweBound if user says "low"
				else if (response.equalsIgnoreCase("low")) {
					lowerBound = currentGuess + 1;
					validResponse = true;
				}
// Initiate match conclusion behavior on correct guess
				else if (response.equalsIgnoreCase("correct")) {
					matchOver();
					validResponse = true;
				}
				else {
					System.out.println("I don't understand.");
				}
			} // Closing while
		} // Closing else
	} // Closing playerResponds()

// Match conclusion behavior
	static void matchOver() {
		char matchResponse;
		System.out.println("Game complete! That took " + turnCounter + " turn(s)!");
// While loop's key
		boolean validResponse = false;
		while (validResponse == false){
			System.out.print("Play again? ");
// matchResponse variable gets the consoleInput.next String, but specifically the character at index 0 (the first character)
			matchResponse = consoleInput.next().charAt(0);
			if (matchResponse == 'y' || matchResponse == 'Y') {
				System.out.println();
				validResponse = true;
				resetGame();
			}
			else if (matchResponse == 'n' || matchResponse == 'N') {
				gameOver = true; // Set game state to over, concluding in-game while loop
				validResponse = true; // Exit current while loop
			}
			else {
				System.out.println("I don't understand");
			}
		}
	} // Closing matchOver()

	static void resetGame() {
		System.out.println("Initializing...");
// Reset the guess bounds to the game limits
		lowerBound = lowerBoundActual;
		upperBound = upperBoundActual;
// Reset turnCounter
		turnCounter = 0;
		derivedAnswer = false;
		System.out.println("Player is thinking of a number between " + lowerBound + " and " + upperBound + ".");
	}
	
	static void gameOver() {
		System.out.println("Thanks for playing!");
	} // Closing resetGame()
} // Closing guessingGame()