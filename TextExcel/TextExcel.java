import java.io.FileNotFoundException;
import java.util.Scanner;

/*
   Sahil Gupta
   Stutler
   APCSA
   3/16/2020
   
   TextCell Lab - use java and object oriented programming
      to create a spreadsheet in the java terminal */

public class TextExcel { //class declaration

   public static void main(String[] args) { //main method
      
      //object declarations
      Spreadsheet s = new Spreadsheet();
      Scanner sc = new Scanner(System.in);
      TestsAll.A_Checkpoint1 test = new TestsAll.A_Checkpoint1();
      
      //variable delcarations
      String update = "";
      
      //test methods
      test.initializeGrid();
      test.testGetRows();
      test.testGetCols();
      test.testProcessCommand();
      test.testLongShortStringCell();
      test.testProcessCommandNonliteralEmpty();
      
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
