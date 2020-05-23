/*
   Sahil Gupta
   Stutler
   AP CS A
   5/19/20
   
   TextExcel - Write a program which creates spreadsheets
*/

public class TextCell implements Cell{ //class header
   //fields
   private String cellCon;
   
   //constructor
   public TextCell(String cellCon){
      this.cellCon = cellCon;
   }
   
   public String abbreviatedCellText(){ //abbreviatedCellText method header
      
      String small = this.cellCon.substring(1, this.cellCon.length() - 1); //remove the quotes
      
      //logic loop to figure out the cell text to display
      if(small.length() > 10){
         small = small.substring(0, 10);
      }else if(small.length() < 10){
         int len = small.length();
         for(int i = 0; i < 10 - len; i++){
            small += " ";
         }
      }      
      return small; //return the text
   }
   
   public String fullCellText(){
      return this.cellCon; //return the raw contents of the cell
   }
}