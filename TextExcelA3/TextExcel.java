import java.io.FileNotFoundException;
import java.util.Scanner;

/*
   Sahil Gupta
   Stutler
   AP CS A
   5/22/20
   Text Excel - Use object oriented programming
      and other tools to create a virtual spreadsheet
*/
public class TextExcel { //class declaration

   public static void main(String[] args) { //main method
      
      //object declarations
      Spreadsheet s = new Spreadsheet();
      Scanner sc = new Scanner(System.in);
        
      //variable delcarations
      String update = "";
                        
      //starter print statements
      System.out.println("Welcome to Sahil's Spreadsheet!");
      System.out.println("Enter a command(type \"quit\" to exit program):");
      update = sc.nextLine();
      while(!update.equals("quit")){ //command loop
         System.out.println(s.processCommand(update)); //processCommand call
         System.out.println("Enter another command: "); //prompt user for another command
         update = sc.nextLine();
      }
      System.out.print("Thank you for using Sahil's Spreadsheet!"); //exit statement
   }
}
