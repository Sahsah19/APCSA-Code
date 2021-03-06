/*
   Sahil Gupta
   Stutler
   AP CS A
   5/19/20
   
   TextExcel - Write a program which creates spreadsheets
*/
public class SpreadsheetLocation implements Location { //class initialization
   
   private String cellName; //field declaration
   
   public SpreadsheetLocation(String cellName) { //constructor
      this.cellName = cellName; //simply set cellName to the field
   }
 
   public int getRow() { //getRow method declaration
      String row = this.cellName.substring(1, this.cellName.length()); //get the row only
      return Integer.parseInt(row) - 1; //parse the string and return
   }

   
   public int getCol() { //getCol method declaration
      String col = this.cellName.substring(0, 1).toUpperCase(); //get the column only
      int colNum = 0; //int for column
      
      //switch case to find the specific number
      switch(col){ 
         case "A":
            colNum = 1;
            break;
         case "B":
            colNum = 2;
            break;
         case "C":
            colNum = 3;
            break;
         case "D": 
            colNum = 4;
            break;
         case "E":
            colNum = 5;
            break;
         case "F":
            colNum = 6;
            break;
         case "G":
            colNum = 7;
            break;
         case "H":
            colNum = 8;
            break;
         case "I":
            colNum = 9;
            break;
         case "J":
            colNum = 10;
            break;
         case "K":
            colNum = 11;
            break;
         case "L":
            colNum = 12;
            break;
      }
      return colNum - 1; //subtract 1 to find the index in array
   }
   
}
