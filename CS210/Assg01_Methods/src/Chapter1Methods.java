/* 
 * CS210 Assignment 01 (Methods - Sequencing)
 * FirstName LastName - ContactEmailAddress
 * Student ID: 123 456 789
 * YYYY.MM.DD - Which quarter
 *
 * This software is published under the GNU general public license
 * https://www.gnu.org/licenses/gpl.txt
 * https://en.wikipedia.org/wiki/GNU_General_Public_License
 *
 * This program is a short puzzle.
 */

public class Chapter1Methods {

    public static void first() {
        System.out.println("first method");
        
        
    }

    public static void second() {
        System.out.println("second method");
        
        
    }
 
    public static void third() {
        System.out.println("third method");
        
        
    }
 
    public static void main(String[] args) {
    // DO NOT change this main method
       third();
       first();
       third();
       second();
    // DO NOT change this main method
    }

}


// Desired output:
//
// third method
// second method
// first method
// second method
// first method
// second method
// third method
// second method
// first method
// second method
// second method