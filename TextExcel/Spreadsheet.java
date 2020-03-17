/*
   Sahil Gupta
   Stutler
   APCSA
   3/16/2020
   
   TextCell Lab - use java and object oriented programming
      to create a spreadsheet in the java terminal */

public class Spreadsheet implements Grid {

   public Spreadsheet(){
      Cell[][] cellArray = new Cell[getRows() - 1][getCols() - 1];
      
      for(int i = 0; i < getRows() - 1; i++){
         for(int k = 0; k < getCols() - 1; k++){
            cellArray[i][k] = new EmptyCell();
         }
      }
   }

   @Override
   public String processCommand(String command) { //return the string given through the meh
      return command;
   }

   @Override
   public int getRows() { // get the number of rows
      return 20;
   }

   @Override
   public int getCols() { // get the number of columns
      return 12;
   }

   @Override
   public Cell getCell(Location loc) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String getGridText() {
      // TODO Auto-generated method stub
      return null;
   }
}