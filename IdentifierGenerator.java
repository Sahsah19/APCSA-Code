import java.util.Scanner;
/* Sahil Gupta - AP CS A - 11/8/2019
   Lab 7 - Identifier Generator
   write a program to convert String into 
   Java Identifiers using logical if/else 
   statements, static methods, and Scanner */
public class IdentifierGenerator{ //declare class IdentifierGenerator
   public static void main(String[] args){ //start of main method
      Scanner scan = new Scanner(System.in); //intialize Scanner
      
      System.out.print("Please enter a string: "); //print statement to input a string
      String str = scan.nextLine(); //take the input of the String
      
      System.out.println("Your identifier is: \"" + camelCaseConverter(str) + "\""); //print out the final statement using the method
   }
   public static String camelCaseConverter(String str){ //declare static method camelCaseConverter with one parameter
      String output = ""; //declare output as an empty String
      for(int k = 0; k <= str.length() - 1; k++){ //run a for loop for the entire string
         if(str.charAt(k) != ' '){ //if the current char does not equal a space
            output += str.substring(k, k + 1).toLowerCase(); //then add the current letter to the output
         }
         else{ //otherwise
            output += str.substring(k + 1, k + 2).toUpperCase(); //add to the output the next letter but upper cased
            k++; //skip the letter in the loop
            }
         }
      return output; //return the output
      
   }
}