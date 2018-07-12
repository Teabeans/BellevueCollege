// CS210 Assignment 1 (Methods)
// Timothy / Lum
// Student ID: 950 682 660
// 2017.04.10 - Spring quarter
//
// 2. (5) Points
//
// Download the attached “Clementine.java” file.
//
// Modify Clementine.java. Use at least four static methods to show structure and eliminate redundancy in your solution.
// 
// Submit the final “Clementine.java” file (DO NOT change the file name)

public class Clementine
{

  public static void main(String[] args)
  {
	  title();
      stanzaOne();
      refrain();
      stanzaTwo();
      refrain();
      stanzaThree();
      refrain();
   }
  
  static void title()
  {
      System.out.println("Clementine");
  }
  
  static void refrain()
  {
      System.out.println();
      System.out.println("Oh, my darling, oh, my darling");
      System.out.println("Oh, my darling Clementine");
      System.out.println("You are lost and gone forever");
      System.out.println("Dreadful sorry, Clementine");
  }
  
  static void stanzaOne()
  {
      System.out.println();
      System.out.println("In a cavern, in a canyon");
      System.out.println("Excavating for a mine");
      System.out.println("Lived a miner, forty-niner");
      System.out.println("And his daughter, Clementine");
  }
  
  static void stanzaTwo()
  {
      System.out.println();
	  System.out.println("Light she was and like a fairy");
	  System.out.println("And her shoes were number nine");
	  System.out.println("Herring boxes without topses");
	  System.out.println("Sandals were for Clementine");
  }
  
  static void stanzaThree()
  {
      System.out.println();
	  System.out.println("Drove she ducklings to the water");
      System.out.println("Every morning just at nine");
      System.out.println("Hit her foot against a splinter");
      System.out.println("Fell into the foaming brine");
  }
  
}